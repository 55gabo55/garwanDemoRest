package sk.gabrielkostialik.garwanDemoRest.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExist extends RuntimeException {
    public UserAlreadyExist(String name) {
        super("User with username: '" + name + "' already exist.");
    }
}
