package nefu.springboot.controller;

import lombok.RequiredArgsConstructor;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.TeacherService;
import nefu.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher/")
public class TeacherController {
    private final TeacherService teacherService;
    private final UserService userService;


    //查看专业所有学生
    @GetMapping("students")
    public ResultVO studentList(@RequestAttribute("depId") String depId){
        return ResultVO.success(Map.of("students",teacherService.studentList(depId)));
    }
    //组内学生
    @GetMapping("students/group")
    public ResultVO studentGroup(@RequestAttribute("depId")String depId,@RequestAttribute("group")int group){
        return ResultVO.success(Map.of("groupStudents",teacherService.groupStudents(depId, group)));
    }
}
