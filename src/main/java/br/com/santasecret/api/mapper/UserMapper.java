package br.com.santasecret.api.mapper;

import br.com.santasecret.api.dto.UserDto;
import br.com.santasecret.api.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    @Mapping(target = "credential.password", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "cellphone", source = "cellphone")
    @Mapping(target = "credential", source = "credential")
    UserDto toUserDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "credential", source = "credential")
    @Mapping(target = "cellphone", source = "cellphone")
    User toUser(UserDto userDto);


}
