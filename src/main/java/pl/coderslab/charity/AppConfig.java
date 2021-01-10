package pl.coderslab.charity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.charity.converter.CategoryConverter;
import pl.coderslab.charity.converter.InstitutionConverter;
import pl.coderslab.charity.converter.LocalDateConverter;

import java.time.LocalDate;


@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(getCategoryConverter());
        registry.addConverter(getInstitutionConverter());
        registry.addConverter(getLocalDateConverter());
    }

    @Bean
    public InstitutionConverter getInstitutionConverter(){
        return new InstitutionConverter();
    }
    @Bean
    public CategoryConverter getCategoryConverter(){
        return new CategoryConverter();
    }
    @Bean
    public LocalDateConverter getLocalDateConverter() {
        return new LocalDateConverter();}
}
