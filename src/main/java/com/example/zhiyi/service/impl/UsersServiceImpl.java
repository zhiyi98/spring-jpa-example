package com.example.zhiyi.service.impl;

import com.example.zhiyi.dao.UsersRepository;
import com.example.zhiyi.entity.Users;
import com.example.zhiyi.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.Date;

@Service
public class UsersServiceImpl implements UsersService {
    
    @Resource
    private UsersRepository usersRepository;
    
    @Resource
    private EntityManager entityManager;
    
    @Override
    public Users save(Users users) {
        users.setCreatedDate(new Date());
        Users saveUsers = this.usersRepository.save(users);
        return saveUsers;
    }
    
}
