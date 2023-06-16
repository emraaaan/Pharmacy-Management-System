/*
<< Pharmacy Management System Project>>
Date of Presentation : 16 June 2023
Group : I   
Name of Group members : Md. Emran Hossain (Id-2221132642) Hossain Mohammad Maruf (Id-1712604042) Ariful Anam Afridi(Id-2222859042)
Instructor : ASM Sabiqul Hassan
Section : CSE215L.16
*/
package business;

import javax.swing.JOptionPane;

// validator class
public class Validator {
    
    public boolean isValidInteger(String str)
    {
        try {
            Integer.valueOf(str);
                return true;
            }
            catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Please enter a number","warning",JOptionPane.ERROR_MESSAGE);
                    return false;
            }
    }
    
    public boolean isValidFloat(String str)
    {
        try {
            Float.valueOf(str);
                return true;
            }
            catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null, "Please enter a number","warning",JOptionPane.ERROR_MESSAGE);
                    return false;
            }
    }
    
    public boolean isStringValid(String str)
    {
        return !str.trim().isEmpty();
       
        
    }
    
}