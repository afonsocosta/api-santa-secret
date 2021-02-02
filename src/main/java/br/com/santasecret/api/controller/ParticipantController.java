package br.com.santasecret.api.controller;

import br.com.santasecret.api.config.SwaggerConfig;
import br.com.santasecret.api.dto.ParticipantDto;
import br.com.santasecret.api.model.ResponseList;
import br.com.santasecret.api.service.ParticipantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = SwaggerConfig.PARTICIPANT)
@RestController
@RequestMapping("/api/v1/participant")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @ApiOperation(value = "Api responsable for returning all participants in a specific group")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful query"),
            @ApiResponse(code = 400, message = "Error in the request sent by the customer"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/group/{groupId}")
    public ResponseEntity<ResponseList<ParticipantDto>> findByGroupId(@PathVariable Long groupId) {
        ResponseList<ParticipantDto> response = new ResponseList<>();
        response.setData(participantService.findByGroupId(groupId));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);

    }
}
