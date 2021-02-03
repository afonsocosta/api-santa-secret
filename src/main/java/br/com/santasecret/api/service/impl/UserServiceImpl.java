package br.com.santasecret.api.service.impl;

import br.com.santasecret.api.dto.UserDto;
import br.com.santasecret.api.entity.User;
import br.com.santasecret.api.mapper.UserMapper;
import br.com.santasecret.api.repository.UserRepository;
import br.com.santasecret.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Override

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        user = userRepository.save(user);
        return userMapper.toUserDto(user);
    }
}
