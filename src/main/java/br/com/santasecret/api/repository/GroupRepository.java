package br.com.santasecret.api.repository;

import br.com.santasecret.api.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    
    List<Group> findByOwnerId(Long ownerId);

}
