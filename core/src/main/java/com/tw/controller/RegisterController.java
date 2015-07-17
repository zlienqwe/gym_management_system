package com.tw.controller;

import com.tw.util.MD5Util;
import com.tw.entity.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by twer on 7/14/15.
 */
//@Controller
@RestController
@RequestMapping("/")
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/host/register", method = RequestMethod.POST)
    public ModelAndView getLogInMessage(@RequestParam String name,
                                        @RequestParam String password,
                                        @RequestParam String realName,
                                        @RequestParam String role,
                                        HttpServletResponse response) {

        List<User> users = userService.getUsersByName(name);



return null;
    }
}
