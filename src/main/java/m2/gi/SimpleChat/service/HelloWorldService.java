package m2.gi.SimpleChat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    @Value("${helloWorld:unknown}")
    private String message;

    public String getMessage() {
        return message;
    }

}