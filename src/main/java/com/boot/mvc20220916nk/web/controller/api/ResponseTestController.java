package com.boot.mvc20220916nk.web.controller.api;

import Student.web.dto.StudentRespDto;
import com.boot.mvc20220916nk.web.dto.ResponseDataDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @Controller
@RestController // api 만 있으니까 @RestController 달아주믄 댐.
public class ResponseTestController {

    // @ResponseBody
    @GetMapping("/api/v1/data1")
    public Map<String, Object> getData() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("이름", "신짱구");
        data.put("연락처", "연락처가 없어요. ");

        return data;
        // @ResponseBody 를 붙이지 않았을 때는 @Controller 가 ViewName 을 리턴.
        // 그럼 Dispatcher 가 View Reserve 에서 View 파일 경로를 찾아 View 를 리턴해준다.
        
        // Map 을 Gson 을 사용해 Json 형태로 바꿔주었어야 했는데, 
        // 스프링에서는 자동으로 Json 형태로 응답이 보내진다. 
        // @ResponseBody 어노테이션이 응답 자료형이 객체이면, 자동으로  JSON 으로 변환을 해준다.
    }

    // @ResponseBody
    @GetMapping("/api/v1/data2")
    public ResponseDataDto getData2() {
        return ResponseDataDto.builder()
                .value1("문자열 데이터")
                .value2(1010)
                .value3(true)
                .build();
    }

    // @ResponseBody
    @GetMapping("/api/v1/data3")
    public Object getData3() {

        return ResponseDataDto.builder()
                .value1("문자열 데이터 2")
                .value2(2020)
                .value3(false)
                .build();
    }

    @GetMapping("/api/v1/students")
    public Object getData4() {

        Map<String, Object> responseMap = new HashMap<String, Object>();
        List<StudentRespDto> students = new ArrayList<StudentRespDto>();


        StudentRespDto student1 = StudentRespDto.builder()
                .studentCode(20220001)
                .studentName("김준일")
                .studentYear(2)
                .studentAddress("부산 진구")
                .studentPhone("010-9988-1916")
                .build();

        students.add(student1);

        StudentRespDto student2 = StudentRespDto.builder()
                .studentCode(20220002)
                .studentName("김준이")
                .studentYear(2)
                .studentAddress("부산시 동래구")
                .studentPhone("010-9999-1234")
                .build();

        students.add(student2);

        // return students;         리스트를 보내면 ... -> Serialize ... 해서 ArrayList zero 오류가 뜸.
        // Json 은 Getter 가 없으면 못 들고 오기 때문에 StudentResDto 에 @Getter 어노테이션을 달면, 정상적으로 가져오는 걸 볼 수 있다.

        responseMap.put("students1", students);

        // return students;
        return responseMap;
    }
}
