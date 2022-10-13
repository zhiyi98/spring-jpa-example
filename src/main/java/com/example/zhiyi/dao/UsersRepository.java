package com.example.zhiyi.dao;

import com.example.zhiyi.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface UsersRepository extends CrudRepository<Users, Long> {
    
    @Query("select count(c) from Users c where c.id = ?1")
    long countById(Long id);
    
    @Transactional
    @Modifying
    @Query("update Users c set c.username = :username, c.password = :password, c.createdDate = :createdDate " +
        "where c.id = :id")
    int updateUsernameAndPasswordAndCreatedDateById(@Param("username") String username, @Param("password") String password, @Param("createdDate") Date createdDate, @Param("id") Long id);
    
    @Query("select c from Users c where c.createdDate > :createdDate")
    List<Users> findByCreatedDateAfter(@Param("createdDate") Date createdDate);
    
    @Query("select c from Users c where c.createdDate < :createdDate")
    List<Users> findByCreatedDateBefore(@Param("createdDate") Date createdDate);
    
    @Query("select c from Users c where c.username = :username and c.password = :password")
    Users findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    
}
