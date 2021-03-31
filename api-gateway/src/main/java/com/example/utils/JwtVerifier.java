package com.example.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.google.common.collect.Maps;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtVerifier {

    private static final String secret = "JwtSecret##123";
    private static final int interval = 10;

    public static String genToken(String userId) {
        Date iatDate = new Date();
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "HS256");
        headerMap.put("typ", "JWT");

        return JWT.create().withHeader(headerMap)
                .withClaim("iss", "Service")
                .withClaim("aud", "APP")
                .withClaim("user_id", userId)
                .withIssuedAt(iatDate)
                .withExpiresAt(DateUtils.addMinutes(iatDate, interval))
                .sign(Algorithm.HMAC256(secret));
    }

    public static Map<String, Claim> verifyToken(String token) {
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token).getClaims();
    }

    public static String getAppUID(String token) {
        return verifyToken(token).get("user_id").asString();
    }
}
