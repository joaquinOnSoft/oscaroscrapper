package com.joaquinonsoft.oscaroscrapper;

import com.joaquinonsoft.oscaroscrapper.dto.Brand;
import com.joaquinonsoft.oscaroscrapper.dto.Family;
import com.joaquinonsoft.oscaroscrapper.dto.Model;
import com.joaquinonsoft.oscaroscrapper.dto.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OscaroScraperTest {
    private static OscaroScrapper wrapper;

    @BeforeEach
    public void init(){
        //By default, Oscaro scraper is using "es" as default language
        wrapper = new OscaroScrapper();
    }

    @Test
    public void getBrands(){
        List<Brand> brands = wrapper.getBrands();
        Assertions.assertNotNull(brands);
        Assertions.assertEquals(121, brands.size());
        Assertions.assertEquals("ma-230", brands.getFirst().getId());
        Assertions.assertEquals("VOLKSWAGEN", brands.getFirst().getName());
        Assertions.assertEquals("VOLKSWAGEN", brands.getFirst().getFullName());
    }

    @Test
    public void getBrandsInFrench(){
        wrapper.setLang("fr");
        List<Brand> brands = wrapper.getBrands();
        Assertions.assertNotNull(brands);
        Assertions.assertEquals(121, brands.size());
        Assertions.assertEquals("ma-178", brands.getFirst().getId());
        Assertions.assertEquals("RENAULT", brands.getFirst().getName());
        Assertions.assertEquals("RENAULT", brands.getFirst().getFullName());
    }

    @Test
    public void getBrandsInPortuguese(){
        wrapper.setLang("pt");
        List<Brand> brands = wrapper.getBrands();
        Assertions.assertNotNull(brands);
        Assertions.assertEquals(121, brands.size());
        Assertions.assertEquals("ma-178", brands.getFirst().getId());
        Assertions.assertEquals("RENAULT", brands.getFirst().getName());
        Assertions.assertEquals("RENAULT", brands.getFirst().getFullName());
    }

    @Test
    public void getFamilies4Brand(){
        List<Family> families = wrapper.getFamilies4Brand("ma-178");
        Assertions.assertNotNull(families);
        Assertions.assertEquals(65, families.size());
        Assertions.assertEquals("fa-650", families.getFirst().getId());
        Assertions.assertEquals("Mégane", families.getFirst().getName());
    }


    @Test
    public void getModels4Family(){
        List<Model> models = wrapper.getModels4Family("fa-650");
        Assertions.assertNotNull(models);
        Assertions.assertEquals(30, models.size());
        Assertions.assertEquals("mo-1366", models.getFirst().getId());
        Assertions.assertEquals("II Hatchback (09/2002 - 10/2008)", models.getFirst().getName());
    }

    @Test
    public void getTypes4Model(){
        List<Type> types = wrapper.getTypes4Model("mo-7174");
        Assertions.assertNotNull(types);
        Assertions.assertEquals(5, types.size());
        Assertions.assertEquals("63835", types.getFirst().getId());
        Assertions.assertEquals("GrandCoupe 1.5 Blue dCi EDC6 115 cv Transmisión automática", types.getFirst().getName());
    }

    @Test
    public void getTypeDetails(){
        Type type = wrapper.getTypeDetails("63833");
        Assertions.assertNotNull(type);
        Assertions.assertEquals("RENAULT Mégane", type.getName());
        Assertions.assertEquals( "IV Fase 2 Sedan GrandCoupe 1.3 TCe 16V GPF EDC7 140 cv Transmisión automática", type.getComplementName());
        Assertions.assertEquals( "GrandCoupe 1.3 TCe 16V GPF EDC7 140 cv Transmisión automática", type.getFullFragmentName());
        Assertions.assertEquals("RENAULT Mégane IV Fase 2 Sedan GrandCoupe 1.3 TCe 16V GPF EDC7 140 cv Transmisión automática", type.getFullName());
        Assertions.assertEquals("Gasolina", type.getEnergy());
        Assertions.assertEquals("0", type.getAncestor(0));
        Assertions.assertEquals("ma-178", type.getAncestor(1));
        Assertions.assertEquals("fa-650", type.getAncestor(2));
        Assertions.assertEquals( "mo-7174", type.getAncestor(3));
    }

    //@Test
    // The execution fo this test takes too much time (commented)
    void getBrandsTypes(){
        List<Brand> brands = wrapper.getBrandsTypes();
        Assertions.assertNotNull(brands);
    }


    @Test
    void getBrandTypes(){
        Brand brand = wrapper.getBrandTypes(new Brand("ma-138", "SMART", "SMART"));
        Assertions.assertNotNull(brand);

        List<Family> families = brand.getFamilies();
        Assertions.assertNotNull(families);
        Assertions.assertEquals(6, families.size());
        Assertions.assertEquals("Fortwo", families.getFirst().getName());

        List<Model> models = families.getFirst().getModels();
        Assertions.assertNotNull(models);
        Assertions.assertEquals(8, models.size());
        Assertions.assertEquals("Coupe (451) (01/2007 - 11/2014)", models.getFirst().getName());

        List<Type> types = models.getFirst().getTypes();
        Assertions.assertNotNull(types);
        Assertions.assertEquals(12, types.size());
        Assertions.assertEquals("SMART Fortwo Coupe (451) ED 41 cv Transmisión automática", types.getFirst().getFullName());
    }
}
