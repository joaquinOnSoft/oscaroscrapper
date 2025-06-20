package com.joaquinonsoft.oscaroscrapper.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

public class FileUtilTest {
    private static final String EXAMPLE_FILE_NAME = "renault.csv";

    @Test
    public void getFileFromResources() {
        File f = FileUtil.getFileFromResources(EXAMPLE_FILE_NAME);
        assertNotNull(f);
        assertTrue(f.exists());
    }
}