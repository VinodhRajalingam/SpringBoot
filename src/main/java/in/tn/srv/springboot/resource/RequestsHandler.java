package in.tn.srv.springboot.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HandleRequests {

    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome User";
    }
}
