package nefu.springboot.controller;

import lombok.RequiredArgsConstructor;
import nefu.springboot.dox.Score;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.TeacherService;
import nefu.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;
import nefu.springboot.dox.Process;

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
    //辅导学生
    @GetMapping("students/mentor")
    public ResultVO studentMentor(@RequestAttribute("depId")String depId,@RequestAttribute("uid") String uid){

        return ResultVO.success(Map.of("mentorStudents",teacherService.mentorStudents(depId, uid)));
    }

    //添加过程
    @GetMapping("processes")
    public ResultVO processList(@RequestAttribute("depId") String depId){
        return ResultVO.success(Map.of("processes",userService.listProcess(depId)));
    }
    @PostMapping("processes")
    public ResultVO addProcess(Process process){
        return ResultVO.success(Map.of("process",teacherService.addProcess(process)));
    }


    //添加分数
    @GetMapping("scores")
    public ResultVO listScore(){

    }

    @PostMapping("scores")
    public ResultVO addScore(Score score){
        return ResultVO.success(Map.of("score",teacherService.addScore(score)));
    }
}
