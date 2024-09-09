package com.web.fitizenproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class IndexController
{
    @Autowired
    private UserDAO userDAO;

    @GetMapping("jsp")
    public String jsp(Model model){
        model.addAttribute("greeting", "Hello World");
        return "index";
    }

    @GetMapping("html")
    public String html(Model model){
        model.addAttribute("greeting", "Hello World");
        return "th/index";
    }

    @GetMapping("user")
    public String user(Model model){
        User user = new User();
        user.setName("SCOTT");
        user.setEmail("scott@naver.com");
        user.setBirth("1998-02-28");
        user.setRegDate("2024-08-27");
        user.setUpDate("2024-08-27");

        model.addAttribute("user", user);
        return "th/index";
    }

    @GetMapping("userList")
    public String list(Model model){
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setName("SCOTT");
        user.setEmail("scott@naver.com");
        user.setBirth("1998-02-28");
        user.setRegDate("2024-08-27");
        user.setUpDate("2024-08-27");
        list.add(user);

        user.setName("JAMES");
        user.setEmail("james@naver.com");
        user.setBirth("1999-05-11");
        user.setRegDate("2024-08-22");
        user.setUpDate("2024-08-25");
        list.add(user);

        model.addAttribute("userList", list);
        return "th/userList";
    }

    @GetMapping("userLogin")
    public String login(Model model){
        User u = new User();
        model.addAttribute("user", u);
        return "userLogin";
    }

    @PostMapping("userLogin")
    public String login(Model model, User user){
        String id = user.getId();
        String pwd = user.getPwd();
        if(id.equals("smith") && pwd.equals("1234")){
            //System.out.println("로그인 성공");

            //log.debug();
            log.info("로그인 성공");
            //log.warn();
            //log.error();
        }else{
            //System.out.println("로그인 실패");
            log.warn("로그인 실패");
        }
        return null;
    }

    @GetMapping("users")
    public String emps(Model model){
        List<User> list = UserDAO.userList();
        model.addAttribute("list", list);
        return "th/userList";
    }
}
