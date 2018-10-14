package com.yanghao.service;

import com.yanghao.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/*2018/10/12 0012
   杨浩*/
public interface UserService extends UserDetailsService {
    List<UserInfo> findAll(int page, int size);

    UserInfo findById(String id);

    void save(UserInfo userInfo);
}
