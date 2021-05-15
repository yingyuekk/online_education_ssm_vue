package cn.xq.notp.service;

import cn.xq.notp.entity.User;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/16
 */
public interface UserService {

    User getUserById(Integer userId);

    String getUserByPhoneAndPwd(String phone, String pwd);

    int addUser(User user);
}
