package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;
import com.bean.UserBean;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer> {

}
