package com.gpch.app.service;

import com.gpch.app.model.Reward;
import com.gpch.app.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    @Autowired
    private RewardRepository rewardRepository;

    public List<Reward> listAll() {
        return rewardRepository.findAll();
    }

    public Reward get(long id) {
        return rewardRepository.findById(id).get();
    }

    public void save(Reward reward) {
        rewardRepository.save(reward);
    }
    }