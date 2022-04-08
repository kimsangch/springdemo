package com.acompany.springdemo.advice;

import com.acompany.springdemo.annotation.TokenRequired;
import com.acompany.springdemo.service.SecurityServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

@Aspect
@Component
public class SecurityAspect {

    @Before("@annotation(tokenRequired)")
    public void authWithToken(TokenRequired tokenRequired) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        //Check Token in request header
        String tokenInHeader = request.getHeader("token");
        if (StringUtils.hasText(tokenInHeader)) {
            throw new IllegalArgumentException("Empty token");
        }

        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SecurityServiceImpl.secretKey))
                .parseClaimsJws(tokenInHeader).getBody();
        if (claims == null || claims.getSubject() == null) {
            throw new IllegalArgumentException("Token Error : Claim is null");
        }
        System.out.println("토큰에 포함된 subject로 자체 인증 처리 필요");


    }

}
