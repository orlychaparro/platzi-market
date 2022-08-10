package com.platzi.market.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

@Component
public class JWTUtil {
    private static final String KEY = "pl4tz1pl4tz1pl4tz1pl4tz1pl4tz1pl4tz1pl4tz1pl4tz1pl4tz1pl4tz1";
    byte[] keyBytes = Decoders.BASE64.decode(KEY);
    Key key = Keys.hmacShaKeyFor(keyBytes);

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                //.signWith(SignatureAlgorithm.HS256, KEY).compact();
                .signWith(key)
                .compact();
                //or signWith(Key, SignatureAlgorithm)
                //.signWith(SignatureAlgorithm.HS256, secretKeyFor(SignatureAlgorithm.HS256))
               // .compact();

               // jwtBuilder.signWith(key); //or signWith(Key, SignatureAlgorithm)
    }

    public boolean validateToken(String token, UserDetails userDetails){
       return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);

    }

    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }

    public Claims getClaims(String token){
        //return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
         return Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(token).getBody();
    }

}
