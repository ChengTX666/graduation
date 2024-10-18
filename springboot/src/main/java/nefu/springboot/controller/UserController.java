package nefu.springboot.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.component.JWTComponent;
import nefu.springboot.dox.Department;
import nefu.springboot.dox.User;
import nefu.springboot.dto.Code;
import nefu.springboot.dto.Login;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/graduation/")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;
    private final JWTComponent jwtComponent;


    @PostMapping("/reset")
    public ResultVO resetPassword(@RequestAttribute("uid") String uid,@RequestBody String password){
        userService.resetUser(uid,password);
        return ResultVO.ok();
    }

}
