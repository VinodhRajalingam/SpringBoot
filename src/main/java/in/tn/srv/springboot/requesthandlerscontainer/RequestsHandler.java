package in.tn.srv.springboot.requesthandlerscontainer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestsHandler {

    @RequestMapping("/")
    public String welcomeUser() {
        return "Welcome User";
    }
}
