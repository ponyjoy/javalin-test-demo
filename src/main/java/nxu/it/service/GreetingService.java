package nxu.it.service;

import jakarta.inject.Singleton;

@Singleton
public class GreetingService {

    public String sayHello(){
        return "hello!";
    }

    public String sayGoodBye(){
        return "bye!";
    }
}
