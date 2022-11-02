package nxu.it;

import io.avaje.http.api.WebRoutes;
import io.avaje.inject.Bean;
import io.avaje.inject.BeanScope;
import io.avaje.inject.Factory;
import io.avaje.inject.test.TestScope;
import io.javalin.Javalin;

import java.util.List;

@Factory
@TestScope
public class TestJavalinFactory {
    BeanScope beanScope;

    TestJavalinFactory(BeanScope beanScope) {
        this.beanScope = beanScope;
    }

    @Bean
    public Javalin creatTestApp() {
        Javalin app = Javalin.create();
        List<WebRoutes> webRoutes = beanScope.list(WebRoutes.class);
        app.routes(() -> webRoutes.forEach(WebRoutes::registerRoutes));
        return app;
    }
}
