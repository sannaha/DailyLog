package moe.sannaha.service;

import moe.sannaha.pojo.DailyLog;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface DailyLogService {
    public List<DailyLog> queryDailyLog() throws SQLException;

    void add(DailyLog dailyLog) throws ParseException, SQLException;

    void delete(int id) throws SQLException;

    DailyLog queryById(int id) throws SQLException;

    void update(DailyLog dailyLog) throws ParseException, SQLException;
}
