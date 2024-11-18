package nefu.springboot.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.dox.User;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.repository.ProcessRepository;
import nefu.springboot.repository.ScoreRepository;
import nefu.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@RequestMapping()
public class StudentService {
    private final UserRepository userRepository;
    private final ProcessRepository processRepository;
    private final ScoreRepository scoreRepository;
    @Value("${role.teacher}")
    private String teacher;

    //查看所有导师
    public List<User> ListTeacher(String depId){
        return userRepository.findByDepIdAndRole(depId,teacher);
    }
    //选择导师
    public void chooseMentor(String sid,String tid){
        userRepository.updateStudentById(sid, tid);
    }
    //抢老师

}
