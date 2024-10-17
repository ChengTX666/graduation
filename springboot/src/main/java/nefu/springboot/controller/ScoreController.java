package nefu.springboot.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import nefu.springboot.dox.Score;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ScoreController {
    private final ScoreService scoreService;
    private final ObjectMapper objectMapper;

    @GetMapping("score")
    public ResultVO myScore(@RequestAttribute String uid){
        List<Score> score = scoreService.myScore(uid);
        return ResultVO.success(Map.of("score",score));
    }
}
