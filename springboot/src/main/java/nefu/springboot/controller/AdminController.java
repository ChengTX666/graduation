package nefu.springboot.controller;

import lombok.RequiredArgsConstructor;
import nefu.springboot.dox.Department;
import nefu.springboot.dox.User;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.AdminService;
import nefu.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/")
public class AdminController {
    private final AdminService adminService;

    @GetMapping("users")
    public ResultVO userList(){
        return ResultVO.success(Map.of("users",adminService.allUsers()));
    }
    @PostMapping("users")
    public ResultVO addUser(User user){
        adminService.addUser(user);
        return ResultVO.success(Map.of("user",user));//前端拿到user并渲染:XXX已成功添加
    }
    @PutMapping("users/{account}/password")//把指定账户的信息初始化
    public ResultVO resetPassword(@PathVariable String account){
        adminService.initPassword(account);
        return ResultVO.ok();
    }

    //部门
    @GetMapping("departments")
    public ResultVO departmentList(){
        return ResultVO.success(Map.of("department",adminService.listDepartment()));
    }
    @PostMapping("departments")
    public ResultVO addDepartment(Department department){
        return ResultVO.success(Map.of("department",adminService.addDepartment(department)));
    }
    @DeleteMapping("departments/{did}")
    public ResultVO deleteDepartment(@PathVariable String did){
        adminService.removeDepartment(did);
        return ResultVO.ok();
    }
}
