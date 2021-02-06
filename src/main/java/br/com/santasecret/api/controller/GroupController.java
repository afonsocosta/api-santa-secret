package br.com.santasecret.api.controller;

import br.com.santasecret.api.config.SwaggerConfig;
import br.com.santasecret.api.dto.GroupDto;
import br.com.santasecret.api.entity.User;
import br.com.santasecret.api.model.ResponseList;
import br.com.santasecret.api.service.GroupService;
import br.com.santasecret.api.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = SwaggerConfig.GROUP)
@RestController
@RequestMapping({"/api/v1/group", "/api/v2/group"})
@CrossOrigin
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    private final UserService userService;

    @ApiOperation(value = "API responsible for returning user created groups")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful query"),
            @ApiResponse(code = 400, message = "Error in the request sent by the customer"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping
    public ResponseEntity<ResponseList<GroupDto>> findByOwnerId() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByEmail(auth.getName());
        if (user == null) {
            throw new Exception();
        }
        ResponseList<GroupDto> response = new ResponseList<>();
        response.setData(groupService.findByOwnerId(user.getId()));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

}
