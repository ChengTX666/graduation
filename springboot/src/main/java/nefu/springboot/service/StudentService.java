package nefu.springboot.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.repository.ProcessRepository;
import nefu.springboot.repository.ScoreRepository;
import nefu.springboot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Slf4j
@RequiredArgsConstructor
@RequestMapping()
public class StudentService {
    private final UserRepository userRepository;
    private final ProcessRepository processRepository;
    private final ScoreRepository scoreRepository;

    //选择导师
    public void chooseMentor(String sid,String tid){

    }
}
