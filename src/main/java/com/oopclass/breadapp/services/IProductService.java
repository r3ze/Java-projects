
package com.oopclass.breadapp.services;

import com.oopclass.breadapp.models.Product;
import com.oopclass.breadapp.generic.GenericService;

public interface IProductService extends GenericService<Product>{
    boolean authenticate(String email, String password);
	
	Product findByEmail(String email);
}
