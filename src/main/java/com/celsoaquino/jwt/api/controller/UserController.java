package com.celsoaquino.jwt.api.controller;

import com.celsoaquino.jwt.api.entity.AuthRequest;
import com.celsoaquino.jwt.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping
    public String init() {
        return "Welcome Celso Aquino!!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

      try {
          authenticationManager.authenticate(
                  new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
          );
      }catch (Exception e) {
          throw new Exception("invalid username/password");
      }
      return jwtUtil.generateToken(authRequest.getUserName());

    }
}
