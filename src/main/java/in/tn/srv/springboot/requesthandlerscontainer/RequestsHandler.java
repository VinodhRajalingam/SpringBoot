package in.tn.srv.springboot.requesthandlerscontainer;

import in.tn.srv.springboot.entitycontainer.UserEntity;
import in.tn.srv.springboot.repocontainer.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RequestsHandler {
    @Autowired
    UserRepo userRepo;

    //@Autowired
    //UserEntity userEntity;
    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome User";
    }

    @PostMapping("/save")
    public UserEntity saveUser(@RequestBody UserEntity userEntity) {

        return userRepo.save(userEntity);
    }

    @PostMapping("/saveAll")
    public List<UserEntity> saveAll(@RequestBody List<UserEntity> userEntities) {

        //UserEntity userEntity = userEntities.get(0);
        //UserEntity userEntity2 = userEntities.get(1);
        //return userRepo.saveAll(List.of(userEntity,userEntity2));
        return (List<UserEntity>) userRepo.saveAll(userEntities);
    }
    @RequestMapping("/users")
    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }
    @RequestMapping("/user/{id}")
    public Optional<UserEntity> getUser(@PathVariable("id") int ID) {
        return userRepo.findById(ID);
    }
    @RequestMapping("/users/{uName}")
    public Optional<UserEntity> getUser(@PathVariable("uName") String userName) {
        return userRepo.findByfirstName(userName);
    }
}
