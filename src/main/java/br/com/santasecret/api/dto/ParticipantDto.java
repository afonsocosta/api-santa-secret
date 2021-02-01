package br.com.santasecret.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ParticipantDto {

    private Long id;

    @NotBlank(message = "Group cannot be null")
    private GroupDto group;

    @NotBlank(message = "User cannot be null")
    private UserDto user;

    private boolean checked;

}
