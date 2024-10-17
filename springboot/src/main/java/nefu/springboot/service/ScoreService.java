package nefu.springboot.service;

import lombok.RequiredArgsConstructor;
import nefu.springboot.dox.Score;
import nefu.springboot.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;



    //学生查看自己的得分
    public List<Score> myScore(String studentId){
        return scoreRepository.findByStudentId(studentId);
    }

}
