package moe.sannaha.web;

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

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        DailyLogServiceImpl dailyLogService = new DailyLogServiceImpl();

        //IP鉴权
        boolean ipFlag = AuthenticateUtils.getIPFlag(req, idStr);
        if (ipFlag) {
            //删除
            try {
                dailyLogService.delete(id);
                resp.getWriter().print("<script language='javascript'>alert('删除成功');window.location.href='https://dailylog.sannaha.moe/query';</script>");
            } catch (SQLException e) {
                e.printStackTrace();
                resp.getWriter().print("<script language='javascript'>alert('删除失败');window.location.href='https://dailylog.sannaha.moe/query';</script>");
            }
        } else {
            resp.getWriter().print("<script language='javascript'>alert('您没有操作权限！');window.location.href='https://dailylog.sannaha.moe/show.html';</script>");
        }

    }
}