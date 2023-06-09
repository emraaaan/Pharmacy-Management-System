package com.mycompany.pharmacy_management_system;

/*
<< Pharmacy Management System Project>>
Date of Presentation : 16 June 2023
Group : I   
Name of Group members : Md. Emran Hossain (Id-2221132642) Hossain Mohammad Maruf (Id-1712604042) Ariful Anam Afridi(Id-2222859042)
Instructor : ASM Sabiqul Hassan
Section : CSE215L.16
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// Admin class
class Admin extends User 
 {
    Admin(String enteredPassword) 
     {
        super.enteredUserName = "admin";
        super.enteredPassword = enteredPassword;
        super.adminStatus = true;
        getAdminPasswordFromFile();
        verifyAdminStatus();
    }
    // changePassword


    //verifies admin by matching password stored in file
    boolean verifyAdminStatus() {
        getAdminPasswordFromFile();
        super.loggedIn = super.enteredPassword.equals(getAdminPasswordFromFile());
        return (super.loggedIn);
    }

    // returns admins password
    String getAdminPasswordFromFile() {
        try {
            try (Scanner fileReader = new Scanner(new File("adminInfo.txt"))) {
                while (fileReader.hasNextLine()) {
                    return fileReader.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("IoException : " + Arrays.toString(e.getStackTrace()));
        }
        return "";
    }

    // returns admins password
    public String getAdminPassword() {
        return getAdminPasswordFromFile();
    }

    // adds medicine to storage
    void addMedicine(String medicineName, double medicinePrice) {
        boolean found = false;
        if (!super.loggedIn)
            return;
        try {
            int serialNo = 1;
            FileWriter fileWriter = new FileWriter("temp.txt");
            Scanner fileReader = new Scanner(new File("Medicine.txt"));
            while (fileReader.hasNextLine()) {
                String current = fileReader.nextLine();
                if (current.split(",")[1].equals(medicineName)) {
                    found = true;
                    fileWriter.write(serialNo + "," + medicineName + "," + medicinePrice + "\n");
                } else {
                    fileWriter.write(current + "\n");
                    serialNo++;
                }
            }
            if (!found)
                fileWriter.write(serialNo + "," + medicineName + "," + medicinePrice + "\n");
            fileWriter.close();
            fileReader.close();
            File med = new File("Medicine.txt");
            if (med.exists())
                med.delete();
            fileWriter = new FileWriter("Medicine.txt");
            fileReader = new Scanner(new File("temp.txt"));
            while (fileReader.hasNextLine()) {
                fileWriter.write(fileReader.nextLine() + "\n");
            }
            fileWriter.close();
            fileReader.close();
            File temp = new File("temp.txt");
            temp.delete();
        } catch (IOException e) {
            System.out.println("IoException : " + Arrays.toString(e.getStackTrace()));
        }
    }
    // removes medicine from storage
    boolean removeMedicine(String medicineName) {
        boolean deleted = false;
        if (!super.loggedIn)
            return deleted;
        try {
            FileWriter fileWriter = new FileWriter("temp.txt", true);
            Scanner fileReader = new Scanner(new File("Medicine.txt"));
            while (fileReader.hasNextLine()) {
                String current = fileReader.nextLine();
                String serialNo = current.split(",")[0];
                String Name = current.split(",")[1];
                String priceString = current.split(",")[2];
                if (current.split(",")[1].equals(medicineName)) {
                    deleted = true;
                } else {
                    if (deleted)
                        serialNo = ((int) Integer.valueOf(serialNo) - 1) + "";
                    fileWriter.write(serialNo + "," + Name + "," + priceString + "\n");
                }
            }
            fileWriter.close();
            fileReader.close();
            fileWriter = new FileWriter("Medicine.txt", false);
            fileReader = new Scanner(new File("temp.txt"));
            while (fileReader.hasNextLine()) {
                fileWriter.write(fileReader.nextLine() + "\n");
            }
            fileWriter.close();
            fileReader.close();
            File temp = new File("temp.txt");
            temp.delete();
        } catch (IOException e) {
            System.out.println("IoException : " + Arrays.toString(e.getStackTrace()));
        }
        return deleted;
    }

}