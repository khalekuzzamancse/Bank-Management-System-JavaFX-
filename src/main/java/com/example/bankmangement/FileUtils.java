package com.example.bankmangement;

import java.lang.reflect.Field;
import java.util.List;

public class FileUtils {
    public static <T, F> T getObjectByField(String fieldName, F fieldValue, List<T> objects) {
        if (objects == null || objects.isEmpty()) {
            return null;
        }
        try {
            Field field = getField(fieldName, objects.get(0).getClass());
            field.setAccessible(true);
            return objects.stream()
                    .filter(o -> {
                        try {
                            return fieldValue.equals(field.get(o));
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException("Failed to access field", e);
                        }
                    })
                    .findFirst()
                    .orElse(null);
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("Field not found: " + fieldName, e);
        }
    }

    private static Field getField(String fieldName, Class<?> cls) throws NoSuchFieldException {
        try {
            return cls.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class<?> superClass = cls.getSuperclass();
            if (superClass == null) {
                throw e;
            }
            return getField(fieldName, superClass);
        }
    }
}

