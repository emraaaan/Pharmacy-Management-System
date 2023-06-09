package com.mycompany.pharmacy_management_system;


import java.util.*;



public class Main
 {
 
    static Scanner inp = new Scanner(System.in);


    public static void main(String[] args) 
      {
        User.setProjectEnvironment();
        System.out.println("\t ***** Brothers Pharmacy *****\n");
        String operation;

        boolean on = true;
    
        while (on)
          {
            inp = new Scanner(System.in);
            System.out.println("\t<<Welcome To The Home Of Medicine>>\n ");
            System.out.println("> Log in  \n> Sign up  \n> Exit ");
             System.out.println("Please Enter Your Desired Option: ");
            operation = inp.nextLine();

           
          
            if (operation.equals("Log in")) 
             {
                System.out.println("\nLog in as: ");
                System.out.println("Admin ||  Customer ||  Guest ||  Go Back");
                   System.out.println("Please Enter Your Desired Option: ");
                operation = inp.nextLine();
                switch (operation) {
                    case "Admin" -> adminTester();
                    case "Customer" -> customerTester();
                    case "Guest" -> guestTester();
                    default -> {
                        continue;
                    }
                }
            }
            if (operation.equals("Sign up")) {
                System.out.println("Please Enter Name,  Password and Age to Sign up : ");
                inp.nextLine();
                inp.nextLine();
                inp.nextLine();
                System.out.println("Account Successfully Created .... \n");
            }
            if (operation.equals("Exit")) {
                System.out.println("Exiting Brothers Pharmacy....\n");
                Credit.printNames();
                on = false;
            }
        }

    }
   
    static void customerTester() {
        System.out.println("Enter Username and Password :  ");
        inp = new Scanner(System.in);
        String name, pass;
        name = inp.nextLine();
        pass = inp.nextLine();
        Customer customer = new Customer(name, pass);
        if (User.matchPasswordFromFile(name, pass)) {
            System.out.println("Successfully Logged in....\n");
        } else {
            System.out.println("Wrong Username or Password . . .");
            return;
        }
        boolean back = false;
        while (!back)
         {
            System.out.println("Add To Cart ||  Remove From Cart || Pay Bill || Go Back");
             System.out.println("Please Enter Your Desired Option: ");
            String operation = inp.nextLine();
            switch (operation) {
                case "Add To Cart" ->                     {
                        User.printCurrentStorage();
                        System.out.println("\nEnter Serial No : ");
                        String nth = inp.nextLine();
                        customer.addToCart(nth);
                        customer.processCart();
                        customer.updateCart();
                        User.clearTemp();
                        System.out.println("Item Successfully Added To Cart . . .\n");
                        System.out.println("My Cart : ");
                        customer.printCart();
                    }
                case "Remove From Cart" ->                     {
                        User.printCurrentStorage();
                        System.out.println("\nEnter Serial No: ");
                        String nth = inp.nextLine();
                        customer.removeFromCart(nth);
                        customer.processCart();
                        customer.updateCart();
                        User.clearTemp();
                        System.out.println("Item Successfully Removed From The Cart . . .\n");
                        System.out.println("My Cart: ");
                        customer.printCart();
                    }
                case "Pay Bill" -> {
                    System.out.println("My Cart : ");
                    customer.printCart();
                    System.out.println("\nEnter Amount : ");
                    double amount = inp.nextDouble();
                    System.out.println(customer.payInLoggedInMode(amount));
                    System.out.println("Bill Payment Successful . . .\n");
                }
                default -> back = true;
            }
        }
    }
    
    static void guestTester() 
     {
        Customer customer = new Customer();
        System.out.println("Logged in as Guest: ");

        while (true) 
         {
            inp = new Scanner(System.in);
            System.out.println("Purchase || Log out");
            String operation = inp.nextLine();
            if (operation.equals("Purchase")) 
             {
                User.printCurrentStorage();
                System.out.println("\nEnter Serial No: ");
                String nth = inp.nextLine();
                double ammount = inp.nextDouble();
                System.out.println(customer.buyInGuestMode(nth, ammount));
             } 
            else 
             {
                System.out.println("Logged out as Guest.....");
                return;
             }
        }

    }

    
    static void adminTester() 
     {
        boolean back = false;
        Admin admin;
        System.out.println("Enter Admin Password: ");
        String enteredPassword = inp.nextLine();
        admin = new Admin(enteredPassword);
        if (admin.verifyAdminStatus()) 
         {
            System.out.println("\nSuccessfully Logged in as Admin");
         } 
        else 
         {
            System.out.println("Wrong Password");
            return;
         }
        
        inp = new Scanner(System.in);
        while (!back)
         {
            System.out.println("> Add Medicine \n> Remove Medicine \n> Change Password \n> Go Back ");
               System.out.println("Please Enter Your Desired Option: ");
            String operation = inp.nextLine();
            switch (operation) {
                case "Add Medicine" ->                     {
                        System.out.println("Enter the 'Name of the Medicine' to be Added and it's 'Price':  ");
                        String medicineName = inp.next();
                        double medicinePrice = inp.nextDouble();
                        admin.addMedicine(medicineName, medicinePrice);
                        User.printCurrentStorage();
                    }
                case "Remove Medicine" ->                     {
                        System.out.println("\nEnter the Name of the Medicine to be Removed: ");
                        String medicineName = inp.next();
                        admin.removeMedicine(medicineName);
                        User.printCurrentStorage();
                        System.out.println("\nEntered Medicine Successfully Removed..... ");
                    }
                case "Change Password" -> {
                    System.out.println("Enter New Password:  ");
                    String newPassword = inp.next();
                    User.setAdminPasswordToFile(newPassword);
                    System.out.println("\nPassword Successfully Changed.... ");
                }
                case "Go Back" -> {
                    System.out.println("Type Any Keyboard For Main Menu");
                    back = true;
                }
                default -> {
                }
            }
            inp.nextLine();
        }

    }
}


