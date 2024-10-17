package nefu.springboot.Service;

import lombok.extern.slf4j.Slf4j;
import nefu.springboot.dox.User;
import nefu.springboot.repository.UserRepository;
import nefu.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class UserTest {
    @Autowired
    private UserService userService;
    @Test
    void test1(){

        List<User> userList= userService.getUsers("1","1");
        log.info("{}",userList);

    }

}
