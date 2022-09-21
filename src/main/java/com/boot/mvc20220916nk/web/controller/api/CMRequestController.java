package com.boot.mvc20220916nk.web.controller.api;

import com.boot.mvc20220916nk.web.dto.CMRespDto;
import com.boot.mvc20220916nk.web.dto.AddPostReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class CMRequestController {

    @PostMapping("/api/v1/rp/post")
    public ResponseEntity<?> postData(@RequestParam String title, @RequestParam String writer, @RequestParam String content) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", title);
        map.put("writer", writer);
        map.put("content", content);

        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", map));
    }

    @PostMapping("/api/v1/dto/post")
    public ResponseEntity<?> addPost(AddPostReqDto addPostReqDto) {

        log.info("()", addPostReqDto);

        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", addPostReqDto));
    }




    // formdata / Json 의 구분. formData 로는 !
    // file을 보낼 수 있삼 여러개도 보낼수 있삼 files
    @PostMapping("/api/v1/file/post")
    public ResponseEntity<?> addPost2(AddPostReqDto addPostReqDto) {

        log.info("()", addPostReqDto);

        // return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", addPostReqDto.getFile().getOriginalFilename()));

        String fileName1 =  addPostReqDto.getFile().getOriginalFilename();
        String fileName2 =  addPostReqDto.getFiles().get(0).getOriginalFilename();
        String fileName3 =  addPostReqDto.getFiles().get(1).getOriginalFilename();

        List<String> fileNames = new ArrayList<String>();
        fileNames.add(fileName1);
        fileNames.add(fileName2);
        fileNames.add(fileName3);

        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", fileNames));
    }

    @PostMapping("/api/v1/json/post")
    public ResponseEntity<?> addPost3(@RequestBody AddPostReqDto addPostReqDto) { // json 은 무조건 바디가 따라와야함. 그래야만 json으로 받을 수가 있다.

        log.info("()", addPostReqDto);

        return ResponseEntity.ok(new CMRespDto(1, "게시글 작성 완료", addPostReqDto));
    }

    // put 요청은 MultipartFile , formdata 못 받고 무조건 json 만 받을 수 있어라 그래서 무조건 @RequestBody를 쓰야함
    // 그래서 put 요청시에 파일 받을 땐 post 로 먼가 처리를 해줘야한디야


    @DeleteMapping("/api/v1/post/{id}")
    public ResponseEntity<?> deletePost(@PathVariable int id) {
        log.info("삭제할 게시글 번호: ({})", id);
        return ResponseEntity.ok(new CMRespDto<>(1, "삭제 성공", id));
    }


}
