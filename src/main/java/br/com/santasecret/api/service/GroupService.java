package br.com.santasecret.api.service;

import br.com.santasecret.api.dto.GroupDto;

import java.util.List;

public interface GroupService {

    List<GroupDto> findByOwnerId(Long ownerId);

}
