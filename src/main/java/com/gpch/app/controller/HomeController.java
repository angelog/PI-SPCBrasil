package com.gpch.app.controller;

import com.gpch.app.model.User;
import com.gpch.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/admin/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Bem vindo! " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userScore", "Score: " + user.getScore());
        modelAndView.addObject("userPontos", "Pontos: " + user.getPontos());
        modelAndView.addObject("adminMessage","Conteúdo disponível apenas para usuários com função administrativa!");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
}
