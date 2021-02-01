package br.com.santasecret.api.controller;

import br.com.santasecret.api.config.SwaggerConfig;
import br.com.santasecret.api.entity.User;
import br.com.santasecret.api.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = SwaggerConfig.USER)
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public ResponseEntity<User> findById() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(1l));
    }

}
