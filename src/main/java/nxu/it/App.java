package nxu.it;

import io.avaje.http.api.WebRoutes;
import io.avaje.inject.BeanScope;
import io.javalin.Javalin;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8080);

        BeanScope beanScope = BeanScope.builder().shutdownHook(true).build();
        List<WebRoutes> webRoutesList = beanScope.list(WebRoutes.class);
        app.routes(() -> webRoutesList.forEach(WebRoutes::registerRoutes));


    }
}
