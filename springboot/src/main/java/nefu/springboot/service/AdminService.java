package nefu.springboot.service;

import lombok.RequiredArgsConstructor;
import nefu.springboot.dox.Department;
import nefu.springboot.dox.User;
import nefu.springboot.dto.Code;
import nefu.springboot.exception.XException;
import nefu.springboot.repository.DepartmentRepository;
import nefu.springboot.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //添加专业
    @Transactional
    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }
    //查看所有的专业
    public List<Department> listDepartment(){
       return departmentRepository.showAll();
    }
    //删除空的专业
    @Transactional
    public void removeDepartment(String did){
       if(userRepository.countByDepartment(did)>0){
           throw XException.builder()
                   .codeN(Code.ERROR)
                   .message("部门包含用户禁止删除")
                   .build();
       }
       departmentRepository.deleteById(did);
    }

    //用户
    public void addUser(User user){
        userRepository.save(user);
    }



    //查看所有用户
    public List<User> allUsers(){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    //初始化加密密码(管理员)
    public void initPassword(String account){
        String encodePassword=passwordEncoder.encode(account);
        userRepository.updatePasswordByAccount(account,encodePassword);
    }

}
