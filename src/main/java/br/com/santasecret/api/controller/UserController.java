package br.com.santasecret.api.controller;

import br.com.santasecret.api.config.SwaggerConfig;
import br.com.santasecret.api.dto.UserDto;
import br.com.santasecret.api.entity.User;
import br.com.santasecret.api.model.Response;
import br.com.santasecret.api.service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = SwaggerConfig.USER)
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<User> findById() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(1l));
    }

    @PostMapping
    public ResponseEntity<Response<UserDto>> createUser(@Valid @RequestBody UserDto userDto) {
        Response<UserDto> response = new Response<>();
        response.setData(userService.createUser(userDto));
        response.setStatusCode(HttpStatus.CREATED.value());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
