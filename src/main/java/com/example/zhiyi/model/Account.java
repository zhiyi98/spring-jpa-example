package com.example.zhiyi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity   //表示这个类是一个实体类
@Table(name = "ACCOUNT")    //对应的数据库中表名称
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "ACCOUNT_SEQ", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "ID")
    Long id;
    
    @Column(name = "USERNAME")
    String username;
    
    @Column(name = "PASSWORD")
    String password;
    
    @JoinColumn(name = "DETAIL_ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //设置关联操作为ALL
    AccountDetail detail;
}
