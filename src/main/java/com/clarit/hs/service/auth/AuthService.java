package com.clarit.hs.service.auth;

import com.clarit.hs.controller.IAuthService;

import com.clarit.hs.service.exception.RestTemplateResponseErrorHandler;
import com.clarit.hs.service.items.model.LoginRequest;
import com.clarit.hs.service.items.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService implements IAuthService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.security.oauth2.client.provider.keycloak.issuer-uri}")
    private String issueUri;
    @Value("${spring.security.oauth2.client.registration.oauth2-client-credentials.client_id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.oauth2-client-credentials.client_secret}")
    private String clientSecret;
    @Value("${spring.security.oauth2.client.registration.oauth2-client-credentials.authorization-grant-type}")
    private String grantType;

    @Value("${spring.security.oauth2.client.provider.keycloak.token-uri}")
    private String tokenUrl;
    @Value("${spring.security.oauth2.client.registration.oauth2-client-credentials.scope}")
    private String scopeUrl;
    @Value("${keycloak.auth-server-url}")
    private String baseUrl;


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.errorHandler(new RestTemplateResponseErrorHandler()).build();
    }

       @Override
       public ResponseEntity<LoginResponse> getTokenBy(LoginRequest loginRequest) {

           HttpHeaders headers = new HttpHeaders();
           headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

           MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
           map.add("client_id", clientId);
           map.add("client_secret", clientSecret);
           map.add("grant_type", grantType);
           map.add("scope",scopeUrl);
           map.add("username", loginRequest.getUsername());
           map.add("password", loginRequest.getPassword());

           HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, headers);
           ResponseEntity<LoginResponse> response = restTemplate.postForEntity(tokenUrl, httpEntity, LoginResponse.class);

           return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
   }

/*
    @Override
    public ResponseEntity<LoginResponse> getTokenBy(LoginRequest loginRequest) {

        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("client_id",clientId);
        map.add("client_secret",clientSecret);
        map.add("grant_type",grantType);
        map.add("username",loginRequest.getUsername());
        map.add("password",loginRequest.getPassword());

        LoginResponse response = WebClient.create()
                .post()
                .uri(tokenUrl)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(map))
                .retrieve()
                .onStatus(HttpStatus::isError,clientResponse -> Mono.error(new ForbiddenException("not valid user","check ur Details")))
                .bodyToMono(LoginResponse.class)
                .block();
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

     */
}