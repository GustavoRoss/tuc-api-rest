package br.com.fabricadeprogramador;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
public class TucApiApplication {

	
//	@Bean
//	public FilterRegistrationBean filtroJwt(){
//		FilterRegistrationBean frb = new FilterRegistrationBean();
//		frb.setFilter(new TokenFilter());
//		frb.addUrlPatterns("/admin/*");
//		return frb;
//	}
	
	@Bean
	public RestTemplate restTemplate(List<HttpMessageConverter<?>> messageConverters) {
	    return new RestTemplate(messageConverters);
	}

	@Bean
	public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
	    return new ByteArrayHttpMessageConverter();
	}

	
	public static void main(String[] args) {
		SpringApplication.run(TucApiApplication.class, args);
	}
}
