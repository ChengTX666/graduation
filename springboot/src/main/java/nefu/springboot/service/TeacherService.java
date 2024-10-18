package nefu.springboot.service;

import lombok.RequiredArgsConstructor;
import nefu.springboot.dox.Process;
import nefu.springboot.dox.Score;
import nefu.springboot.dox.User;
import nefu.springboot.repository.ProcessRepository;
import nefu.springboot.repository.ScoreRepository;
import nefu.springboot.repository.UserRepository;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final ProcessRepository processRepository;
    private final UserRepository userRepository;
    private final ScoreRepository scoreRepository;

    @Value("${role.student}")
    private String student;
    //过程
    @Transactional
    public Process addProcess(Process process){
       return processRepository.save(process);
    }

    @Transactional
    public void removeProcess(String pid,String did){
        processRepository.deleteByIdAndDepId(pid,did);
    }
    //过程
    //得分

    @Transactional//添加得分 打分 前端需要传来的：学生id 过程id 老师id(Attribute里)
    public Score addScore(Score score) {
        if (score.getId()!=null){
            return updateDetailScore(score);
        }
        return scoreRepository.save(score);
    }
    //为空时保存，不为空更新
    @Transactional
    public Score updateDetailScore(Score score){
        if(score.getId()==null){
            return scoreRepository.save(score);
        }
        return scoreRepository.updateDetailById(score.getId(),score.getDetail());
    }
    //查看自己组学生的得分
    public List<Score> listScore(int group){
        return scoreRepository.findScoresByGroup(group);
    }


    //得分
    //用户
    //查看专业所有学生
    public List<User> studentList(String depId){
        return userRepository.findByDepIdAndRole(depId,student);
    }

    //查看自己组的学生
    public List<User> groupStudents(String depId,int group){
       return userRepository.findByDepIdAndRoleAndGroup(depId,student,group);
    }
    //自己辅导的学生
    public List<User> mentorStudents(String depId,String tid){
        return userRepository.mentorStudents(depId,tid);
    }
    //用户
}
