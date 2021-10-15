package com.gpch.app.controller;

import com.gpch.app.model.Reward;
import com.gpch.app.model.User;
import com.gpch.app.service.RewardService;
import com.gpch.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LojaController {

    @Autowired
    private UserService userService;

    @Autowired
    private RewardService rewardService;

    @GetMapping(value={"/admin/rewards"})
    public ModelAndView rewards(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Bem vindo! " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userScore", "Score: " + user.getScore());
        modelAndView.addObject("userPontos", "Pontos: " + user.getPontos());
        modelAndView.addObject("adminMessage","Conteúdo disponível apenas para usuários com função administrativa!");
        modelAndView.setViewName("admin/rewards");
        return modelAndView;
    }

    @GetMapping(value="/admin/loja")
    public ModelAndView loja(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Bem vindo! " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userScore", "Score: " + user.getScore());
        modelAndView.addObject("userPontos", "Pontos: " + user.getPontos());
        modelAndView.setViewName("admin/loja");

        Iterable<Reward> rewards = rewardService.listAll();
        modelAndView.addObject("reward",rewards);

        return modelAndView;
    }
    
    @GetMapping(value="/admin/email")
    public ModelAndView email(){
        ModelAndView modelAndView = new ModelAndView();
          
        modelAndView.setViewName("admin/email");

        Iterable<Reward> rewards = rewardService.listAll();
        modelAndView.addObject("email",rewards);

        return modelAndView;
    }


}
