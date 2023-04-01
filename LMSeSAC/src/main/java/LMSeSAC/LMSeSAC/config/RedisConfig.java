package LMSeSAC.LMSeSAC.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Value("${spring.redis.host}")
	private String redisHost;
	@Value("${spring.redis.port}")
	private Integer redisPort;
	@Value("${spring.redis.user}")
	private String redisName;
	@Value("${spring.redis.password}")
	private String redisPassword;

	// @Bean
	// public RedisClusterConfiguration redisClusterConfiguration() {
	// 	RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration();
	// 	clusterConfiguration.clusterNode(redisHost, redisPort);
	// 	clusterConfiguration.setUsername(redisName);
	// 	clusterConfiguration.setPassword(redisPassword);
	// 	new LettuceConnectionFactory(clusterConfiguration);
	// 	return clusterConfiguration;
	// }
	//
	// @Bean
	// public ConfigureRedisAction configureRedisAction() {
	// 	return ConfigureRedisAction.NO_OP;
	// }

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName(redisHost);
		redisStandaloneConfiguration.setPort(redisPort);
		redisStandaloneConfiguration.setUsername(redisName);
		redisStandaloneConfiguration.setPassword(redisPassword);
		// 패스워드 있으면 설정
		//        redisStandaloneConfiguration.setPassword(redisPwd);
		LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
		return lettuceConnectionFactory;
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		return redisTemplate;
	}
}
