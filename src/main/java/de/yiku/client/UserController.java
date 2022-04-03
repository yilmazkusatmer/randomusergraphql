package de.yiku.client;

import de.yiku.domain.User;
import de.yiku.domain.UserInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
@SchemaMapping(value = "User")
public class UserController {
    @MutationMapping
    public User addUser(@Argument UserInput userInput) {
        User user = new User();
        user.setEmail(userInput.getEmail());
        log.info("Add new User with email {}", user.getEmail());
        // save in db
        return user;
    }
}
