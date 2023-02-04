
package com.oopclass.breadapp.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	private String productName;
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
        
        public double getPrice(){
            return price;
        }
        public void setPrice(double price){
            this.price = price;
        }
        
       

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}
}

