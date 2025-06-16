package com.joaquinonsoft.oscaroscrapper;

import com.joaquinonsoft.oscaroscrapper.dto.Brand;
import com.joaquinonsoft.oscaroscrapper.dto.Family;
import com.joaquinonsoft.oscaroscrapper.dto.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OscaroScraperTest {
    private static OscaroScraper wrapper = new OscaroScraper();

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
    public void getFamilies(){
        List<Family> families = wrapper.getFamilies4Brand("ma-178");
        Assertions.assertNotNull(families);
        Assertions.assertEquals(65, families.size());
        Assertions.assertEquals("fa-650", families.getFirst().getId());
        Assertions.assertEquals("Mégane", families.getFirst().getName());
    }


    @Test
    public void getModels(){
        List<Model> models = wrapper.getModels4Family("ma-178");
        Assertions.assertNotNull(models);
        Assertions.assertEquals(65, models.size());
        Assertions.assertEquals("fa-650", models.getFirst().getId());
        Assertions.assertEquals("Mégane", models.getFirst().getName());
    }
}
