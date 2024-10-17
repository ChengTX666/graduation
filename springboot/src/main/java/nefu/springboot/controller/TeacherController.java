package nefu.springboot.controller;

import lombok.RequiredArgsConstructor;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.TeacherService;
import nefu.springboot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher/")
public class TeacherController {
    private final TeacherService teacherService;
    private final UserService userService;

    @GetMapping("processes")
    public ResultVO processes(@RequestAttribute String depId)
    {
        return ResultVO.success(Map.of("processes",userService.listProcess(depId)));
    }


}
