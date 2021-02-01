package br.com.santasecret.api.service;

import br.com.santasecret.api.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findById(Long id);

}
