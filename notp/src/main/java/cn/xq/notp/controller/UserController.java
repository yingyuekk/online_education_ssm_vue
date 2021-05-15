package cn.xq.notp.controller;

import cn.xq.notp.common.ResultData;
import cn.xq.notp.entity.User;
import cn.xq.notp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qiong.xie
 * @description
 * @date 2021/4/16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public ResultData getUserInfo(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");
        Object user_id = request.getSession().getAttribute("user_id");
        User user = userService.getUserById(userId);
        return ResultData.ok("查询用户信息成功！！！",user);

    }

    @PostMapping("/login")
    public ResultData login(@RequestBody User user){
        String token = userService.getUserByPhoneAndPwd(user.getPhone(),user.getPwd());
        return token == null ? ResultData.build(2014,"用户登录失败！！！",null) : ResultData.ok("用户登录成功！！！",token);
    }

    @PostMapping("/register")
    public ResultData register(@RequestBody User user){
        int result = userService.addUser(user);
        return result > 0 ?ResultData.ok("用户注册成功！！！",null) :ResultData.build(2015,"用户注册失败！！！",null);
    }

    @PostMapping("/logout")
    public ResultData logout(HttpServletRequest request){
        request.getSession().invalidate();
        return ResultData.ok("用户注销成功！！！",null);
    }
}
