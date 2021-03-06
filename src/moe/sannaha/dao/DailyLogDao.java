package moe.sannaha.dao;

import moe.sannaha.pojo.DailyLog;
import moe.sannaha.pojo.IpPool;
import moe.sannaha.pojo.Sleep;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface DailyLogDao {
    //查询
    List<DailyLog> query() throws SQLException;

    //查询得分（无权限用户）
    List<DailyLog> showPoint() throws SQLException;

    //查询得分（无权限用户）
    List<Sleep> showSleep() throws SQLException;

    //添加
    void add(DailyLog dailyLog) throws ParseException, SQLException;

    //删除
    void delete(int id) throws SQLException;

    //回显
    DailyLog queryById(int id) throws SQLException;

    //修改
    void update(DailyLog dailyLog) throws ParseException, SQLException;

    //ip鉴权
    List<IpPool> verify() throws SQLException;
}
