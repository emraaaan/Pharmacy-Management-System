/*
<< Pharmacy Management System Project>>
Date of Presentation : 16 June 2023
Group : I   
Name of Group members : Md. Emran Hossain (Id-2221132642) Hossain Mohammad Maruf (Id-1712604042) Ariful Anam Afridi(Id-2222859042)
Instructor : ASM Sabiqul Hassan
Section : CSE215L.16
*/
package business;

// pharmacy class
public class Pharmacy {
    
    private String pharmaName;
    private int pharmaID;
    private String pharmaLocation;
    private DrugCatalog drugCatalog;

    @Override
    public String toString() {
        
        return pharmaName;
    }

    public Pharmacy(){
        drugCatalog = new DrugCatalog();
    }
    public DrugCatalog getDrugCatalog() {
        return drugCatalog;
    }

    public void setDrugCatalog(DrugCatalog drugCatalog) {
        this.drugCatalog = drugCatalog;
    }
    
    public String getStoreName() {
        return pharmaName;
    }

    public void setStoreName(String storeName) {
        this.pharmaName = storeName;
    }

    public int getStoreID() {
        return pharmaID;
    }

    public void setStoreID(int storeID) {
        this.pharmaID = storeID;
    }

    public String getStoreLocation() {
        return pharmaLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.pharmaLocation = storeLocation;
    }
    
    
}
