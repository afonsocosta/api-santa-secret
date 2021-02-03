package br.com.santasecret.api.mapper;

import br.com.santasecret.api.dto.GroupDto;
import br.com.santasecret.api.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface GroupMapper {


    @Mapping(target = "name", source = "name")
    @Mapping(target = "eventDate", source = "eventDate")
    @Mapping(target = "ownerEmail", source = "owner.credential.email")
    List<GroupDto> toGroupDto(List<Group> group);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "owner.id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "owner", source = "owner")
    @Mapping(target = "eventDate", source = "eventDate")
    Group toGroup(GroupDto groupDto);

}
