package com.boot.mvc20220916nk.web.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data // 게터 세터 둘다 필요하고 equals... 등등도 필요. 그냥 Data 씀
public class AddPostReqDto {

    private String writer;
    private String title;
    private String content;


    private MultipartFile file;
    private List<MultipartFile> files;

}
