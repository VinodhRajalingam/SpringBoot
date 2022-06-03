package in.tn.srv.springboot.repocontainer;

import in.tn.srv.springboot.entitycontainer.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByfirstName(String firstName);
    //User save(User userEntity);
}
