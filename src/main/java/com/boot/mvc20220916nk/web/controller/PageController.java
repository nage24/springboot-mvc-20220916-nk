package com.boot.mvc20220916nk.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller // 웹 띄워주기 용 ..
public class PageController {

    @GetMapping({"/", "/index"}) // 둘 중 아무거나로 들어와도 이 메소드가 실행이 되는거
    // Handler Mapping 에 uri 를 등록해주는게 GetMapping , 그럼 Dispatcher 가 uri 를 받아서 연결...
    public String loadIndex(Model model) { // Controller 가 Model 객체를 매개변수로 받아서 전달하는 것임 !!!!!!!
        model.addAttribute("name", "갱나");
        return "index";
    }

    @GetMapping("/helloboot") // 여기로 접속하면 이 메소드가 실행이 되고, hello 라고 하는 view 를 찾아준다. model 을 매개변수로 받아서 같이 보내준다~
    public String loadModelToBoot(Model model) {
        model.addAttribute("nowDate", LocalDateTime.now());
        return "hello";
    }

    @GetMapping("/myinfo") // 서버사이드랜더링 : 서버 측에서 html을 완성해서 보여주는 것임.
    public String loadMyInfo(Model model) { // 서버 사이드 랜더링은 모델을 써야하는 것임.
        model.addAttribute("name", "갱나");
        model.addAttribute("age", "23");
        model.addAttribute("phone", "010-1212-3434");
        model.addAttribute("address", "부산시 동래구");
        return "myinfo";
    }

    // * 클라이언트 사이드 랜더링 ; 검색엔진 노출이 안됨! (해결방법 있긴 해요 .. ㅎ) app.js  에서 실행이 됨.

}

