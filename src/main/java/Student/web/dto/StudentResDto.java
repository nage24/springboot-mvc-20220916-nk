package Student.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class StudentResDto {
    private int studentCode;
    private String studentName;
    private int studentYear;
    private String studentAddress;
    private String studentPhone;
}

// Response DTO 에는 Getter 가 필요하다 ...
