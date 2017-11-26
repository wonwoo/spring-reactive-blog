package me.wonwoo;

import com.samskivert.mustache.Mustache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.samskivert.mustache.Mustache.compiler;

@SpringBootApplication
public class SpringReactiveBlogApplication {

	@Bean
	public Mustache.Compiler mustacheCompiler(Mustache.TemplateLoader loader) {
		return compiler().escapeHTML(false).withLoader(loader);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveBlogApplication.class, args);
	}
}
