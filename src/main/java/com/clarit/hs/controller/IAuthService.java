package com.clarit.hs.controller;

import com.clarit.hs.service.items.model.LoginRequest;
import com.clarit.hs.service.items.model.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/token")
public interface IAuthService {


    @PostMapping( produces = { "application/json" })
    public ResponseEntity<LoginResponse> getTokenBy(@RequestBody LoginRequest loginRequest);






}

