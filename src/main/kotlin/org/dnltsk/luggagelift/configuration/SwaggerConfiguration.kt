package org.dnltsk.luggagelift.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2()
open class SwaggerConfiguration {

    @Bean
    open fun forecastEndpointsDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .groupName("luggagelift")
                .apiInfo(ApiInfoBuilder()
                        .description("""# Luggage Lift 🚀""").build())
                .select().apis(
                RequestHandlerSelectors.basePackage("org.dnltsk.luggagelift")
        )
                .build()


    }

}