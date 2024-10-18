package nefu.springboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.service.StudentService;
import nefu.springboot.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class StudentController {
    private final UserService userService;
    private final StudentService studentService;

}
