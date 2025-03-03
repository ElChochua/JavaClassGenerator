package org.example.util;

import javassist.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;

public class ClassGenerator {
    private JSONArray jsonArray;

    public ClassGenerator(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public void Generate() {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            String type = object.getString("type");

            if (type.equals("Package")) {
                GeneratePackage(object.getString("name"));
                JSONArray classes = object.getJSONArray("classes");
                for (int j = 0; j < classes.length(); j++) {
                    GenerateClass(classes.getJSONObject(j), object.getString("name"));
                }
            } else if (type.equals("Class")) {
                GenerateClass(object, null);
            }
        }
    }

    public void GeneratePackage(String packageName) {
        File packageDir = new File("output/" + packageName);
        if (!packageDir.exists()) packageDir.mkdirs();
    }

    public void GenerateClass(JSONObject classObj, String packageName) {
        try {
            String className = classObj.getString("name");
            String fullClassName = (packageName != null) ? packageName + "." + className : className;
            CtClass ctClass = ClassPool.getDefault().makeClass(fullClassName);

            JSONArray properties = classObj.getJSONArray("fields");
            for (int i = 0; i < properties.length(); i++) {
                JSONObject property = properties.getJSONObject(i);
                String fieldName = property.getString("name");
                String fieldType = property.getString("type");
                // Convert primitive types to CtClass
                CtClass fieldClass = getCtClass(fieldType);

                CtField field = new CtField(fieldClass, fieldName, ctClass);
                ctClass.addField(field);
            }

            ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));
            String outputPath = (packageName != null) ? "output/" + packageName : "output";
            ctClass.writeFile(outputPath);

            System.out.println("Generated Class: " + fullClassName);
        } catch (NotFoundException | CannotCompileException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private CtClass getCtClass(String type) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        switch (type) {
            case "int": return CtClass.intType;
            case "double": return CtClass.doubleType;
            case "boolean": return CtClass.booleanType;
            case "float": return CtClass.floatType;
            case "char": return CtClass.charType;
            case "long": return CtClass.longType;
            case "short": return CtClass.shortType;
            case "byte": return CtClass.byteType;
            default: return pool.get("java.lang." + type);
        }
    }
}
