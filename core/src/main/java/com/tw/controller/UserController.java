package com.tw.controller;

import com.tw.entity.Employee;
import com.tw.entity.User;
import com.tw.service.UserService;
import com.tw.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

/**
 * Created by twer on 7/9/15.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    private ModelAndView createModelAndView(String viewName, String objectName, Object objectValue){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName(viewName);
        modelAndView.addObject(objectName, objectValue);

        return modelAndView;
    }
    private Cookie createLastPageCookie(String cookieValue){
        Cookie cookie = new Cookie("last_page", cookieValue);
        cookie.setPath("/");

        return cookie;
    }

    private Cookie deleteLastPageCookie(){
        Cookie cookie = new Cookie("last_page", null);
        cookie.setMaxAge(0);

        return cookie;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllUsers(
                                    @CookieValue(value = "login_user", defaultValue = "") String currentUser,
                                    HttpServletResponse response) {
        if (!currentUser.equals("")) {
            Cookie userCookie = new Cookie("last_page", null);
            userCookie.setMaxAge(0);
            userCookie.setPath("/");
            response.addCookie(userCookie);

            return createModelAndView("users", "users", userService.getAllUsers());
        } else {

            response.addCookie(deleteLastPageCookie());
            response.addCookie(createLastPageCookie("users"));

            return new ModelAndView("redirect:/host/login");
        }
    }



    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String userName,
                                @RequestParam String password,
                                @RequestParam Employee employee
    ) {
        User user = new User(userName, password, employee);
        userService.addUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable int id){

        User user = userService.getUserById(id);
        userService.deleteUser(user);

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateUser(@CookieValue(value = "login_user", defaultValue = "") String currentUser,
                                      HttpServletResponse response,@PathVariable int id){


        if (!currentUser.equals("")) {
            Cookie userCookie = new Cookie("last_page", null);
            userCookie.setMaxAge(0);
            userCookie.setPath("/");
            response.addCookie(userCookie);
            User user = userService.getUserById(id);

            return createModelAndView("updateUser", "user", user);
        } else {
            response.addCookie(deleteLastPageCookie());
            response.addCookie(createLastPageCookie("users/update/" + id));

            return new ModelAndView("redirect:/host/login");
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ModelAndView UpdateUser(@RequestParam String userName,
                                   @RequestParam String password,
                                   @RequestParam Employee employee
                                   ) {
        User user = new User(userName, password, employee);
        userService.updateUser(user);

        return new ModelAndView("redirect:/users");
    }


}