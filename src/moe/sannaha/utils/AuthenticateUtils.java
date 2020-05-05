package moe.sannaha.utils;

import moe.sannaha.service.DailyLogServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AuthenticateUtils {
    public static boolean getIPFlag(HttpServletRequest req,String operate) {
        //获取IP
        String remoteAddr = req.getRemoteAddr();
        //获取访客真实IP
        String remoteIP = null;
        if (req.getHeader("x-forwarded-for") == null) {
            remoteIP = req.getRemoteAddr();
        } else {
            remoteIP = req.getHeader("x-forwarded-for");
        }

        //鉴权
        boolean ipFlag = false;
        DailyLogServiceImpl dailyLogService = new DailyLogServiceImpl();
        try {
            List<String> ipRegexList = dailyLogService.queryIpPool();
            for (String ipRegex : ipRegexList) {
                if (remoteIP != null && remoteIP.matches(ipRegex)) {
                    ipFlag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(DateUtils.getCurrentDate() + "\toperate:"+ operate+"\tremoteIP:" + remoteIP + "\tremoteAddr" + remoteAddr + "\t" + ipFlag);
        return ipFlag;
    }


}
