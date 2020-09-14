package moe.sannaha.web;

import moe.sannaha.pojo.DailyLog;
import moe.sannaha.service.DailyLogServiceImpl;
import moe.sannaha.utils.AuthenticateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddServlet", urlPatterns = "/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        DailyLog dailyLog = new DailyLog();

        String d_date = req.getParameter("d_date");
        dailyLog.setD_date(d_date);
        dailyLog.setT_waketime(req.getParameter("t_waketime"));
        dailyLog.setT_bedtime(req.getParameter("t_bedtime"));
        dailyLog.setVc_improvetime(req.getParameter("vc_improvetime"));
        dailyLog.setVc_improve(req.getParameter("vc_improve"));
        dailyLog.setVc_fishingtime(req.getParameter("vc_fishingtime"));
        dailyLog.setVc_fishing(req.getParameter("vc_fishing"));
        dailyLog.setVc_eurekatime(req.getParameter("vc_eurekatime"));
        dailyLog.setVc_eureka(req.getParameter("vc_eureka"));
        dailyLog.setVc_activitytime(req.getParameter("vc_activitytime"));
        dailyLog.setVc_activity(req.getParameter("vc_activity"));
        dailyLog.setVc_remark(req.getParameter("vc_remark"));

        DailyLogServiceImpl dailyLogService = new DailyLogServiceImpl();

        //IP鉴权
        boolean ipFlag  = AuthenticateUtils.getIPFlag(req, d_date);
        if (ipFlag) {
            //校验起床时间和上床时间
            if (dailyLog.getT_bedtime() != null && dailyLog.getT_bedtime().compareTo(dailyLog.getT_waketime()) < 0) {
                resp.getWriter().print("<script language='javascript'>alert('上床时间不能早于起床时间');history.go(-1);</script>");
            } else {
                try {
                    dailyLogService.add(dailyLog);
                    resp.getWriter().print("<script language='javascript'>alert('添加成功');window.location.href='/query';</script>");
                } catch (Exception e) {
                    e.printStackTrace();
                    resp.getWriter().print("<script language='javascript'>alert('添加失败');history.go(-1);</script>");
                }
            }
        } else {
            resp.getWriter().print("<script language='javascript'>alert('您没有操作权限！');window.location.href='/show.html';</script>");
        }

    }
}
