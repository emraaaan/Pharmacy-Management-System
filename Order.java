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


public class Order {
    private ArrayList<OrderItem> orderItemList;
    private int orderNumber;
    private static int count;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public Order()
    {
        orderItemList =  new ArrayList<>();
        count++;
        orderNumber=count;
        
    }

    public OrderItem addOrderItem(Drug d, int quantity, int price)
    {
        OrderItem orderItem = new OrderItem();
        orderItem.setDrug(d);
        orderItem.setQuantity(quantity);
        orderItem.setSalesPrice(price);
        orderItemList.add(orderItem);
        return orderItem;
    }

    @Override
    public String toString() {
        return String.valueOf(orderNumber);
    }
    
    public void removeOrderItem(OrderItem o)
    {
        orderItemList.remove(o);
    }
    
    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
    
    
}
