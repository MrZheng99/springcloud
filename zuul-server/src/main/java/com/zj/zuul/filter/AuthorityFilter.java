package com.zj.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

public class AuthorityFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER-1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request=context.getRequest();
        HttpServletResponse response=context.getResponse();
        /*
        * TODO: 这里校验是否登录
        *  cookie:{openID:token} redis:{token:UserInfo}
        * TODO: 1. 在登陆的时候先把登录信息对应的OPENID存到cookie，在这里取出来看看是否存在        *
        * TODO: 2. 如果不为空，那么就从redis中取出这个对象看是否登录
        *
        *
        * * */
String uri = request.getRequestURI();
if(uri.startsWith("/user/")){
    return true;
}
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
