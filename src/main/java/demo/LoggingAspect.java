package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // * represents any return type (public,private or protected)
    @Before("execution(* demo.ShoppingCart.checkout())")
    public void loggerBefore() {
        System.out.println("Before Loggers ");
    }

    // first * represents any package second * represents any class in package
    @After("execution(* *.*.checkout())")
    public void loggerAfter() {
        System.out.println("After Loggers ");
    }

    // * represents method with only parameters
    @After("execution(* *.*.checkout(*))")
    public void loggerAfterWithOnlyParam() {
        System.out.println("After Loggers with Only Parameters");
    }

    @After("execution(* *.*.checkout(..))")
    public void loggerAfterWithParam() {
        System.out.println("After Loggers with Parameters");
    }

    @Before("execution(* demo.ShoppingCart.checkout(*))")
    public void logger(JoinPoint joinPoint) {
        System.out.println("JointPoint Signature: " + joinPoint.getSignature());
        System.out.println("JointPoint Argument: " + joinPoint.getArgs()[0].toString());
        System.out.println("Loggers ");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturnPointCut() {
    }

    @AfterReturning(pointcut = "afterReturnPointCut()", returning = "retVal")
    public void afterReturn(String retVal) {
        System.out.println("After Returning : " + retVal);
    }

    @AfterThrowing(pointcut = "execution(* demo.ShoppingCart.printThrowException())", throwing = "error")
    public void afterThrowingException(JoinPoint jp, Throwable error) {
        System.out.println("Method Signature: " + jp.getSignature());
        System.out.println("Exception: " + error);
    }
}
