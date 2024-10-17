package nefu.springboot.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.component.JWTComponent;
import nefu.springboot.dox.Department;
import nefu.springboot.dox.User;
import nefu.springboot.dto.Login;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/graduation/")
public class LoginController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;
    private final JWTComponent jwtComponent;


    @PostMapping("login")
    public ResultVO login(@RequestBody Login login, HttpServletResponse resp) {
        User user = userService.getUser(login.getAccount());

        if (user == null || passwordEncoder.matches(login.getPassword(), user.getPassword())) {
            return ResultVO.error(401, "用户名或密码错误");
        }

        Department department=null;
        try {
            department=objectMapper.readValue(user.getDepartment(), Department.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        String jwt = jwtComponent.encode(Map.of("uid", user.getId(), "role", user.getRole(),"depId",department.getDepId(),"group",user.getGroup()));
        resp.addHeader("token", jwt);
        resp.addHeader("role", user.getRole());
        resp.addHeader("depId",department.getDepId());

        return ResultVO.success(Map.of("user", user));
    }
}
