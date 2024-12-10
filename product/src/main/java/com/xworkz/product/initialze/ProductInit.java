package com.xworkz.product.initialze;

import com.xworkz.product.configration.ProductConfigration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ProductInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {
   ProductInit(){
       System.out.println("This is a product initialze const.....");
   }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ProductConfigration.class};
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
