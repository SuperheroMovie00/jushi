package com.jushi.web.routers;

import com.jushi.api.routers.BaseRouters;
import com.jushi.web.handler.CommentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
@Configuration
public class CommentRouters extends BaseRouters<CommentHandler> {
    @Bean
    public RouterFunction<ServerResponse> serverResponseRouterFunction(CommentHandler commentHandler) {
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                   RequestPredicates.POST("/issueComment"),
                   commentHandler::issueComment

        );
          return RouterFunctions.nest(
                //相当于类上面的@RequestMapping
                RequestPredicates.path("/comment"),
                baseRoute(route, commentHandler)
        );
    }
}
