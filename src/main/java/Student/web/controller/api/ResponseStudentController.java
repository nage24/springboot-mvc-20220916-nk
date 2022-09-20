package Student.web.controller.api;

import Student.web.dto.StudentResDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResponseStudentController {

    @GetMapping("/api/v1/students2")
    public Object getStudentList() {

        List<StudentResDto> students = new ArrayList<StudentResDto>();
        Map<Integer, List<StudentResDto>> studentMap = new HashMap<Integer, List<StudentResDto>>();


        StudentResDto student1 = StudentResDto.builder()
                .studentCode(20220001)
                .studentName("김준일")
                .studentYear(2)
                .studentAddress("부산 진구")
                .studentPhone("010-9988-1916")
                .build();

        students.add(student1);

        StudentResDto student2 = StudentResDto.builder()
                .studentCode(20220002)
                .studentName("김준이")
                .studentYear(2)
                .studentAddress("부산시 동래구")
                .studentPhone("010-9999-1234")
                .build();

        students.add(student2);

        // return students;         리스트를 보내면 ... -> Serialize ... 해서 ArrayList zero 오류가 뜸.
        // Json 은 Getter 가 없으면 못 들고 오기 때문에 StudentResDto 에 @Getter 어노테이션을 달면, 정상적으로 가져오는 걸 볼 수 있다.

        return students;
    }
}
