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

@WebServlet(name = "QueryServlet", urlPatterns = "/query")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        //IP鉴权
        boolean ipFlag = AuthenticateUtils.getIPFlag(req, "query");
        if (ipFlag) {
            try {
                DailyLogServiceImpl dailyLogService = new DailyLogServiceImpl();
                List<DailyLog> list = null;
                list = dailyLogService.queryDailyLog();
                req.setAttribute("list", list);
                req.getRequestDispatcher("query.jsp").forward(req, resp);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            resp.getWriter().print("<script language='javascript'>window.location.href='show.html';</script>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
