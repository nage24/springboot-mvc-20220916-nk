package com.boot.mvc20220916nk.web.controller.api;

import com.boot.mvc20220916nk.web.dto.CMRespDto;
import Student.web.dto.StudentRespDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ResponseEntityController {

    @GetMapping("/api/v1/entity/data1")
    public ResponseEntity<?> getData() {
        // return new ResponseEntity<String>(HttpStatus.BAD_REQUEST); // OK, INTERNAL_SERVER_ERROR ...
        // return new ResponseEntity<String>("ResponseEntity 응답", INTERNAL_SERVER_ERROR); // 응답 -> JSON 아니고 TEXT 로 날라감. body 가 실질적인 응답 데이터.

        MultiValueMap<String, String> headers = new HttpHeaders();

        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());

        // return new ResponseEntity<String>("test", headers, HttpStatus.OK);
        return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/v1/entity/data3")
    public ResponseEntity<?> getData3() {
        MultiValueMap<String, String> headers = new HttpHeaders();

        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());

        return new ResponseEntity<String>("test", headers, HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data4")
    public ResponseEntity<?> getData4() {
        MultiValueMap<String, String> headers = new HttpHeaders();

        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());

        return new ResponseEntity<>(
                new CMRespDto<>(1, "전송 성공", "테스트 데이터"),
                headers,
                HttpStatus.OK);
    }

    @GetMapping("/api/v1/entity/data5")
    public ResponseEntity<?> getData5() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token1", "aaaa1111");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new CMRespDto<>(1, "메세지", "test"));
    }

    @GetMapping("/api/v1/test/students")
    public ResponseEntity<?> getData6() {
        HttpHeaders headers = new HttpHeaders();
        List<StudentRespDto> dtoList = new ArrayList<StudentRespDto>();

        dtoList.add(StudentRespDto.builder().studentCode(20220001).build());
        dtoList.add(StudentRespDto.builder().studentCode(20220002).build());
        dtoList.add(StudentRespDto.builder().studentCode(20220003).build());
        dtoList.add(StudentRespDto.builder().studentCode(20220004).build());

        StringBuilder studentCodeList = new StringBuilder();

        for(StudentRespDto studentRespDto : dtoList) {
            studentCodeList.append(studentRespDto.getStudentCode());
            studentCodeList.append(", ");
        }
        studentCodeList.delete(studentCodeList.length() - 2, studentCodeList.length());

        headers.add("student_code_list", studentCodeList.toString());
        /*
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .headers(headers)
                .body(new CMRespDto<>(-1, "HTTP 메소드를 확인해 주세요.", dtoList));
        */
        return new ResponseEntity<>(
                new CMRespDto<>(-1, "HTTP 메소드를 확인해 주세요.", dtoList),
                headers,
                HttpStatus.METHOD_NOT_ALLOWED
        );
    }


}
