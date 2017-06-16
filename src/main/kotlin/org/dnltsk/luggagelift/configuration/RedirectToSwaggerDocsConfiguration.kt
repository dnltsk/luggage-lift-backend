package org.dnltsk.luggagelift.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
open class RedirectToSwaggerDocsConfiguration {

    @Bean
    open fun forwardIndexPagesToSwaggerDoc(): WebMvcConfigurerAdapter {
        return object : WebMvcConfigurerAdapter() {
            override fun addViewControllers(registry: ViewControllerRegistry?) {
                registry!!.addViewController("/").setViewName("redirect:/swagger-ui.html")
                registry.addViewController("/index.html").setViewName("redirect:/swagger-ui.html")
            }
        }
    }

}