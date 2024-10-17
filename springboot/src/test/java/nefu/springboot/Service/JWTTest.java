package nefu.springboot.Service;

import lombok.extern.slf4j.Slf4j;
import nefu.springboot.component.JWTComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
@Slf4j
public class JWTTest {
    @Autowired
    private JWTComponent jwtComponent;



    @Test
    public void test()throws InterruptedException{
//        String token=jwtComponent.encode(Map.of("uid",))
    }


}
