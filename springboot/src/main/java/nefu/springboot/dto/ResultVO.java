package nefu.springboot.dto;

import lombok.*;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultVO {
    private int code;
    private Map<String,Object> data;
    private String message;
    private static final ResultVO EMPTY=ResultVO.builder().code(200).data(Map.of()).build();

    public static ResultVO ok(){
        return EMPTY;
    }


    public static ResultVO success(Map<String,Object> data){
        return ResultVO.builder().code(200).data(data).build();

    }
    public static ResultVO error(int code,String message){
        return ResultVO.builder().code(code).message(message).build();

    }
    public static ResultVO error(Code code){
        return ResultVO.builder().code(code.getCode()).message(code.getMessage()).build();
    }
}