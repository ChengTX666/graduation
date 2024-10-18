package nefu.springboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import nefu.springboot.component.JWTComponent;
import nefu.springboot.dox.Department;
import nefu.springboot.dox.Process;
import nefu.springboot.dox.User;
import nefu.springboot.dto.Login;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.repository.ProcessRepository;
import nefu.springboot.repository.UserRepository;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
//    private final JWTComponent jwtComponent;
//    private final ObjectMapper objectMapper;
    private final ProcessRepository processRepository;

    //登录判断
//    public ResultVO login(Login login, HttpServletResponse resp){
//        User user= userRepository.findByAccount(login.getAccount());
//        if (user == null || passwordEncoder.matches(login.getPassword(), user.getPassword())) {
//            return ResultVO.error(401, "用户名或密码错误");
//        }
//        Department department=null;
//        try {
//            department=objectMapper.readValue(user.getDepartment(), Department.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//        String jwt = jwtComponent.encode(Map.of("uid", user.getId(), "role", user.getRole(),"depId",department.getDepId()));
//        resp.addHeader("token", jwt);
//        resp.addHeader("role", user.getRole());
//        //还响应什么？？？？
//        return ResultVO.success(Map.of("user", user));
//    }

    //get登录验证时
     public User getUser(String account){
         return userRepository.findByAccount(account);
    }

    //修改密码
    public void resetUser(String account,String newPassword){
        userRepository.updatePasswordByAccount(account,passwordEncoder.encode(newPassword));
    }
    public List<Process> listProcess(String depId) {
        return processRepository.findByDepId(depId);
    }


}
