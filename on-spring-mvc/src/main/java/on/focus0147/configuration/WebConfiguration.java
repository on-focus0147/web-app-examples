package on.focus0147.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import java.nio.charset.StandardCharsets;
import java.util.Locale;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"on.focus0147.controllers", "on.focus0147.exception", "on.focus0147.services"})
public class WebConfiguration implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    @Description("указываем, где лежат view")
    public SpringResourceTemplateResolver templateResolver(){
        var resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(this.applicationContext);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCacheable(false);
        return resolver;
    }

    @Bean
    @Description("Настраиваем Thymeleaf")
    public SpringTemplateEngine templateEngine() {
        var engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        engine.setTemplateEngineMessageSource(messageSource());
        engine.setEnableSpringELCompiler(true);
        return engine;
    }

    @Bean
    public ViewResolver viewResolver() {
        var viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8"); // Устанавливаем UTF-8, иначе кодировка, которая не поддерживает РФ
        viewResolver.setContentType("text/html; charset=UTF-8");
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Description("настройка message, чтоб использовались файлы сообщений в зависимсти от локали")
    @Bean
    MessageSource messageSource() {
        var messageResource = new ReloadableResourceBundleMessageSource();
        messageResource.setBasename("classpath:i18n/global");
        messageResource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageResource.setUseCodeAsDefaultMessage(true);
        return messageResource;
    }

    @Description("пути до картинок, стилей")
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/images/**", "/styles/**")
                .addResourceLocations("/images/", "/styles/");
    }

    @Description("перенаправление на домашнюю страницу")
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/home");
    }

    @Description("чтоб менять локаль с помощью ?lang=")
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Description("чтоб менять локаль с помощью ?lang=")
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(Locale.forLanguageTag("ru")); // Установка русского языка по умолчанию
        cookieLocaleResolver.setCookiePath("/");
        return cookieLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Description("чтоб скачивать файлы")
    @Bean(name = DispatcherServlet.MULTIPART_RESOLVER_BEAN_NAME)
    StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

}
