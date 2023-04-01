package LMSeSAC.LMSeSAC.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import LMSeSAC.LMSeSAC.exception.ApiException;
import LMSeSAC.LMSeSAC.exception.ApiExceptionEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
public class JwtProvider {

	@Value("${spring.jwt.secret}")
	private String secretKey;

	@Value("${spring.jwt.access_token_expiration_time}")
	private Long accessTokenExpirationTime;

	@Value("${spring.jwt.refresh_token_expiration_time}")
	private Long refreshTokenExpirationTime;

	public String generateAccessToken(int id, String userid) {
		return doGenerateToken(id, userid, accessTokenExpirationTime);
	}

	public String generateRefreshToken(int id, String userid) {
		return doGenerateToken(id, userid, refreshTokenExpirationTime);
	}

	public String doGenerateToken(int id, String userid, long expireTime) {
		Claims claims = Jwts.claims();
		claims.put("ID", id);
		claims.put("userid", userid);

		return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + expireTime))
			.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

	public boolean isUsable(String token) {
		if (token.equals("")) {
			throw new ApiException(ApiExceptionEnum.NOT_FOUND_TOKEN_EXCEPTION);
		}

		try {
			Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			throw new ApiException(ApiExceptionEnum.MALFORED_TOKEN_EXCEPTION);
		} catch (ExpiredJwtException e) {
			return false;
		}
	}

	public Session extractAllClaims(String token) throws ExpiredJwtException {
		Claims claims = Jwts.parser().setSigningKey(secretKey)
			.parseClaimsJws(token)
			.getBody();

		Session session = new Session();
		session.setUserid((String)claims.get("userid"));
		session.setId((Integer)claims.get("ID"));

		return session;
	}

	public String extractToken(String authorizationHeader) {
		return authorizationHeader.equals("")
			? authorizationHeader : authorizationHeader.substring("Bearer ".length());
	}
}