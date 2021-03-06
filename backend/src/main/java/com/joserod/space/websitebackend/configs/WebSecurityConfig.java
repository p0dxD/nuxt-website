package com.joserod.space.websitebackend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
http.csrf().disable();
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .httpBasic();
            http.cors();
		// http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:3000","https://joserod.space","https://joserod.space:82")
						.allowedMethods("*")
						.allowedHeaders("*", "Access-Control-Allow-Headers", "origin", "Content-type", "accept", "x-requested-with", "x-requested-by") //What is this for?
						.allowCredentials(true);
			}
		};
	} 
}