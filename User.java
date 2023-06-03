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

// abstract class for generic user of the system
abstract class User {
    boolean adminStatus;
    boolean guestStatus;
    boolean loggedIn = false;
    public String enteredUserName;
    public String enteredPassword;
    public String age = "20";

    // clears all temporary files
    static void clearTemp() 
     {
        File tempFile = new File("temp.txt");
        if (tempFile.exists())
            tempFile.delete();
     }

    // matches password with file
    static boolean matchPasswordFromFile(String name, String pass) 
     {
        try
         {
            try (Scanner fileReader = new Scanner(new File("userInfo.txt"))) {
                while (fileReader.hasNextLine())
                {
                    String current = fileReader.nextLine();
                    if (current.split(",")[0].equals(name))
                    {
                        return current.split(",")[1].equals(pass);
                    }
                }
            }
        }
        catch (IOException e) 
         {
            System.out.println(e);
         }
        return false;
    }

    // sets files initially, on the start of the program
    static void setProjectEnvironment()
     {
        try 
         {
            File medicineFile = new File("medicine.txt");
            File adminInfoFile = new File("adminInfo.txt");
            File userInfoFile = new File("userInfo.txt");
            if (!medicineFile.exists()) 
             {
                try (FileWriter fileWriter = new FileWriter(medicineFile)) {
                    fileWriter.write("");
                }
             }
            if (!adminInfoFile.exists()) 
            {
                try (FileWriter fileWriter = new FileWriter(adminInfoFile)) {
                    fileWriter.write("admin123");
                }
            }
            if (!userInfoFile.exists()) 
            {
                try (FileWriter fileWriter = new FileWriter(userInfoFile)) {
                    fileWriter.write("");
                }
            }

        } 
        catch (IOException e) 
         {
            System.out.println("IoException : " + Arrays.toString(e.getStackTrace()));
         }
    }

    // prints the storage of the farmacy
    static void printCurrentStorage() 
     {
        try 
         {
            try (Scanner fileReader = new Scanner(new File("Medicine.txt"))) {
                System.out.println("Serial" + " " + " Name" + "  " + "      Price");
                while (fileReader.hasNextLine()) {
                    String current = fileReader.nextLine();
                    String serialNo = current.split(",")[0];
                    String medicineName = current.split(",")[1];
                    String prizeString = current.split(",")[2];
                    System.out.println(serialNo + "       " + medicineName + "        " + prizeString);
                }
            }
        }
        catch (IOException e)
         {
            
         }
    }

    // changes admin password
    static void setAdminPasswordToFile(String newPassword)
     {
        try {
            try (FileWriter fileWriter = new FileWriter("adminInfo.txt")) {
                fileWriter.write(newPassword);
            }
        } catch (IOException e) {
            System.out.println("IoException : " + Arrays.toString(e.getStackTrace()));
        }
    }

    // finds nth serialled medicine from storage (file)
    static String findMedicine(String serialNo) {
        String result = "";
        try {
            try (Scanner fileReader = new Scanner(new File("Medicine.txt"))) {
                while (fileReader.hasNextLine()) {
                    String current = fileReader.nextLine();
                    if (current.split(",")[0].equals(serialNo)) {
                        result = current;
                        return result;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("IoException : " + Arrays.toString(e.getStackTrace()));
        }
        return result;
    }

}