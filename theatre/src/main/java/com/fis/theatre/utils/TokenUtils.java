package com.fis.theatre.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtils {

	@Value("backend")
	private String APP_NAME;

	@Value("shhhh")
	private String SECRET;

	@Value("1800000")
	private int EXPIRES_IN;

	@Value("Authorization")
	private String AUTH_HEADER;

	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

	public String generateToken(String email) {
		return Jwts.builder()
				.setIssuer(APP_NAME)
				.setSubject(email)
				.setAudience("web")
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + EXPIRES_IN))
				.signWith(SIGNATURE_ALGORITHM, SECRET)
				.compact();
	}

	public String getToken(HttpServletRequest request) {

		String authHeader = request.getHeader(AUTH_HEADER);
		System.out.println(authHeader);
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}
		return null;
	}

	public Claims getAllClaimsFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
		return claims;
	}

	public String getEmailFromToken(String token) {
		Claims claims = this.getAllClaimsFromToken(token);
		String email = claims.getSubject();
		return email;
	}

	public Date getIssuedAtDateFromToken(String token) {
		Claims claims = this.getAllClaimsFromToken(token);
		Date issuedAt = claims.getIssuedAt();
		return issuedAt;
	}

	public String getAudienceFromToken(String token) {
		Claims claims = this.getAllClaimsFromToken(token);
		String audience = claims.getAudience();
		return audience;
	}

	public Date getExpirationDateFromToken(String token) {
		Claims claims = this.getAllClaimsFromToken(token);
		Date exp = claims.getExpiration();
		return exp;
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		String username = getEmailFromToken(token);
//		Date created = getIssuedAtDateFromToken(token);

		return (username != null && username.equals(userDetails.getUsername()));
	}
}
