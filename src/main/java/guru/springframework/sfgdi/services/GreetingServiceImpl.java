package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

// Service is similar to controller / says this is a Spring managed component 

@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World";
    }
}
