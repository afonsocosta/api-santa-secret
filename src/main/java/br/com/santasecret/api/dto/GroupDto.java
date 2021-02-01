package br.com.santasecret.api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupDto {

    private String name;

    private UserDto owner;

    private LocalDateTime eventDate;

}
