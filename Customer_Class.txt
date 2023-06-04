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
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// customer class
class Customer extends User
 {
    ArrayList<Pair> Cart = new ArrayList<>();
    String due = "";
    Double threshold = 500.0;

    // for guest User
    Customer() 
     {
        super.guestStatus = true;
     }

    // for login
    Customer(String enteredUserName, String enteredPassword)
     {
        super.enteredUserName = enteredUserName;
        super.enteredPassword = enteredPassword;
     }
    // change password for current user
    // for sign up

    // buying method for unlogged in users
    String buyInGuestMode(String nth, double amount) 
     {
        String reply = "";
        String[] medicineInfo = findMedicine(nth).split(",");
        double price = (double) (Double.valueOf(medicineInfo[2]));
        if (amount >= price)
            reply = "Bought :" + medicineInfo[1] + "\nCost: " + medicineInfo[2] + "\n" + "Recievable : "
                    + (amount - price);
        else
            reply = "Couldn't buy the item due to insufficient balance.";
        return reply;
     }

    // paying method for logged in users ( clears cart by buying them immedietly)
    String payInLoggedInMode(double amount)
     {
        String reply = "";
        double price = (double) (Double.valueOf(due));
        if (price == 0)
            reply = "no items in cart";
        else if (amount >= price)
            reply = """
                    Payed for : cart 
                    Cost: """ + price + "\n" + "Recievable :" + (amount - price);
        else
            reply = "Couldn't buy the item due to insufficient balance";
        return reply;
     }

    // adds medicine to arraylist of cart
    void addToCart(String nth) 
     {
        String[] medicineInfo = findMedicine(nth).split(",");
        boolean added = false;
        for (int i = 0; i < Cart.size(); i++) {
            if (Cart.get(i).value1.equals(medicineInfo[1])) {
                added = true;
            }
        }
        if (!added)
            Cart.add(new Pair(medicineInfo[1], medicineInfo[2]));
    }

    // removes medicine from arraylist of cart
    void removeFromCart(String nth) {
        String[] medicineInfo = findMedicine(nth).split(",");
        for (int i = 0; i < Cart.size(); i++) {
            if (Cart.get(i).value1.equals(medicineInfo[1])) {
                Cart.remove(i);
            }
        }
    }

   
    void printCart() {
        for (Pair pair : Cart) {
            System.out.println(pair.value1 + " " + pair.value2);
        }
        System.out.println("Due (after bonus if theshold crossed) :" + due);
    }

    // processes needed cart string
    String processCart() {

        String processedString = super.enteredUserName + "," + super.enteredPassword + "," + super.age + ",";
        double sum = 0.0;
        for (int i = 0; i < Cart.size(); i++) {
            sum = (double) (Double.valueOf(Cart.get(i).value2)) + sum;
            processedString = processedString + Cart.get(i).value1 + "," + Cart.get(i).value2;
            if (i != (Cart.size() - 1))
                processedString += ",";
        }
        if (sum > threshold)
            sum = sum - (sum / 10);
        due = sum + "";
        return processedString;
    }

    // updates the cart value of file with the arraylist one
    void updateCart() {
        try {
            File userInfoFile = new File("userInfo.txt");
            File tempFile = new File("temp.txt");
            Scanner fileReader = new Scanner(userInfoFile);
            FileWriter fileWriter = new FileWriter(tempFile, false);
            while (fileReader.hasNextLine()) {
                String current = fileReader.nextLine();

                if (current.split(",")[0].equals(super.enteredUserName)) {
                    fileWriter.write(processCart() + "\n");
                } else {
                    fileWriter.write(current + "\n");
                }
            }
            fileReader.close();
            fileWriter.close();
            userInfoFile.delete();
            fileReader = new Scanner(tempFile);
            fileWriter = new FileWriter(userInfoFile, false);
            while (fileReader.hasNextLine()) {
                fileWriter.write(fileReader.nextLine() + "\n");
            }

            fileReader.close();
            fileWriter.close();

        } catch (IOException e) {
        }
    }
}