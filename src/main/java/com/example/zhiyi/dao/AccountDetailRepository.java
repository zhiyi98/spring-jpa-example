package com.example.zhiyi.dao;

import com.example.zhiyi.model.AccountDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailRepository extends CrudRepository<AccountDetail,Long> {
}
