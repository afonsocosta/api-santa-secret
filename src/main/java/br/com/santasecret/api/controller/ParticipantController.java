package br.com.santasecret.api.controller;

import br.com.santasecret.api.config.SwaggerConfig;
import br.com.santasecret.api.dto.ParticipantDto;
import br.com.santasecret.api.model.ResponseList;
import br.com.santasecret.api.service.ParticipantService;
import io.swagger.annotations.Api;
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

    @GetMapping("/group/{groupId}")
    public ResponseEntity<ResponseList<ParticipantDto>> findByGroupId(@PathVariable Long groupId) {
        ResponseList<ParticipantDto> response = new ResponseList<>();
        response.setData(participantService.findByGroupId(groupId));
        response.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }
}
