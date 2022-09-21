package com.boot.mvc20220916nk.web.controller.api;

/*
    CM ; Commit Message
    CMResponse
    Commit Message 를 포함한 응답
 */

import Student.web.dto.StudentRespDto;
import com.boot.mvc20220916nk.web.dto.CMRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CMResponseController {

    @GetMapping("/api/v1/cm/data1")
    public CMRespDto<?> getData() {
        return new CMRespDto<String>(1, "데이터 응답 성공", "테스트 데이터");
        // StudentList 를 키 값을 주기 위해 Map 에 넣었었음.
        // 얘는 기본 키값이 있으니 뭐 필요없음.
    }

    @GetMapping("/api/v1/cm/data2")
    public CMRespDto<?> getData2() {
        return new CMRespDto<Boolean>(-1, "데이터 응답 실패", false);
    }

    @GetMapping("/api/v1/cm/data3")
    public CMRespDto<?> getData3() {
        List<StudentRespDto> dtoList = new ArrayList<StudentRespDto>();
        dtoList.add(StudentRespDto.builder().studentCode(1).build()); // ctrl d
        dtoList.add(StudentRespDto.builder().studentCode(2).build());
        dtoList.add(StudentRespDto.builder().studentCode(3).build());
        dtoList.add(StudentRespDto.builder().studentCode(4).build());

        return new CMRespDto<>(1, "학생 정보 리스트 데이터 입니다. ", dtoList);

    }


}
