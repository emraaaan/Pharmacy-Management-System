/*
<< Pharmacy Management System Project>>
Date of Presentation : 16 June 2023
Group : I   
Name of Group members : Md. Emran Hossain (Id-2221132642) Hossain Mohammad Maruf (Id-1712604042) Ariful Anam Afridi(Id-2222859042)
Instructor : ASM Sabiqul Hassan
Section : CSE215L.16
*/
package business;

public class AddData {
    
    public void setInitialValues(PharmacyDirectory pharmacyDirectory)
            
    {
        PharmacyDirectory pharmaDirectory = pharmacyDirectory;
        
       Pharmacy pharma1 = new Pharmacy();
               
                    
       pharma1.setStoreName("Brothers Pharmacy");
       
        
       pharmaDirectory.addPharmacy(pharma1);
     
        Drug drug1 = new Drug();
        
        
        drug1.setDrugID(1);
        drug1.setDrugName("Tylace");
        drug1.setDrugType("Paracetemol");
        drug1.setComposition("250ml");
        drug1.setDrugAvailibility(40);
        drug1.setDrugPrice(20);
        drug1.setDrugDescription("Used for Cold");
        drug1.setExpirationDate("16-05-2026");
        drug1.setManufacturedDate("16-06-2023");
        pharma1.getDrugCatalog().addDrugs(drug1);
        
        Drug drug2 = new Drug();
        drug2.setDrugID(2);
        drug2.setDrugName("Entacyd");
        drug2.setDrugType("Hyperacidity");
        drug2.setComposition("200 ml");
        drug2.setDrugAvailibility(50);
        drug2.setDrugPrice(30);
        drug2.setDrugDescription("used for acidity");
        drug2.setExpirationDate("16-05-2025");
        drug2.setManufacturedDate("16-06-2022");
        pharma1.getDrugCatalog().addDrugs(drug2);
        
        Drug drug3 = new Drug();
        drug3.setDrugID(3);
        drug3.setDrugName("Osmolax");
        drug3.setDrugType("Lactulose");
        drug3.setComposition("100 ml");
        drug3.setDrugAvailibility(30);
        drug3.setDrugPrice(30);
        drug3.setDrugDescription("used for acne");
        drug3.setExpirationDate("16-05-2026");
        drug3.setManufacturedDate("16-06-2022");
        pharma1.getDrugCatalog().addDrugs(drug3);
       
        
        Drug drug4 = new Drug();
        drug4.setDrugID(4);
        drug4.setDrugName("Fona Plus");
        drug4.setDrugType("Gel");
        drug4.setComposition("250ml");
        drug4.setDrugAvailibility(40);
        drug4.setDrugPrice(20);
        drug4.setDrugDescription("Used for acne treatment");
        drug4.setExpirationDate("16-05-2026");
        drug4.setManufacturedDate("16-06-2023");
        pharma1.getDrugCatalog().addDrugs(drug4);
        
    }
    public void setStoreInitialValues(StoreDirectory storeDirectory){
        StoreDirectory sd = storeDirectory;
        
        Store store1 = new Store();
        
       
        store1.setStoreName("Store 1");
        store1.setStoreLocation("Bashundhara");
        sd.addStore(store1);
           
    }
                
}
