package br.com.santasecret.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    public static final String USER = "User";
    public static final String GROUP = "Group";
    public static final String PARTICIPANT = "Participant";
    public static final String DRAW = "Draw";


    @Bean
    public Docket gradeCurricularApi() {
        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.santasecret.api.controller"))
                .build()
                .apiInfo(metadaData())
                .tags(new Tag(USER, "Operations related to the handling User entity"))
                .tags(new Tag(GROUP, "Operations related to the handling Group entity"))
                .tags(new Tag(PARTICIPANT, "Operations related to the handling Participants entity"))
                .tags(new Tag(DRAW, "Operations related to the handling Draw entity"));
    }

    private ApiInfo metadaData() {
        return new ApiInfoBuilder().title("Santa Secret")
                .description("Api responsable for handling santa secret api")
                .version("1.0.0")
                .license("")
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:META-INF/resources/webjars/");
    }

}
