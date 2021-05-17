package com.onthetrip.example.web.configuration;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.io.ServletContextTemplateLoader;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;

@Configuration
public class HandlebarsConfig {
    public static final String HANDLEBARS_VIEW_BASE_PATH = "/WEB-INF/views/";
    public static final String HANDLEBARS_VIEW_SUFFIX = ".hbs";

    @Autowired
    private ServletContext servletContext;

    @Bean
    public HandlebarsViewResolver handlebarsViewResolver(Handlebars handlebars) {
        HandlebarsViewResolver viewResolver = new HandlebarsViewResolver(handlebars);
        viewResolver.setCache(false);
        return viewResolver;
    }

    @Bean
    public Handlebars handlebars() {
        ServletContextTemplateLoader servletContextTemplateLoader = new ServletContextTemplateLoader(servletContext);
        servletContextTemplateLoader.setPrefix(HANDLEBARS_VIEW_BASE_PATH);
        servletContextTemplateLoader.setSuffix(HANDLEBARS_VIEW_SUFFIX);
        Handlebars handlebars = new Handlebars(servletContextTemplateLoader);
        handlebars.setStartDelimiter("[[");
        handlebars.setEndDelimiter("]]");
        return handlebars;
    }
}
