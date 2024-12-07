package com.xworkz.forms.intialize;

import com.xworkz.forms.configration.FormsConfigration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.sql.SQLOutput;

public class Forms extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

   public Forms(){
       System.out.println("create the forms initialize const...");
   }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {FormsConfigration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configure) {
        WebMvcConfigurer.super.configureDefaultServletHandling(configure);
        configure.enable();
    }
}
