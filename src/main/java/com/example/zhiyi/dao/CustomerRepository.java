package com.example.zhiyi.dao;

import com.example.zhiyi.model.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
    List<Customer> findByUsername(String username);
    
    List<Customer> findByUsernameAndPassword(String username, String password);
    
    @Query("select c from Customer c where c.username = 'admin'")
    List<Customer> findByCondition();
    
    @Transactional
    @Modifying
    @Query("update Customer set username = ?1 where id = ?2")
    int updateByCondition(String username, Long id);
    
    @Query("select c from Customer c where c.username = ?1 and c.password = ?2")
    List<Customer> findByCondition2(String username, String password);
    
    @Transactional
    @Modifying
    @Query(value = "update Customer c set c.username = ?1 where c.id = ?2", nativeQuery = true)// nativeQuery，使用原生SQL
    int updateByCondition2(String username, Long id);
    
}
