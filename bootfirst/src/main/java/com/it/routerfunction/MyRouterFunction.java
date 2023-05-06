package com.it.routerfunction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.*;

/**
 * @author wangchao
 * @description TODO
 * @date 2023/04/30 10:08
 */
@Configuration
public class MyRouterFunction {


    /**
     * https://www.cnblogs.com/somefuture/p/15433565.html
     * @return {@code RouterFunction<ServerResponse>}
     */
    @Bean
    public RouterFunction<ServerResponse> getInfoRouter() {
        return RouterFunctions.nest(path("/router"),
                //get请求
                RouterFunctions.route(GET("/test"), request -> {
                            String path = request.path();
                            System.out.println("请求路径:" + path);
                            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body("成功");
                        }
                ).andRoute(POST("/post"), request -> { //两个请求可以合并
                    //post请求获取请求体
                    String body = request.body(String.class);
                    System.out.println(body);
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(body);
                }));
    }

}
