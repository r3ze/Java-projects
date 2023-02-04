
package com.oopclass.breadapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
      @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
    private String customerName;
    private String productName;
    private double price;
    private int quantity;
    private double totalAmount;
    private String address;
    private String status;
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
 
     public String getCustomerName(){
            return customerName;
        }
        public void setCustomerName(String customerName){
            this.customerName = customerName;
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
          public double getTotalAmount(){
            return totalAmount;
        }
        public void setTotalAmount(double totalAmount){
            this.totalAmount = totalAmount;
        }
           public String getAddress(){
            return address;
        }
        public void setAddress(String address){
            this.address = address;
        }
          public String getStatus(){
            return status;
        }
        public void setStatus(String status){
            this.status = status;
        }
        
	@Override
	public String toString() {
		return "Orders [id=" + id + ", customerName="+customerName+", productName=" + productName + ", price=" + price + ",quantity="+quantity+",totalAmount="+totalAmount+",address="+address+",status="+status+"]";
	}
        
}
