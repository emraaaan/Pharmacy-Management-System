/*
<< Pharmacy Management System Project>>
Date of Presentation : 16 June 2023
Group : I   
Name of Group members : Md. Emran Hossain (Id-2221132642) Hossain Mohammad Maruf (Id-1712604042) Ariful Anam Afridi(Id-2222859042)
Instructor : ASM Sabiqul Hassan
Section : CSE215L.16
*/
package business;

import java.util.ArrayList;

public class DrugCatalog {
    
private ArrayList<Drug> drugList;


    public DrugCatalog(){
    this.drugList = new ArrayList<>();
}
    public ArrayList<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(ArrayList<Drug> drugList) {
        this.drugList = drugList;
    }

    public Drug addDrugs(Drug d) {
      
        drugList.add(d);
        return d;
        
    }
    public void removeDrug(Drug d)
    {
        drugList.remove(d);
    }
    
     
}
