package com.boot.mvc20220916nk.web.controller.api;

import com.boot.mvc20220916nk.domain.User;
import com.boot.mvc20220916nk.repository.UserRepository;
import com.boot.mvc20220916nk.web.dto.UserAddReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @Component
@Slf4j
@RestController // 얘를 달면 얘가 생성되어 IoC 에 저장됨. 그때 user Repository도 생성되어있어야 한다는 거임. 그럼 IoC에 저장이 되어 있어야 컨트롤러가 생성됨.
@RequestMapping("/api/v1")
// @RequiredArgsConstructor // -> 이 클래스의 생성자에 UserRepository 가 있어서 늘 같이 생성이 된다는 뜻!
public class UserRestController {

    @Autowired
    @Qualifier("a")
    private UserRepository userRepository; // @RequiredArgsConstructor 에 final 로 해주면 자동으로 연결해 주는 것임 !

    @GetMapping("/users/{userCode}") //  path variable
    public ResponseEntity<?> getUser(@PathVariable int userCode) {

        User user = userRepository.findUserByUserCode(userCode);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/user2/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {

        User user = userRepository.findUserByUserId(userId);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(UserAddReqDto userAddReqDto) {
        int result = userRepository.save(userAddReqDto.toEntity());
        if(result == 0) {
            return ResponseEntity.internalServerError().body("데이터 오류(Server)");
        }
        return ResponseEntity.ok().body("사용자 추가 완료");

    }

}
