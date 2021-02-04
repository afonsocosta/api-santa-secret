package br.com.santasecret.api.mapper;

import br.com.santasecret.api.dto.CredentialDto;
import br.com.santasecret.api.dto.GroupDto;
import br.com.santasecret.api.entity.Credential;
import br.com.santasecret.api.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface GroupMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "eventDate", source = "eventDate")
    List<GroupDto> toGroupDto(List<Group> group);

    default CredentialDto credentialToCredentialDto(final Credential credential) {
        return new CredentialDto(credential.getEmail());
    }
}
