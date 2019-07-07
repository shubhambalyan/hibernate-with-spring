package learning.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import learning.dao.DaoException;

/**
 * AOP: Cross-cutting concerns
 * Keywords: Target(Bean object), Advice(actual job to be done)-before, after,
 * around, after throwing, Aspect(object representing concerns to be addressed),
 * Join Points(Functions), Proxy (Entry Point)
 * Point Cut(subset of join points)
 */
@Component
@Aspect
public class CustomAspect
{
    @Pointcut("execution( * training.dao.ProductDao.count(..))")
    public void pc1()
    {

    }

    @Pointcut("execution( * training.dao.ProductDao.getProductsBySupplier(..))")
    public void pc2()
    {

    }

    // execution ( [return-type-pattern] [package-pattern].
    // [declaring-type-pattern].[method-pattern]([argument-pattern]))
    //@Before("execution( * training..ProductDao.*(..))")
    //@Before("execution( int training..ProductDao.*(..))")
    //@Before("execution( java.util.list training..*Dao.*(..))")
    //@Before("execution( * training..ProductDao.*(..))")
    //@Before("pc1() || pc2()")
    public void methodLogger(final JoinPoint jp)
    {
        System.out.println("---------------------------");
        System.out.println("The function " + jp.getSignature().getName() + " called");
        System.out.println("Arguments supplied are: " + Arrays.toString(jp.getArgs()));
        System.out.println("Target object instanceof: " + jp.getTarget().getClass());
        System.out.println("Kind of JoinPoint is: " + jp.getKind());
        System.out.println("---------------------------");
    }

    @Around("execution(* training.dao.ProductDao.*(Double,Double))")
    public Object swapArgs(final ProceedingJoinPoint pjp)
            throws Throwable
    {
        Object[] args = pjp.getArgs();
        final Double a = new Double(args[0].toString());
        final Double b = new Double(args[1].toString());
        if (a > b)
        {
            args = new Object[] {
                    b,
                    a
            };
        }
        System.out.println("Proceeding towards the target function....");
        final Object retVal = pjp.proceed(args);
        System.out.println("Coming back from the target function....");
        return retVal;
    }

    @AfterThrowing(pointcut = "execution(* training..*Dao.*(..))", throwing = "ex")
    public void convertToDaoException(final Exception ex)
            throws DaoException
    {
        if(ex instanceof DaoException == false)
        {
            throw new DaoException(ex);
        }
    }
}
