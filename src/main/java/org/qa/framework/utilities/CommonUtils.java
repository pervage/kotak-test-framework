package org.qa.framework.utilities;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static String getFolderPath(String path) {
        String folderPath = System.getProperty("user.dir") + path;
        createDirectory(folderPath);
        return folderPath;
    }

    private static void createDirectory(String folderPath) {
        Path path = Paths.get(folderPath);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                log.info("Directory was created.\n"+folderPath);
            } catch (IOException exp) {
                System.out.println(exp.getMessage()+"\n"+exp);
            }
        }
        else {
            log.info("Directory is already present.\n"+folderPath);
        }
    }
}
