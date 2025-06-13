package on.focus0147.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handle(ClientNotFoundException ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("problem", ex.getMessage());
        mav.setViewName("error");
        return mav;
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView notFound(HttpServletRequest req) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("problem", "NOT SUPPORTED URL : " + req.getRequestURI());
        mav.setViewName("error");
        return mav;
    }
}
