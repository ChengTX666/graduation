package nefu.springboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.StudentService;
import nefu.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/graduation/student/")
public class StudentController {
    private final UserService userService;
    private final StudentService studentService;

    //查看所有待选导师
    @GetMapping("teachers")
    public ResultVO listTeacher(@RequestAttribute("depId")String depId){
        return ResultVO.success(Map.of("teachers",studentService.ListTeacher(depId)));
    }


    //局部更新   put的话前端需要传过来一个完整实体，没有提供完整的对象，其余属性应该被清空
   @PatchMapping("teachers/{tid}")
    public ResultVO chooseTeacher(@RequestAttribute("uid")String sid, @PathVariable String tid){
       studentService.chooseMentor(sid,tid);
       return ResultVO.ok();
   }
}
