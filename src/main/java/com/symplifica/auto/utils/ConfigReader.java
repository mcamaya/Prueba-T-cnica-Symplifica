package com.symplifica.auto.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private static final String CONFIG_PATH = "src/test/resources/config.properties";

    static {
        try {
            FileInputStream fis = new FileInputStream(CONFIG_PATH);
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar config.properties: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Propiedad '" + key + "' no encontrada en config.properties");
        }
        return value;
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }

}