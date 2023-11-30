package ru.onko.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.onko.model.jooq.tables.pojos.AccountEntity;
import ru.onko.model.jooq.tables.pojos.RefreshTokenEntity;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class JwtUtil {

    public static final byte ACCESS_TOKEN_EXPIRE_MINUTES = 60;

    public static final byte REFRESH_TOKEN_EXPIRE_DAYS = 30;

    public static final byte EMAIL_VERIFICATION_TOKEN_EXPIRE_DAYS = 30;

    public static final String JWT_PREFIX = "Bearer ";

    private final Algorithm algorithm;

    public JwtUtil(@Value("${security.jwt.secret}") String secret) {
        this.algorithm = Algorithm.HMAC256(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String createEmailVerificationToken(String email) {
        return JWT_PREFIX + JWT.create()
                .withExpiresAt(LocalDateTime
                        .now()
                        .plusDays(EMAIL_VERIFICATION_TOKEN_EXPIRE_DAYS)
                        .toInstant(ZonedDateTime.now(ZoneId.systemDefault()).getOffset()))
                .withClaim("email", email)
                .sign(algorithm);
    }

    public String createJwt(UUID id) {
        return JWT_PREFIX + JWT.create()
                .withExpiresAt(LocalDateTime
                        .now()
                        .plusMinutes(ACCESS_TOKEN_EXPIRE_MINUTES)
                        .toInstant(ZonedDateTime.now(ZoneId.systemDefault()).getOffset()))
                .withClaim("id", id.toString())
                .sign(algorithm);
    }

    public RefreshTokenEntity createRefreshToken(AccountEntity account) {
        return RefreshTokenEntity.builder()
                .name(UUID.randomUUID())
                .accountId(account.getId())
                .expire(LocalDateTime.now().plusDays(REFRESH_TOKEN_EXPIRE_DAYS))
                .build();
    }

    public DecodedJWT verify(String jwt) throws JWTVerificationException {
        jwt = jwt.replaceFirst(JWT_PREFIX, "");
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(jwt);
    }
}
