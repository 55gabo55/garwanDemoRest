package sk.gabrielkostialik.garwanDemoRest.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnimalCategoryNotFoundException extends RuntimeException {
    public AnimalCategoryNotFoundException(String name) {
        super("Could not find AnimalCategory with name: " + name);
    }
}


