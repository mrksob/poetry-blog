package poetryBlog.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@AllArgsConstructor
@EnableConfigurationProperties(JwtConfig.class)
@Configuration
public class JwtSecretKey {

    private final JwtConfig jwtConfig;

    @Bean
    public SecretKey secretKey() {

        return Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());
    }
}

