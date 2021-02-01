package br.com.santasecret.api.dto;

import lombok.Data;

@Data
public class DrawDto {

    private GroupDto group;

    private UserDto userFrom;

    private UserDto userTo;

}
