package moe.sannaha.utils;

import javax.servlet.http.HttpServletRequest;

public class AuthenticateUtils {
    public static String getRemoteIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
}
