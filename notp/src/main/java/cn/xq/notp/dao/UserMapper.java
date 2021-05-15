package cn.xq.notp.dao;

import cn.xq.notp.entity.User;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/16
 */
public interface UserMapper {
    User findUserById(Integer userId);

    User findUserByPhoneAndPwd(String phone, String pwd);

    int insetUser(User user);
}
