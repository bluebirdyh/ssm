package com.yanghao.service.Impl;

import com.github.pagehelper.PageHelper;
import com.yanghao.domain.Role;
import com.yanghao.domain.UserInfo;
import com.yanghao.respository.IUserInfoRespository;
import com.yanghao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/*2018/10/12 0012
   杨浩*/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserInfoRespository userInfoRespository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=userInfoRespository.findByUsername(username);
        if(userInfo!=null){
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));
            return user;
        }
        return null;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll(int page, int size) {
        PageHelper.startPage(page,size);
        return userInfoRespository.findAll(page,size);
    }

    @Override
    public UserInfo findById(String id) {
        return userInfoRespository.findById(id);
    }

    @Override
    public void save(UserInfo userInfo) {
        //对密码进行加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfoRespository.save(userInfo);
    }
}
