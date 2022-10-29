package com.porfolioArgPro.mch.Security.jwt;

//Esta clase genera el token

import com.porfolioArgPro.mch.Security.Entity.UsuarioPrincipal;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    
    //Generamos el Token
    public String generateToken(Authentication authentication){
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public String getNombreUsuarioFromToken(String Token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(Token).getBody().getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            //Si pasa todas las aprobaciones va a devolver true 
            return true;
        //Y si no pasa y lo capta alguna de estas excepciones  devuelve false
        }catch(MalformedJwtException e){
            logger.error("Token mal formado");
        }catch(UnsupportedJwtException e){
            logger.error("Token no soportado");
        }catch(ExpiredJwtException e){
            logger.error("Token Expirado");
        }catch(IllegalArgumentException e){
            logger.error("Token Vacio");
        }catch(SignatureException e){
            logger.error("Firma no Valida");
        }
        return false;
    }
}
