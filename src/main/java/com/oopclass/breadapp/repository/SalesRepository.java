
package com.oopclass.breadapp.repository;

import com.oopclass.breadapp.models.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    
}
