package test.preferences;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class ProperTypePref {

    static String key = "teststring";
    static String integerString = "123";

    static String key1 = "teststring1";
    static String testString = "testVaLue";

    static String key2 = "teststring2";
    static String doubleString = "1.2";

    static String key3 = "teststring3";
    static String booleanTrueString = "true";

    static String key4 = "teststring3";
    static String booleanFalseString = "false";


    static Map<String, Object> map = new HashMap<String, Object>();

    public static void main(String[] args) {
        map.clear();

        checkedAndPutObject(key, booleanTrueString);
        System.out.println("Boolean true test result: " + getFromStorage(key).getClass().equals(Boolean.class));
        System.out.println("Boolean true value result: " + getFromStorage(key));
        System.out.println("\n");
        checkedAndPutObject(key4, booleanFalseString);
        System.out.println("Boolean false test result: " + getFromStorage(key4).getClass().equals(Boolean.class));
        System.out.println("Boolean false value result: " + getFromStorage(key4));
        System.out.println("\n");
        checkedAndPutObject(key1, integerString);
        System.out.println("Integer test result: " + getFromStorage(key1).getClass().equals(Integer.class));
        System.out.println("Integer value result: " + getFromStorage(key1));
        System.out.println("\n");
        checkedAndPutObject(key2, doubleString);
        System.out.println("Double test result: " + getFromStorage(key2).getClass().equals(Double.class));
        System.out.println("Double value result: " + getFromStorage(key2));
        System.out.println("\n");
        checkedAndPutObject(key3, testString);
        System.out.println("String test result: " + getFromStorage(key3).getClass().equals(String.class));
        System.out.println("String value result: " + getFromStorage(key3));
    }

    private static void checkedAndPutObject(String name, Object value) {
        if (name != null && !name.equals("")) {
            putValueByType(name, value);
        }
    }

    private static void putValueByType(String name, Object value) {
        if (value.equals("true") || value.equals("false")) {
            putBoolean(name, value);
        } else if (isNumeric((String) value)) {
            putInteger(name, value);
        } else {
            try {
                putDouble(name, value);
            } catch (NumberFormatException nfe) {
                putToStorage(name, value);
            }
        }
    }

    private static void putBoolean(String name, Object value) {
        putToStorage(name, value.equals("true"));
    }

    private static void putInteger(String name, Object value) {
        int intValue = convertStringToInteger((String) value);
        putToStorage(name, intValue);
    }

    private static void putDouble(String name, Object value) {
        double v = Double.parseDouble((String) value);
        putToStorage(name, v);
    }

    private static Object getFromStorage(String name) {
        return map.get(name);
    }

    private static void putToStorage(String name, Object value) {
        map.put(name, value);
    }

    private static int convertStringToInteger(String string) {
        return Integer.parseInt(string);
    }

    private static boolean isNumeric(String test) {
        return StringUtils.isNumeric(test);
    }

}
