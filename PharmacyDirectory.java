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


public class PharmacyDirectory {
    
    ArrayList<Pharmacy> pharmaList;

    public PharmacyDirectory(){
        this.pharmaList =  new ArrayList<>();
    }
    public ArrayList<Pharmacy> getStoreList() {
        return pharmaList;
    }

    public void setStoreList(ArrayList<Pharmacy> storeList) {
        this.pharmaList = storeList;
    }

    public Pharmacy addPharmacy(Pharmacy pharma) {

        
        pharmaList.add(pharma);
        return pharma;
    }

    public void removeSupplier(Pharmacy pharmacy) {
     pharmaList.remove(pharmacy);
    }

    public Drug searchDrug(int drugID)
    {
        for(Pharmacy p : pharmaList){
        for(Drug drug : p.getDrugCatalog().getDrugList()){
            if(drugID == drug.getDrugID())
                return drug;
        }
         }
        return null;
    }
}
