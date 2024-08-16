package com.volkruss.demo.controller;

import com.volkruss.demo.ResultObject;
import com.volkruss.demo.SampleForm;
import com.volkruss.demo.domain.dto.user.UserEntity;
import com.volkruss.demo.domain.model.user.User;
import com.volkruss.demo.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/sample")
    @CrossOrigin
    public ResultObject post(@RequestBody SampleForm sampleForm) {
        int id = sampleForm.getId();
        ResultObject resultObject = new ResultObject();
        resultObject.setName("zenn");
        resultObject.setLank(id);
        return resultObject;
    }

    @GetMapping("/test")
    public User get() {
        UserEntity userEntity = this.userRepository.findByName("zenn");
        return userEntity.toUser();
    }

    @GetMapping("/api/test")
    public String test() {
        return "認証成功してます";
    }
}
