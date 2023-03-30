package com.example.bankmangement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeaseFao {
    private static final String tableName = "LeaseTable.dat";

    public static void writeToFile(List<Lease> leaseList) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(tableName))) {
            outputStream.writeObject(leaseList);
            System.out.println("Successfully added to:" + tableName);
        } catch (IOException e) {
            System.out.println("Failed added to:" + tableName);
            e.printStackTrace();
        }
    }

    public static List<Lease> readFromFile() throws IOException, ClassNotFoundException {
        List<Lease> leaseList = new ArrayList<>();
        File file = new File(tableName);
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                leaseList = (List<Lease>) inputStream.readObject();
                System.out.println("Successfully read  from:" + tableName);
            } catch (Exception e) {
                System.out.println("Failed read  from:" + tableName);
                e.getStackTrace();
            }
        }
        return leaseList;
    }


    public static void addToTable(Lease lease) throws IOException, ClassNotFoundException {
        //this first read the list
        //then add the new object to the list
        //if then out the list into the file(table)
        List<Lease> boxInfoList = readFromFile();
        boxInfoList.add(lease);
        writeToFile(boxInfoList);
    }

}
