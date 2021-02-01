package br.com.santasecret.api.service.impl;

import br.com.santasecret.api.dto.GroupDto;
import br.com.santasecret.api.entity.Group;
import br.com.santasecret.api.mapper.GroupMapper;
import br.com.santasecret.api.repository.GroupRepository;
import br.com.santasecret.api.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper;

    @Override
    public List<GroupDto> findByOwnerId(Long ownerId) {
        List<Group> groupList = groupRepository.findByOwnerId(ownerId);
        return groupMapper.toGroupDto(groupList);
    }
}
