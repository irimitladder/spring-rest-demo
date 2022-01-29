package irimi.springrestdemo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class<?>[] servletConfigClasses = new Class<?>[] {AppConfig.class};
        return servletConfigClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String[] servletMappings = new String[] {"/"};
        return servletMappings;
    }
}
