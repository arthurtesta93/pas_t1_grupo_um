package com.trabalhoum.controleassinatura.core.configuration;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class Patcher {

    public static void internPatcher(Object existInstance, Object incompleteInstance) throws IllegalAccessException, NoSuchFieldException {

        //GET THE COMPILED VERSION OF THE CLASS
        Class<?> existClass = existInstance.getClass();
        Class<?> incompleteClass = incompleteInstance.getClass();

        Field[] incompleteFields=incompleteClass.getDeclaredFields();
        System.out.println(incompleteFields.length);
        for(Field field : incompleteFields){
            System.out.println(field.getName());
            //CANT ACCESS IF THE FIELD IS PRIVATE
            field.setAccessible(true);

            //CHECK IF THE VALUE OF THE FIELD IS NOT NULL, IF NOT UPDATE EXISTING INTERN
            Object value=field.get(incompleteClass);
            if(value!=null){
                field.set(existClass,value);
                Field existingField = existClass.getDeclaredField(field.getName());
                existingField.setAccessible(true);
                existingField.set(existInstance, value);
                existingField.setAccessible(false);
            }
        }

    }
}

