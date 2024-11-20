package com.xworkz.kannada.rajkumar;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class Gandadagudi extends AbstractAnnotationConfigDispatcherServletInitializer {

    public Gandadagudi(){
        System.out.println("This is ganadadgudi");
    }


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
