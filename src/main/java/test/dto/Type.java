package test.dto;

/**
 * Created by mykolakozhemiaka on 20.07.14.
 */
public class Type {

    public Type() {
    }

    public Type(String key, Object type) {
        this.key = key;
        this.type = type;
    }

    public Type(String key, Object type, String classType) {
        this.key = key;
        this.type = type;
        this.classType = classType;
    }

    private String key;
    private Object type;
    private String classType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
