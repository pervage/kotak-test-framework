package org.qa.framework.utilities;

import lombok.extern.slf4j.Slf4j;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class CommonUtils {
    public static InputStream getResourceAsStream(String filePath){
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
    }

    public static String getEnv(){
        String testEnv = "testEnv";
        String value = System.getProperty(testEnv);
        if(value == null || value.isBlank() || value.isEmpty()){
            log.info("Environment selected is {}",System.getenv().get(testEnv).toLowerCase());
            return System.getenv().get(testEnv).toLowerCase();
        }else{
            //Local Execution
            log.info("Running Tests Locally {}",System.getProperty(testEnv).toLowerCase());
            return System.getProperty(testEnv).toLowerCase();
        }
    }

    public static void setEnv(String env){
        System.setProperty("testEnv",env.toLowerCase());
    }

    public static Properties getProperty(){
        String propFilePath = "application-"+getEnv().concat(".properties");
        Properties properties = new Properties();
        try {
            properties.load(getResourceAsStream(propFilePath));
            log.info("Properties File Loaded Successfully");
        }catch (Exception e){
            log.error("Exception is reading Properties File {}",e.getMessage());
        }
        return properties;
    }

    public static String getPropValue(String propKey){
        return getProperty().getProperty(propKey);
    }
}
