package nefu.springboot.repository;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.dox.Process;
import nefu.springboot.dox.User;
import nefu.springboot.dto.Login;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ProcessRepositoryTest {
    @Autowired
    private ProcessRepository processRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void jackson(){
//        错误原因：jackson版本不对，mvc包中自带有，不需要重新导入
        Login login=new Login();
        login.setAccount("123");
        login.setPassword("456");
        String json = null;
        try {
            json = objectMapper.writeValueAsString(login);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("{}",json);
    }
    @Test
    void jackson2() throws JsonProcessingException {

        Map<String,Login> map=new HashMap<>();
        map.put("1",new Login("111","123"));
        map.put("2",new Login("222","123"));
        String json=objectMapper.writeValueAsString(map);
        log.info("{}",json);
        Map<String,Login> reMap =objectMapper.readValue(json, new TypeReference<Map<String, Login>>() {});
        log.info("{}",reMap);
    }


}