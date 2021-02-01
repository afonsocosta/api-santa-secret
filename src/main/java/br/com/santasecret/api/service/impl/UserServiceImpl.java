package br.com.santasecret.api.service.impl;

import br.com.santasecret.api.entity.User;
import br.com.santasecret.api.repository.UserRepository;
import br.com.santasecret.api.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
}
