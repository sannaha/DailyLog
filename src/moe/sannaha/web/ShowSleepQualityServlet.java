package moe.sannaha.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import moe.sannaha.pojo.SleepQuality;
import moe.sannaha.service.DailyLogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShowSleepQualityServlet", urlPatterns = "/showSleepQuality")
public class ShowSleepQualityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        try {
            DailyLogServiceImpl dailyLogService = new DailyLogServiceImpl();

            List<SleepQuality> sleepQualityList = dailyLogService.showSleep();

            ObjectMapper om = new ObjectMapper();
            String sleepQualityJson = om.writeValueAsString(sleepQualityList);
            resp.getWriter().write(sleepQualityJson);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}