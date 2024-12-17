package edu.mcw.scge.datamodel;

import org.springframework.context.annotation.Configuration;

@Configuration("storageProperties")
public class StorageProperties {
    private String location ="C:/upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
