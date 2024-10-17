package nefu.springboot.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.dox.Process;
import nefu.springboot.repository.ProcessRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessService {
    private final ProcessRepository processRepository;
    private final ObjectMapper objectMapper;



    public void TeacherAddProcess(Process process){
        processRepository.save(process);
    }


    public List<Process> showProcess(String depId) {
        return processRepository.findByDepId(depId);
    }
}
