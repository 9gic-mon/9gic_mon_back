package gugicmon.gugic.service.token;

import gugicmon.gugic.exception.InvalidJwtAuthenticationException;
import gugicmon.gugic.service.auth.Co_Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public Co_Token createCoToken(String id) {
        String key = Base64.getEncoder().encodeToString("key".getBytes());

        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        Map<String, Object> payloads = new HashMap<>();
        long expiredTime = 1000 * 60 * 60 * 24 * 7L;

        Date now = new Date();
        now.setTime(now.getTime() + expiredTime);
        payloads.put("exp", now);
        payloads.put("data", id);

        return new Co_Token(Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .compact());
    }

    @Override
    public String verifyToken(String token) {
        String key = Base64.getEncoder().encodeToString(Base64.getEncoder().encodeToString("key".getBytes()).getBytes());
        JwtParser jwtParser = Jwts.parser();
        Claims claims = jwtParser
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();

        Date exp = claims.getExpiration();
        Date now = new Date();

        if (exp.after(now)) {
            return claims.get("data", String.class);
        } else {
            throw new InvalidJwtAuthenticationException("Expired or invalid JWT token");
        }
    }

}
