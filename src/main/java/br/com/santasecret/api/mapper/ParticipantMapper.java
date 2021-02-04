package br.com.santasecret.api.mapper;

import br.com.santasecret.api.dto.ParticipantDto;
import br.com.santasecret.api.entity.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ParticipantMapper {

    @Mapping(target = "group.owner", ignore = true)
    @Mapping(target = "group", source = "group")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "user.credential.password", ignore = true)
    @Mapping(target = "checked", source = "checked")
    ParticipantDto toParticipantDto(Participant participant);

    @Mapping(target = "group.owner", ignore = true)
    @Mapping(target = "group", source = "group")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "checked", source = "checked")
    List<ParticipantDto> toParticipantDto(List<Participant> participant);
}
