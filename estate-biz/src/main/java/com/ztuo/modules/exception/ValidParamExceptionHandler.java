package com.ztuo.modules.exception;

import com.ztuo.common.utils.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: ValidParamExceptionHandler
 * @author: MrGao
 * @create: 2020/03/10 10:08
 */
@Slf4j
@ControllerAdvice
public class ValidParamExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public RestResponse methodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if(allErrors!=null && allErrors.size()>0){
            return RestResponse.error(allErrors.get(0).getDefaultMessage());
        }else {
            return RestResponse.error("参数有误,请核实");
        }
    }

}
