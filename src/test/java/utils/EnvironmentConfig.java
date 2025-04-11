package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentConfig {
    private String environmentUrl;

    public EnvironmentConfig(String env) {
        String propertiesFilePath = "src/test/resources/" + env + ".properties";
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(propertiesFilePath)) {
            properties.load(fis);
            this.environmentUrl = properties.getProperty("environment.url");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load environment properties");
        }
    }

    public String getEnvironmentUrl() {
        return environmentUrl;
    }
}