package org.example.util;
import javassist.*;
import java.util.HashMap;
public class ClassGenerator {
    public ClassGenerator() {}
    private String className = "GeneratedClass";
    private HashMap<String, Object> properties = new HashMap<>();
    private String[] propertyNames;
    private Object[] propertyTypes;
    /**TO DO: add interface generation
    ** Verify type of the class
     * Method to generate a class with the given properties
     * @param className ? []
     * @param propertietyNames[]
     * @param propertyTypes[]
     * @return
     * Constructor to generate a full Package with the given properties and classes
     * Method to verify dataTypes from the properties
     * Method to Manipulate the properties
     * Method to generate the class
     * MultipleClassesGenerator
     * Method to generate multiple classes
     * Method to generate multiple classes with the same properties
     * Method to generate multiple classes with different properties
     * Method to generate multiple classes with different properties and different names
     * Method to generate multiple classes with different properties and the same names
     * /
    **/
    public ClassGenerator(String className,HashMap<String, Object> properties){
        this.properties = properties;
        this.className = className;
    }
}
