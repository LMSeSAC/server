package LMSeSAC.LMSeSAC.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${spring.origin.url}")
	private String originUrl;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(request -> {
			final CorsConfiguration configuration = new CorsConfiguration();

			configuration.addAllowedOriginPattern(originUrl);
			configuration.addAllowedHeader("*");
			configuration.addAllowedMethod("*");
			configuration.setAllowCredentials(true);

			return configuration;
		});

		http.csrf().disable().formLogin().disable().headers().frameOptions().disable();
	}
}