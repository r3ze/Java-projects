
package com.oopclass.breadapp.models;

import java.util.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	private String productName;
        private LocalDate date;
        private int quantity;
        private double totalAmount;
        private double price;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
        
        public String getProductName(){
            return productName;
        }
        public void setProductName(String productName){
            this.productName = productName;
        }
        
      	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
       

	@Override
	public String toString() {
		return "Sales [id=" + id + ", dateAdded=" + date + ", productName=" + productName + ",price ="+price+", quantity="+quantity+", totalAmount="+totalAmount+"]";
	}
}

