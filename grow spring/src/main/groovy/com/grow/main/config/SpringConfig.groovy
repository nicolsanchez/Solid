package com.grow.main.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.afterburner.AfterburnerModule
import java.text.SimpleDateFormat
import java.util.TimeZone
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.annotation.Order
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@ComponentScan("com.grow")
@Configuration
@EnableAutoConfiguration
 class SpringConfig implements WebMvcConfigurer {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"

    @Bean
    @Primary
     ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT)
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"))
        objectMapper.setDateFormat(sdf)
        return objectMapper
    }



    private AfterburnerModule createAfterburnerModule() {
        AfterburnerModule afterburnerModule = new AfterburnerModule()

        // make Afterburner generate bytecode only for public getters/setter and fields
        // without this, Java 9+ complains of "Illegal reflective access"
        afterburnerModule.setUseValueClassLoader(false)
        return afterburnerModule
    }
}
