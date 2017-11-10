package com.vinsen.filter;

import com.google.common.base.Strings;
import com.vinsen.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhangshengwen
 * @date 2017/11/6
 */
public class CommFilter implements Filter {


    private static final String STATIC_RESOURCE_REGEX = ".*\\.(js|png|css|woff2|map)$";


    /**
     * 封装，不需要过滤的list列表
     */
    protected static List<Pattern> patterns = new ArrayList<Pattern>();

    static {
        Pattern druidPattern = Pattern.compile("/admin/.*");
        patterns.add(druidPattern);

        Pattern swaggerPattern = Pattern.compile("/swagger-ui.html");
        patterns.add(swaggerPattern);

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String requestUri = ((HttpServletRequest) request).getRequestURI();
        HttpSession session = ((HttpServletRequest) request).getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        if (!isInclude(requestUri) || isStaticResource(requestUri)) {
            chain.doFilter(request, response);
            return;
        }

        if (requestUri.equals("/admin/")
                || currentUser != null) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect("/admin/");
        }

    }

    @Override
    public void destroy() {

    }


    /**
     * 是否需要过滤
     *
     * @param url
     * @return
     */
    private boolean isInclude(String url) {
        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(url);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }


    private boolean isStaticResource(String uri) {
        return !Strings.isNullOrEmpty(uri) && uri.matches(STATIC_RESOURCE_REGEX);
    }

}
