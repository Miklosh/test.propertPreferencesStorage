package test.controller;

import test.dto.Type;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by mykolakozhemiaka on 20.07.14.
 */

@Named
@RequestScoped
public class PropertyController implements Serializable{

    private String property;

    private String key;

    private String type;

    @Inject
    private StorageController properties;

    public void storeType() {
        if (property.equals("Boolean")) {
            Boolean b = type.equals("true");
            properties.getProperties().add(new Type(key,b,b.getClass().toString()));
        } else if (property.equals("Integer")) {
            Integer i = Integer.parseInt(type);
            properties.getProperties().add(new Type(key,i,i.getClass().toString()));
        } else if (property.equals("Double")) {
            Double d = Double.parseDouble(type);
            properties.getProperties().add(new Type(key,d,d.getClass().toString()));
        } else {
            properties.getProperties().add(new Type(key,type,type.getClass().toString())); // store as a String
        }
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
