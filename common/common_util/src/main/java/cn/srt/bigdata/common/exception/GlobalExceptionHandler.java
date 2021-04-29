package cn.srt.bigdata.common.exception;

import cn.srt.bigdata.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author shkstart
 * @create 2021-04-29 22:12
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 表示处理Exception类型的异常
     * 打印输出堆栈信息
     * @ExceptionHandler：表示处理什么类型的信息
     * @Responsebody:表示以json的形式返回信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(YyghException.class)
    @ResponseBody
    public Result error(YyghException e) {
        e.printStackTrace();
        return Result.fail();
    }

}
