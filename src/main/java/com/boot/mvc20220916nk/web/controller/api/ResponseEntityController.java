package com.boot.mvc20220916nk.web.controller.api;

import com.boot.mvc20220916nk.web.dto.CMRespDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Controller
public class ResponseEntityController {

    @GetMapping("/api/v1/entity/data1")
    public ResponseEntity<?> getData() {

        // return new ResponseEntity<String>(HttpStatus.BAD_REQUEST); // OK, INTERNAL_SERVER_ERROR ...
        // return new ResponseEntity<String>("ResponseEntity 응답", INTERNAL_SERVER_ERROR); // 응답 -> JSON 아니고 TEXT 로 날라감. body 가 실질적인 응답 데이터.

        MultiValueMap<String, String> headers = new HttpHeaders();

        headers.add("test-token", UUID.randomUUID().toString());
        headers.add("test-token", UUID.randomUUID().toString());
        headers.add("test-token", UUID.randomUUID().toString());

        // return new ResponseEntity<String>("test", headers, HttpStatus.OK);

        return new ResponseEntity<>(
                new CMRespDto(1, "전송 성공", "테스트 데이터"),
                headers,
                HttpStatus.OK);

    }

    @GetMapping("/api/v1/entity/data5")
    public ResponseEntity<?> getData5() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token1", "aaaa1111");

        return ResponseEntity   // 생성을 왜 안해줘도 되는거징??
                    .ok()
                    .headers(headers)
                    .body(new CMRespDto(1, "message", "test"));
    }

    @GetMapping("/api/v1/entity/data6")
    public ResponseEntity<?> getStudent() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("token1", "aaaa1111");

        return ResponseEntity   // 생성을 왜 안해줘도 되는거징??
                .ok()
                .headers(headers)
                .body(new CMRespDto(1, "message", "test"));

    }


}
