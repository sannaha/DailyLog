package moe.sannaha.service;

import moe.sannaha.pojo.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface DailyLogService {
    List<DailyLog> queryDailyLog() throws SQLException;

    List<Point> showPoint() throws SQLException;

    List<SleepQuality> showSleep() throws SQLException;

    void add(DailyLog dailyLog) throws ParseException, SQLException;

    void delete(int id) throws SQLException;

    DailyLog queryById(int id) throws SQLException;

    void update(DailyLog dailyLog) throws ParseException, SQLException;

    List<String> queryIpPool() throws SQLException;
}
