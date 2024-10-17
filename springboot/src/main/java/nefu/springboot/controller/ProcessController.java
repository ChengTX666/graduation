package nefu.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nefu.springboot.dox.Process;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.ProcessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/graduation/")
@Slf4j
@RequiredArgsConstructor
public class ProcessController {
    private final ProcessService processService;
    private final ObjectMapper objectMapper;

    @GetMapping("process")
    public ResultVO showProcess(@RequestAttribute String depId){
        List<Process> processList = processService.showProcess(depId);
        Map<String,Object> data=new HashMap<>();
        data.put("processList",processList);
        return ResultVO.success(data);
    }
}
