package LMSeSAC.LMSeSAC.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import LMSeSAC.LMSeSAC.utils.JwtProvider;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
	@Value("${spring.origin.url")
	private String originUrl;

	@Value("${spring.interceptor.excludes}")
	private String[] interceptorExcludes;
	private final JwtProvider jwtProvider;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins(originUrl)
			.allowedMethods("*");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserInterceptor(jwtProvider)).addPathPatterns("/**")
			.excludePathPatterns(interceptorExcludes);
	}
}
