package moe.sannaha.web;

import moe.sannaha.service.DailyLogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        DailyLogServiceImpl dailyLogService = new DailyLogServiceImpl();
        try {
            dailyLogService.delete(id);
            resp.getWriter().print("<script language='javascript'>alert('删除成功');window.location.href='query';</script>");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().print("<script language='javascript'>alert('删除失败');window.location.href='query';</script>");
        }

    }
}
