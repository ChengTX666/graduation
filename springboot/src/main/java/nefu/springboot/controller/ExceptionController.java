package nefu.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import nefu.springboot.dto.Code;
import nefu.springboot.dto.ResultVO;
import nefu.springboot.exception.XException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.transaction.xa.XAException;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(XException.class)
    public ResultVO handleValidException(XException e){
        if(e.getCode() !=null){
            return ResultVO.error(e.getCode());
        }
        return ResultVO.error(e.getCodeN(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO handleAllException(Exception e){
        return ResultVO.error(Code.ERROR,e.getMessage());
    }
}
