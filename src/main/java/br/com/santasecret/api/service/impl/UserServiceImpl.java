package br.com.santasecret.api.service.impl;

import br.com.santasecret.api.core.impl.ResourceOwner;
import br.com.santasecret.api.dto.UserDto;
import br.com.santasecret.api.entity.User;
import br.com.santasecret.api.mapper.UserMapper;
import br.com.santasecret.api.repository.UserRepository;
import br.com.santasecret.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public User findByEmail(String email) {
        return userRepository.findByCredentialEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.findByEmail(email);
        if (user != null) {
            return new ResourceOwner(user);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
