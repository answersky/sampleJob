package com.gangling.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by liufeng
 * 2018/12/4
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public String hanleArithmeticException(){
        return "发生错误了";
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException( Exception exception){
        ModelAndView model=new ModelAndView("error");
        exception.printStackTrace();
        model.addObject("error",exception.getMessage());
        return model;
    }
}
