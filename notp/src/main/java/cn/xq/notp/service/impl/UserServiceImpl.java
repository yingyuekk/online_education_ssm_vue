package cn.xq.notp.service.impl;

import cn.xq.notp.common.CommonUtils;
import cn.xq.notp.common.JWTUtils;
import cn.xq.notp.dao.UserMapper;
import cn.xq.notp.entity.User;
import cn.xq.notp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    public String getUserByPhoneAndPwd(String phone, String pwd) {
        User user = userMapper.findUserByPhoneAndPwd(phone, CommonUtils.MD5(pwd));
        return user == null ?null :JWTUtils.geneJsonWebToken(user);
    }

    @Override
    public int addUser(User user) {
        user.setHeadImg(getRandomImg());
        user.setCreateTime(new Date());
        user.setPwd(CommonUtils.MD5(user.getPwd()));
        int row = userMapper.insetUser(user);
        return row;
    }

    /**
     * 放在CDN上的随机头像
     */
    private static final String [] headImg = {
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg"
    };

    private String getRandomImg(){
        int size =  headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
