package br.com.santasecret.api.service;

import br.com.santasecret.api.dto.ParticipantDto;

import java.util.List;

public interface ParticipantService {

    List<ParticipantDto> findByGroupId(Long groupId);

}
