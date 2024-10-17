package nefu.springboot.controller;

import lombok.RequiredArgsConstructor;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.UserService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/")
public class AdminController {
    private final UserService userService;

    @PatchMapping("resetAll")
    public ResultVO resetAll(){
        userService.allUsers().forEach(user -> {
            userService.initPassword(user.getAccount());
        });
        return ResultVO.success(Map.of("users",userService.allUsers()));
    }
}
