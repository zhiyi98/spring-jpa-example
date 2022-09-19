package com.example.zhiyi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity   //表示这个类是一个实体类
@Table(name = "AUTHOR")    //对应的数据库中表名称
public class Author {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    @SequenceGenerator(sequenceName = "AUTHOR_SEQ", allocationSize = 1, name = "CUST_SEQ")
    @Column(name = "ID")
    Long id;
    
    @Column(nullable = false, length = 20, name = "NAME")
    private String name;//姓名
    
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="author"中的author是Article中的author属性
    private List<Article> articleList;//文章列表
}