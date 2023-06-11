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

// store directory class
public class StoreDirectory {
    
    ArrayList<Store> storeList;
    
    public StoreDirectory(){
        this.storeList = new ArrayList<>();
    }

    public ArrayList<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(ArrayList<Store> storeList) {
        this.storeList = storeList;
    }
    
    public Store addStore(Store store){
        
        storeList.add(store);
        return store;
    }
    public void removeStore(Store store){
        storeList.remove(store);
    }

   }
