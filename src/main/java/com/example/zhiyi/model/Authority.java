package com.example.zhiyi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "AUTHORITY")
public class Authority {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "AUTHORITY_SEQ", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "ID")
    Long id;
    
    @Column(nullable = false)
    private String name; //权限名
    
    @ManyToMany(mappedBy = "authorityList")
    private List<Users> userList;
}
