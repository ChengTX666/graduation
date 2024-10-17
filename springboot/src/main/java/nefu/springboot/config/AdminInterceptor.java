package nefu.springboot.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import nefu.springboot.dto.Code;
import nefu.springboot.exception.XException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.transaction.xa.XAException;

@Component
@RequiredArgsConstructor
public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String role=(String) request.getAttribute("role");
        if("admin".equals(role)){
            return true;
        }
        throw XException.builder()
                .code(Code.FORBIDDEN)
                .build();
    }
}
