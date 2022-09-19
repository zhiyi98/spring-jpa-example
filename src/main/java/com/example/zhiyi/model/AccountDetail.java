package com.example.zhiyi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ACCOUNT_DETAILS")
public class AccountDetail {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "ACCOUNTDETAIL_SEQ", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "ID")
    Long id;
    
    @Column(name = "ADDRESS")
    String address;
    
    @Column(name = "EMAIL")
    String email;
    
    @Column(name = "PHONE")
    String phone;
    
    @Column(name = "REAL_NAME")
    String realName;
}