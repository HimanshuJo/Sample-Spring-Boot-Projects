package main.java.com.capgemini.Student_Service_Filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class SimpleFilter extends ZuulFilter{

    private static Logger log=LoggerFactory.getLogger(SimpleFilter.class);

    @Override
    public String filterType(){
        log.info("PRE");
        return "pre";
    }

    @Override
    public int filterOrder(){
        return 1;
    }

    @Override
    public boolean shouldFilter(){
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}