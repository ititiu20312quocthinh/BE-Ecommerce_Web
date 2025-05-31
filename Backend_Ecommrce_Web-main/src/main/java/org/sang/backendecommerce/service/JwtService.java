package org.sang.backendecommerce.service;

import io.jsonwebtoken.Claims;
import java.security.Key;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;


public interface JwtService {
	String generateToken(UserDetails userDetails);
	boolean isTokenValid(String token, UserDetails userDetails);
	boolean isTokenExpired(String token);
	Key getSignKey();
	Claims extractAllClaims(String token);
	<T> T extractClaim(String Token, Function<Claims, T> claimsResolvers);
	String extractUserName(String token);
}
