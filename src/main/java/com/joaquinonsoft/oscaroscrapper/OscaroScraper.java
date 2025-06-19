package com.joaquinonsoft.oscaroscrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaquinonsoft.oscaroscrapper.dto.Brand;
import com.joaquinonsoft.oscaroscrapper.dto.Family;
import com.joaquinonsoft.oscaroscrapper.dto.Model;
import com.joaquinonsoft.oscaroscrapper.dto.Type;
import com.joaquinonsoft.oscaroscrapper.pojo.Ancestor;
import com.joaquinonsoft.oscaroscrapper.pojo.Child;
import com.joaquinonsoft.oscaroscrapper.pojo.Vehicle;
import com.joaquinonsoft.oscaroscrapper.pojo.VehiclesMng;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class OscaroScraper {

    private static final String BASE_URL = "https://www.oscaro.es";
    private static final String VEHICLES_URL = "/xhr/nav/vehicles/%LANG%/%LANG%?vehicles-id=%ID%&tree-level=%LEVEL%&page-type=home";

    public static final String LEVEL_PLACEHOLDER = "%LEVEL%";
    public static final String LANG_PLACEHOLDER = "%LANG%";
    public static final String ID_PLACEHOLDER = "%ID%";

    protected static final Logger log = LogManager.getLogger(OscaroScraper.class);

    /**
     * Recover all the families, models and types for all the brands
     * @return List of brands with all the families, models and types
     */
    public List<Brand> getBrandsTypes(){
        List<Brand> brands = getBrands();

        if(brands != null){
            int numBrands = brands.size();
            // Adding families for each brand
            for (int i=0; i<numBrands; i++) {
                brands.set(i, getBrandTypes(brands.get(i)));
            }
        }

        return brands;
    }

    /**
     * Recover all the families, models and types for a given brand
     * @param brand - Brand to get all the families, models and types
     * @return List of brands with all the families, models and types for a given brand
     */
    public Brand getBrandTypes(Brand brand){
        List<Family> families;
        List<Model> models;
        List<Type> types;

        if (brand != null) {
            log.debug(brand.getName());
            families = getFamilies4Brand(brand.getId());

            if (families != null) {
                brand.addFamilies(families);

                // Adding models for each family
                for (Family family : families) {
                    log.debug("\t{}", family.getName());
                    models = getModels4Family(family.getId());
                    if (models != null) {
                        family.addModels(models);

                        // Adding types for each model
                        for (Model model : models) {
                            log.debug("\t\t{}", model.getName());
                            types = getTypes4Model(model.getId());
                            if (types != null) {
                                for(Type type: types) {
                                    log.debug("\t\t\t{}", type.getName());
                                    type = getTypeDetails(type.getId());
                                    model.addType(type);
                                }
                            }
                        }
                    }
                }
            }
        }

        return brand;
    }

    protected List<Brand> getBrands(){
        List<Brand> brands = null;

        VehiclesMng vehicles = readURL(getURL("0", Level.ROOT));

        if(vehicles != null && vehicles.getVehicles() != null && !vehicles.getVehicles().isEmpty()) {
            brands = new LinkedList<>();
            for(Child child: vehicles.getVehicles().getFirst().getChildren()){
                brands.add(new Brand(child.getId(), child.getLabels().getLabel().getEs(), child.getLabels().getFullLabelFragment().getEs()));
            }
        }

        return brands;
    }

    protected List<Family> getFamilies4Brand(String brandId){
        List<Family> families = null;

        VehiclesMng vehicles = readURL(getURL(brandId, Level.BRAND));

        if(vehicles != null && vehicles.getVehicles() != null && !vehicles.getVehicles().isEmpty()) {
            families = new LinkedList<>();
            for(Child child: vehicles.getVehicles().getFirst().getChildren()){
                families.add(new Family(child.getId(), child.getLabels().getFullLabelFragment().getEs()));
            }
        }

        return families;
    }

    protected List<Model> getModels4Family(String familyId){
        List<Model> models = null;

        VehiclesMng vehicles = readURL(getURL(familyId, Level.FAMILY));

        if(vehicles != null && vehicles.getVehicles() != null && !vehicles.getVehicles().isEmpty()) {
            models = new LinkedList<>();
            for(Child child: vehicles.getVehicles().getFirst().getChildren()){
                models.add(new Model(child.getId(), child.getLabels().getFullLabelFragment().getEs()));
            }
        }

        return models;
    }

    protected List<Type> getTypes4Model(String modelId){
        List<Type> types = null;

        VehiclesMng vehicles = readURL(getURL(modelId, Level.MODEL));

        if(vehicles != null && vehicles.getVehicles() != null && !vehicles.getVehicles().isEmpty()) {
            types = new LinkedList<>();
            for(Child child: vehicles.getVehicles().getFirst().getChildren()){
                types.add(new Type(child.getId(), child.getLabels().getFullLabelFragment().getEs()));
            }
        }

        return types;
    }

    protected Type getTypeDetails(String typeId){
        Type type = null;

        VehiclesMng vehicles = readURL(getURL(typeId, Level.TYPE));

        if(vehicles != null && vehicles.getVehicles() != null && !vehicles.getVehicles().isEmpty()) {
            Vehicle child = vehicles.getVehicles().getFirst();
            type = new Type(child.getId(),
                    child.getLabels().getCoreLabel().getEs(),
                    child.getLabels().getComplementLabel().getEs(),
                    child.getLabels().getFullLabelFragment().getEs(),
                    child.getLabels().getFullLabel().getEs(),
                    child.getEnergy().getLabel().getEs()
                    );

            for(Ancestor ancestor: child.getAncestors()) {
                type.addAncestor(ancestor.getId());
            }
        }

        return type;
    }

    private VehiclesMng readURL(URL url) {
        VehiclesMng vehicles = null;


        try {
            Scanner scanner = new Scanner(url.openStream(), StandardCharsets.UTF_8);
            scanner.useDelimiter("\\A");
            String jsonString =  scanner.hasNext() ? scanner.next() : "";

            ObjectMapper MAPPER = new ObjectMapper();
            vehicles = MAPPER.readValue(jsonString, VehiclesMng.class);
        } catch (JsonMappingException ex) {
            log.error("JSON Mapping: ", ex);
        } catch (JsonProcessingException ex) {
            log.error("JSON processing: ", ex);
        } catch (MalformedURLException ex) {
            log.error("Malformed URL: ", ex);
        } catch (IOException ex) {
            log.error("I/O error: ", ex);
        }

        return vehicles;
    }


    /**
     * Generate the URL to recover the vehicle information
     * URL examples:
     * <ul>
     *     <li><a href="https://www.oscaro.com/xhr/nav/vehicles/fr/fr?vehicles-id=0&tree-level=root&init=true&page-type=home">Brands (all)</a></li>
     *     <li><a href="https://www.oscaro.com/xhr/nav/vehicles/fr/fr?vehicles-id=ma-178&tree-level=brand&page-type=home">Families for Brand</a></li>
     *     <li><a href="https://www.oscaro.com/xhr/nav/vehicles/fr/fr?vehicles-id=fa-650&tree-level=family&page-type=home">Models for Family</a></li>
     *     <li><a href="https://www.oscaro.com/xhr/nav/vehicles/fr/fr?vehicles-id=mo-7174&tree-level=model&page-type=home">Types for Model</a></li>
     *     <li><a href="https://www.oscaro.com/xhr/nav/vehicles/fr/fr?vehicles-id=63833&tree-level=type&page-type=home">type</a></li>
     * </ul>
     * @param id - Vehicle identifier
     * @param level - Information level. Possible values: root, brand, family, model
     * @return URL to recover
     */
    private URL getURL(String id, Level level) {
        URL url = null;
        String lang = "es";

        String urlStr = BASE_URL + VEHICLES_URL
                .replace(ID_PLACEHOLDER, id)
                .replace(LEVEL_PLACEHOLDER, level.toString())
                .replace(LANG_PLACEHOLDER, lang);

        if(level.toString().compareToIgnoreCase("root") == 0) {
            urlStr += "&init=true";
        }

        try {
            url = new URI(urlStr).toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            log.error("", e);
        }

        return url;
    }

    private enum Level{
        ROOT("root"),
        BRAND("brand"),
        FAMILY("family"),
        MODEL("model"),
        TYPE("type");

        private final String label;

        Level(String label){
            this.label = label;
        }

        @Override
        public String toString(){
            return label;
        }
    }
}
