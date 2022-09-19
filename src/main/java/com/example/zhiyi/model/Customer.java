package com.example.zhiyi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "CUSTOMER")
public class Customer {
    
    // "customer_seq" is Oracle sequence name.
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "ID")
    Long id;
    
    @Column(name = "USERNAME")
    String username;
    
    @Column(name = "PASSWORD")
    String password;
    
    @Column(name = "CREATED_DATE")
    Date created_date;
    
    //一对一
    @JoinColumn(name = "DETAIL_ID")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    AccountDetail detail;//对象类型,也可以理解这里写哪个实体类,外键就指向哪个实体类的主键
    
}
