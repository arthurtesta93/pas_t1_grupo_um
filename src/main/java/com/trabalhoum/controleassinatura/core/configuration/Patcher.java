package com.trabalhoum.controleassinatura.core.configuration;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class Patcher {

    public static void internPatcher(Object existInstance, Object incompleteInstance) throws IllegalAccessException {

        //GET THE COMPILED VERSION OF THE CLASS
        Class<?> existClass= existInstance.getClass();
        Class<?> incompleteInstance= incompleteInstance.getClass();

        Field[] incompleteFields=incompleteInstance.getDeclaredFields();
        System.out.println(internFields.length);
        for(Field field : internFields){
            System.out.println(field.getName());
            //CANT ACCESS IF THE FIELD IS PRIVATE
            field.setAccessible(true);

            //CHECK IF THE VALUE OF THE FIELD IS NOT NULL, IF NOT UPDATE EXISTING INTERN
            Object value=field.get(incompleteIntern);
            if(value!=null){
                field.set(existingIntern,value);
            }
            //MAKE THE FIELD PRIVATE AGAIN
            field.setAccessible(false);
        }

    }
}
