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


public class MasterOrderCatalog {
    private ArrayList<Order> orderCatalog;

    public MasterOrderCatalog(){
        orderCatalog = new ArrayList<>();
    }
    
    public Order addOrder(Order o){
        
        orderCatalog.add(o);
        return o;
    }
    
    public ArrayList<Order> getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(ArrayList<Order> orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
    
}
