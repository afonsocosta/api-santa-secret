package br.com.santasecret.api.service;

import br.com.santasecret.api.dto.UserDto;
import br.com.santasecret.api.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findById(Long id);

    User findByEmail(String email);

    UserDto createUser(UserDto userDto);


}
