package com.bancoConta.clients;

import com.bancoConta.dto.clients.UserInfo;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetUserInfo {

    public UserInfo execute(Integer id){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<UserInfo>  userInfoResponseEntity = restTemplate.exchange(
                "http://localhost:8080/user/{id}",
                HttpMethod.GET,
                entity,
                UserInfo.class,
                id
        );

        return userInfoResponseEntity.getBody();
    }
}
