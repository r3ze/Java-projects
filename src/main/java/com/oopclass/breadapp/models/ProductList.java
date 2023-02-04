
package com.oopclass.breadapp.models;


public class ProductList {
    private String productName;
    private double price;
    private int quantity;
    private double totalPrice;
    
    public ProductList(String productName, double price, int quantity, double totalPrice)
    {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    
      public String getProductName(){
            return productName;
        }
        public void setProductName(String productName){
            this.productName = productName;
        }
        
          public double getPrice(){
            return price;
        }
        public void setPrice(double price){
            this.price = price;
        }
          public int getQuantity(){
            return quantity;
        }
        public void setQuantity(int quantity){
            this.quantity = quantity;
        }
          public double getTotalPrice(){
            return totalPrice;
        }
        public void setTotalPrice(double totalPrice){
            this.totalPrice = totalPrice;
        }
    
}
