package br.com.santasecret.api.service.impl;

import br.com.santasecret.api.dto.ParticipantDto;
import br.com.santasecret.api.entity.Participant;
import br.com.santasecret.api.mapper.ParticipantMapper;
import br.com.santasecret.api.repository.ParticipantRepository;
import br.com.santasecret.api.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;

    private final ParticipantMapper participantMapper;

    public List<ParticipantDto> findByGroupId(Long groupId) {
        List<Participant> participants = participantRepository.findByGroupId(groupId);
        if (CollectionUtils.isEmpty(participants)) {
            return Collections.EMPTY_LIST;
        }
        return participantMapper.toParticipantDto(participants);
    }

}
