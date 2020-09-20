package sk.gabrielkostialik.garwanDemoRest.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PageOutOfLimit extends RuntimeException {
    public PageOutOfLimit() {
        super("Page out of limit.");
    }
}
