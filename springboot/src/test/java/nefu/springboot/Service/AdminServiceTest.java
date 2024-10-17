package nefu.springboot.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AdminServiceTest {

    @Autowired
    private  AdminService adminService;
    @Test
    void addDepartment() {
    }

    @Test
    void listDepartment() {
    }

    @Test
    void removeDepartment() {
        adminService.removeDepartment("3");
    }
}