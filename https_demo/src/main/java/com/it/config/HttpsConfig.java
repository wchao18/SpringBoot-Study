package com.it.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description springboot不同时支持http和https，需要通过http自动转发到https上
 * @date 2019/09/11 10:48
 */
@Configuration
public class HttpsConfig {

    /**
     * springboot的1.x配置和2.x的配置是有区别的
     */
    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer (){
        return new EmbeddedServletContainerCustomizer(){
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                if (container instanceof TomcatEmbeddedServletContainerFactory) {
                    TomcatEmbeddedServletContainerFactory containerFactory =
                            (TomcatEmbeddedServletContainerFactory) container;

                    Connector connector = new Connector(TomcatEmbeddedServletContainerFactory.DEFAULT_PROTOCOL);
                    connector.setPort(8080);
                    containerFactory.addAdditionalTomcatConnectors(connector);
                    connector.setScheme("http");
                    connector.setRedirectPort(8081);
                }
            }
        };
    }

}

