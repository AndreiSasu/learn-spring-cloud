package com.example.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${user.role}")
    private String role;

    @Value("${user.password}")
    private String password;

    @Value("${test.property}")
    private String testProperty;

    @Value("${test.local.property}")
    private String localTestProperty;

    @Autowired
    private PropertyConfiguration propertyConfiguration;


    @RequestMapping(
            value = "/whoami/{username}",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello!  You're %s and you'll become a(n) %s, " +
                        "but only if your password is '%s'!\n" +
                        "Also some random property: %s\n" +
                        "Also some test property: %s \n" +
                        "Also some test local property: %s \n",
                username, role, password, propertyConfiguration.getProperty(),
                testProperty, localTestProperty);
    }

}
