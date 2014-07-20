package test.controller;

import test.dto.Type;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mykolakozhemiaka on 20.07.14.
 */

@Named
@SessionScoped
public class StorageController implements Serializable{

    private List<Type> properties = new LinkedList<Type>();

    public List<Type> getProperties() {
        return properties;
    }

}
