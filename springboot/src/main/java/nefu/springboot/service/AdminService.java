package nefu.springboot.service;

import lombok.RequiredArgsConstructor;
import nefu.springboot.dox.Department;
import nefu.springboot.dto.Code;
import nefu.springboot.exception.XException;
import nefu.springboot.repository.DepartmentRepository;
import nefu.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
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


}
