package nefu.springboot.repository;

import lombok.extern.slf4j.Slf4j;
import nefu.springboot.dox.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;

    @Value("${role.manager}")
    private String role;

    @Test
    void findByAccount() {
        User user =userRepository.findByAccount("1");
        log.info("{}",role);
    }

    @Test
    void updatePasswordByAccount() {
    }
    @Test
    void countTest(){
        Integer count =userRepository.countByDepartment("2");
        log.info("{}",count);
    }
}