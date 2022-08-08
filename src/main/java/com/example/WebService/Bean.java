package com.example.WebService;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Description;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class Bean {

   
@Description("Thymeleaf Template Resolver")
public ServletContextTemplateResolver templateResolver() {
    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(null);
    templateResolver.setPrefix("/WEB-INF/views/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("HTML5");

    return templateResolver;
}


@Description("Thymeleaf Template Engine")
public SpringTemplateEngine templateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver());
    templateEngine.setTemplateEngineMessageSource(messageSource());
    return templateEngine;
}

private MessageSource messageSource() {
    return null;
}
}
