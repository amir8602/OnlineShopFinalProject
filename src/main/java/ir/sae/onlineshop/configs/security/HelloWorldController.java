package ir.sae.onlineshop.configs.security;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {




    @RequestMapping({ "/hello" })
    public String firstPage(Authentication authentication
    ) {



        return "Hello World" + "\n" +  authentication.getDetails() + "\n" + authentication.getCredentials() + "\n" + authentication.getAuthorities() + "\n" + authentication.getPrincipal();
    }

}