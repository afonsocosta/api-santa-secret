package br.com.santasecret.api.controller;

import br.com.santasecret.api.config.SwaggerConfig;
import br.com.santasecret.api.dto.GroupDto;
import br.com.santasecret.api.model.ResponseList;
import br.com.santasecret.api.service.GroupService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = SwaggerConfig.GROUP)
@RestController
@RequestMapping("/api/v1/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/{ownerId}")
    public ResponseEntity<ResponseList<GroupDto>> findByOwnerId(@PathVariable Long ownerId) {
        ResponseList<GroupDto> response = new ResponseList<>();
        response.setData(groupService.findByOwnerId(ownerId));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

}
