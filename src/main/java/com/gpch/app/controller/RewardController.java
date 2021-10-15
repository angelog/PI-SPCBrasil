package com.gpch.app.controller;

import com.gpch.app.model.Reward;
import com.gpch.app.model.User;
import com.gpch.app.service.RewardService;
import com.gpch.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RewardController {
    @Autowired
    private RewardService rewardService;

    @Autowired
    private UserService userService;

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditRewardPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("/admin/loja");
        Reward reward = rewardService.get(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentuser = userService.findUserByUserName(auth.getName());
        mav.addObject("userName", "Bem vindo! " + currentuser.getName() + " " + currentuser.getLastName() + " (" + currentuser.getEmail() + ")");
        mav.addObject("userScore", "Score: " + currentuser.getScore());
        mav.addObject("userPontos", "Pontos: " + currentuser.getPontos());

        userService.updateUser(currentuser,reward.getCusto());

        Iterable<Reward> rewards = rewardService.listAll();
        mav.addObject("reward",rewards);

        mav.addObject("userPontos","Pontos: "+currentuser.getPontos());
        return mav;
    }
}