package br.com.santasecret.api.service;

import br.com.santasecret.api.dto.UserDto;
import br.com.santasecret.api.entity.User;

public interface UserService {

    User findById(Long id);

    UserDto createUser(UserDto userDto);
}
