package com.sevent.shihuilaw.config;

import com.sevent.shihuilaw.domain.JsonSimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by liupengfei on 2017/3/24.
 * 全局异常捕捉
 * 返回map
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonSimpleResponse defaultExceptionHandler(HttpServletRequest request,
                                                      HttpServletResponse response, Exception e){
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        e.printStackTrace();
        if(e.getClass().getName().equals(NullPointerException.class.getName())){
            return new JsonSimpleResponse(false,200,"NullPointerException");
        }
        return new JsonSimpleResponse(false,500,e.getMessage());
    }
}
