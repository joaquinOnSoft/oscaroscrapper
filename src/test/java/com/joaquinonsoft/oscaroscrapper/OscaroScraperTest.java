package com.joaquinonsoft.oscaroscrapper;

import com.joaquinonsoft.oscaroscrapper.dto.Brand;
import com.joaquinonsoft.oscaroscrapper.dto.Family;
import com.joaquinonsoft.oscaroscrapper.dto.Model;
import com.joaquinonsoft.oscaroscrapper.dto.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OscaroScraperTest {
    private static final OscaroScraper wrapper = new OscaroScraper();

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
}
