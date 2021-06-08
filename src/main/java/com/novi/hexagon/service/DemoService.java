package com.novi.hexagon.service;

import com.novi.hexagon.exceptions.RecordNotFoundException;
import com.novi.hexagon.exceptions.UsernameNotFoundException;
import com.novi.hexagon.model.Demo;
import com.novi.hexagon.model.User;
import com.novi.hexagon.repository.DemoRepository;
import com.novi.hexagon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DemoRepository demoRepository;

    public void addDemo(Demo demo) {
        String username = demo.getUsername();
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addDemo(demo);
        userRepository.save(user);
    }

    public Optional<Demo> getDemoByFilename(String filename){
        if (!demoRepository.existsByDemo(filename)) throw new UsernameNotFoundException(filename);
        Optional<Demo> demo = demoRepository.findByDemo(filename);
        return demo;
    }

    public void deleteDemo(String filename) {
        demoRepository.deleteByDemo(filename);
    }

}
