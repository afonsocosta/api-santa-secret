package br.com.santasecret.api.repository;

import br.com.santasecret.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByCredentialEmail(String email);

}
