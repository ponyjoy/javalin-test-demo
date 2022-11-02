package nxu.it.controller;

import io.avaje.http.api.*;
import nxu.it.service.GreetingService;

@Controller
@Path("/")
public class MainController {

    final GreetingService greetingService;

    MainController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Get("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return greetingService.sayHello();
    }

    @Get("/bye")
    @Produces(MediaType.TEXT_PLAIN)
    public String bye() {
        return greetingService.sayGoodBye();
    }
}
