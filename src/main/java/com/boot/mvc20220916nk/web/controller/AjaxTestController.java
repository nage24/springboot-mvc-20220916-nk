package com.boot.mvc20220916nk.web.controller;

import com.boot.mvc20220916nk.web.dto.AddPostReqDto;
import com.boot.mvc20220916nk.web.dto.CMRespDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AjaxTestController {

    @GetMapping("/ajax/{id}") // http://localhost:8000/ajax/1 <- 이렇게 들어가야 댐.
    public String loadAjax(@PathVariable int id) {

        return "ajax/ajax" + id;
    }

}
