package Student.web.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentRespDto {
    private int studentCode;
    private String studentName;
    private int studentYear;
    private String studentAddress;
    private String studentPhone;
}
