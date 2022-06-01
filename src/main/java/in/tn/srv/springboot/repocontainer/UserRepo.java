package in.tn.srv.springboot.repocontainer;

import in.tn.srv.springboot.entitycontainer.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByfirstName(String firstName);

    UserEntity save(UserEntity userEntity);
}
