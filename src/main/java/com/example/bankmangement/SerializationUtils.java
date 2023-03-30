package com.example.bankmangement;

import java.io.*;
import java.util.List;

public class SerializationUtils {
    public static void writeListToFile(List<X> xList, String filePath) {
        try (FileOutputStream fileOutStream = new FileOutputStream(filePath);
             ObjectOutputStream objOutStream = new ObjectOutputStream(fileOutStream)) {
            objOutStream.writeObject(xList);
            System.out.println("Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<X> readListFromFile(String filePath) {
        List<X> xList = null;
        try (FileInputStream fileInStream = new FileInputStream(filePath);
             ObjectInputStream objInStream = new ObjectInputStream(fileInStream)) {
            xList = (List<X>) objInStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return xList;
    }
}
