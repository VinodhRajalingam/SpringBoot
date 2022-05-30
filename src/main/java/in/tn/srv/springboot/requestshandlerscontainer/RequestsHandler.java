package in.tn.srv.springboot.requestshandlerscontainer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestsHandler {

    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome User";
    }

    @RequestMapping("/user")
    public String welcomeNormalUsers() {
        return "Welcome Normal User";
    }

    @RequestMapping("/admin")
    public String welcomeAdmin() {
        return "Welcome Admin";
    }

    @RequestMapping("/errors")
    public String welcomeError() {
        return "Welcome Error";
    }
}
