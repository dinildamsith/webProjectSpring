package lk.ijse.d_zone_backend;

import lk.ijse.d_zone_backend.config.WebAppConfig;
import lk.ijse.d_zone_backend.config.WebAppRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class webAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override // Dispatch Servlet Initialization
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
