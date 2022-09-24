package com.boot.mvc20220916nk.web.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AddNewsReqDto {
    private String title;
    private String broadcastingName;
    private List<MultipartFile> files;
    private String content;
}
