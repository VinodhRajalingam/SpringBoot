package in.tn.srv.springboot.requesthandlerscontainer;

//import in.tn.srv.springboot.entitycontainer.CustomUserDetails;
//import in.tn.srv.springboot.entitycontainer.UserEntity;
import in.tn.srv.springboot.entitycontainer.User;
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
    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome User";
    }
    @PostMapping("/save")
    public User saveUser(@RequestBody User userEntity) {

        return userRepo.save(userEntity);
    }
    @PostMapping("/saveAll")
    public List<User> saveAll(@RequestBody List<User> userEntities) {
        return (List<User>) userRepo.saveAll(userEntities);
    }
    @RequestMapping("/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    @RequestMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable("id") int ID) {
        return userRepo.findById(ID);
    }
    @RequestMapping("/users/{uName}")
    public User getUser(@PathVariable("uName") String userName) {
        return userRepo.findByfirstName(userName);
    }
}
