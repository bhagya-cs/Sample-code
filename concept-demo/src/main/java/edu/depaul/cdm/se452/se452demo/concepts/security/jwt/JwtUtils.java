package edu.depaul.cdm.se452.se452demo.concepts.security.jwt;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import edu.depaul.cdm.se452.se452demo.concepts.security.relational.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JwtUtils {
    @Value("${app.jwt.secret}")
    private String jwtSecret;
  
    @Value("${app.jwt.expirationMs}")
    private int jwtExpirationMs;
  
    @Value("${app.jwt.cookieName}")
    private String jwtCookie;
  
    public String getJwtFromCookies(HttpServletRequest request) {
      Cookie cookie = WebUtils.getCookie(request, jwtCookie);
      if (cookie != null) {
        return cookie.getValue();
      } else {
        return null;
      }
    }
  
    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
      String jwt = generateTokenFromUsername(userPrincipal.getUsername());
      ResponseCookie cookie = ResponseCookie.from(jwtCookie, jwt).path("/api").maxAge(24 * 60 * 60).httpOnly(true).build();
      return cookie;
    }
  
    public ResponseCookie getCleanJwtCookie() {
      ResponseCookie cookie = ResponseCookie.from(jwtCookie, null).path("/api").build();
      return cookie;
    }
  
    public String getUserNameFromJwtToken(String token) {
      return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
  
    public boolean validateJwtToken(String authToken) {
      try {
        Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
        return true;
      } catch (SignatureException e) {
        log.error("Invalid JWT signature: {}", e.getMessage());
      } catch (MalformedJwtException e) {
        log.error("Invalid JWT token: {}", e.getMessage());
      } catch (ExpiredJwtException e) {
        log.error("JWT token is expired: {}", e.getMessage());
      } catch (UnsupportedJwtException e) {
        log.error("JWT token is unsupported: {}", e.getMessage());
      } catch (IllegalArgumentException e) {
        log.error("JWT claims string is empty: {}", e.getMessage());
      }
  
      return false;
    }
    
    public String generateTokenFromUsername(String username) { 
      log.info("generating token from user");
      return Jwts.builder()
          .setSubject(username)
          .setIssuedAt(new Date())
          .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
          .signWith(SignatureAlgorithm.HS512, jwtSecret)
          .compact();
    }
}