package com.example.bankmangement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Fao<T extends Serializable> implements Serializable {
    private static <T extends Serializable> void writeToFile(String tableName, List<T> list) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(tableName))) {
            outputStream.writeObject(list);
            System.out.println("Successfully added to:" + tableName);
        } catch (IOException e) {
            System.out.println("Failed added to:" + tableName);
            e.printStackTrace();
        }
    }

    public static <T extends Serializable> List<T> read(String tableName){
        List<T> list = new ArrayList<>();
        File file = new File(tableName);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                list = (List<T>) inputStream.readObject();
                System.out.println("Successfully read  from:" + tableName);
            } catch (Exception e) {
                System.out.println("Failed read  from:" + tableName);
                e.getStackTrace();
            }
        }
        return list;
    }

    public static <T extends Serializable> void write(String tableName, T lease){
        //this first read the list
        //then add the new object to the list
        //if then out the list into the file(table)
        List<T> list = read(tableName);
        list.add(lease);
        try {
            writeToFile(tableName, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
