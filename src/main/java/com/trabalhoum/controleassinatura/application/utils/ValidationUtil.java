package com.trabalhoum.controleassinatura.application.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidationUtil {

    public static List<String> getMissingFields(Object obj) {
        List<String> missingFields = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(obj) == null){
                    missingFields.add(field.getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return missingFields;
    }
}
