
package com.oopclass.breadapp.services;

import com.oopclass.breadapp.generic.GenericService;
import com.oopclass.breadapp.models.Sales;
import org.springframework.stereotype.Service;


public interface ISalesService extends GenericService<Sales>{
      boolean authenticate(String email, String password);
	
	Service findByEmail(String email);
}
