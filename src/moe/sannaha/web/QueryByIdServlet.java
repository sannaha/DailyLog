package moe.sannaha.web;

import moe.sannaha.pojo.DailyLog;
import moe.sannaha.service.DailyLogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "QueryByIdServlet", urlPatterns = "/queryById")
public class QueryByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DailyLogServiceImpl dailyLogService = new DailyLogServiceImpl();
        DailyLog dailyLog = null;
        try {
            dailyLog = dailyLogService.queryById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("dailyLog", dailyLog);
        req.getRequestDispatcher("/update.jsp").forward(req, resp);
    }
}
