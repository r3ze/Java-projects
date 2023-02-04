
package com.oopclass.breadapp.services.impl;

import com.oopclass.breadapp.models.Orders;
import com.oopclass.breadapp.repository.OrdersRepository;
import com.oopclass.breadapp.services.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
     @Autowired
	private OrdersRepository orderRepository;
    @Override
    public Orders save(Orders entity) {
             return orderRepository.save(entity);
    }

    @Override
    public Orders update(Orders entity) {
       return orderRepository.save(entity);
    }

    @Override
    public void delete(Orders entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(List<Orders> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders find(Long id) {
       return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Orders> findAll() {
        return orderRepository.findAll();
    }
    
}
