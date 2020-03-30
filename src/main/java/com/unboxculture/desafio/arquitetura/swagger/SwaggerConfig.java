package com.unboxculture.desafio.arquitetura.swagger;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicates;
import com.unboxculture.desafio.arquitetura.config.ApplicationProperties;
import io.swagger.annotations.ApiModel;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.Entity;
import javax.servlet.ServletContext;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Autowired
    private TypeResolver resolver;

    @Autowired
    private ApplicationProperties properties;

    @SuppressWarnings("Convert2MethodRef")
    @Bean
    public Docket produceApi(ServletContext servletContext) {

        String entityPackage = "com.unboxculture.desafio.core.entity";
        String docsPackage = "com.unboxculture.desafio.api.projection";
        Class[] entityClasses = getClassesFromPackage(entityPackage, Entity.class);
        Class[] docsClasses = getClassesFromPackage(docsPackage, ApiModel.class);

        List<ResponseMessage> responseMessages = Arrays.asList(
                new ResponseMessageBuilder().code(201).message("Recurso criado com sucesso").build(),
                new ResponseMessageBuilder().code(401).message("Usuário não autenticado").build(),
                new ResponseMessageBuilder().code(403).message("Sem permissão para realizar operação").build(),
                new ResponseMessageBuilder().code(404).message("Recurso não encontrado").build());

        return new Docket(DocumentationType.SWAGGER_2)
                .host(properties.getSwaggerHost())
                .ignoredParameterTypes(entityClasses)
                .additionalModels(
                        resolver.resolve(String.class),
                        Stream.of(docsClasses).map(c -> resolver.resolve(c)).toArray(size -> new ResolvedType[size]))
                .globalResponseMessage(RequestMethod.POST, responseMessages)
                .globalResponseMessage(RequestMethod.PUT, responseMessages)
                .globalResponseMessage(RequestMethod.DELETE, responseMessages)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.unboxculture.desafio.api.resources"))
                .paths(Predicates.alwaysTrue())
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Desafio Rest APIs")
                .description("Desafio Rest APIs")
                .version("0.0.1-SNAPSHOT")
                .build();
    }

    private Class[] getClassesFromPackage(String prefix, Class<? extends Annotation> annotation) {
        Reflections reflections = new Reflections(prefix);
        Set<Class<?>> entityPackage = reflections.getTypesAnnotatedWith(annotation);
        return entityPackage.toArray(new Class[entityPackage.size()]);
    }
}
