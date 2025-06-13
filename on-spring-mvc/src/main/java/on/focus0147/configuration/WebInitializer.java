package on.focus0147.configuration;

import jakarta.servlet.Filter;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import org.springframework.context.annotation.Description;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.nio.charset.StandardCharsets;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private static final long MAX_FILE_SIZE = 5000000;
    private static final long MAX_REQUEST_SIZE = 5000000;
    private static final int FILE_SIZE_THRESHOLD = 0;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceConfiguration.class, DataJpaConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Description("чтобы работал th:method=\"delete\"" +
            "(посылается post запрос с доп hidden input в form, при получении обрабатывается, как delete-запрос)")
    @Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter cef = new CharacterEncodingFilter();
        cef.setEncoding(StandardCharsets.UTF_8.name());
        cef.setForceEncoding(true);
        return new Filter[]{new HiddenHttpMethodFilter(), cef};
    }

    @Description("чтоб работала загрузка файлов " +
            "и прокидывалось исключение throwExceptionIfNoHandlerFound (чтоб обработать самим)")
    @Override
    public void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
        registration.setMultipartConfig(getMultipartConfigElement());
        super.customizeRegistration(registration);
    }

    private MultipartConfigElement getMultipartConfigElement() {
        return  new MultipartConfigElement(null, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
    }
}
