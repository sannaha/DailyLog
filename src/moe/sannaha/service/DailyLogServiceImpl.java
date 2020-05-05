package moe.sannaha.service;

import moe.sannaha.dao.DailyLogDaoImpl;
import moe.sannaha.pojo.DailyLog;
import moe.sannaha.pojo.IpPool;
import moe.sannaha.pojo.Point;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DailyLogServiceImpl implements DailyLogService {
    private DailyLogDaoImpl dailyLogDao = new DailyLogDaoImpl();

    @Override
    public List<DailyLog> queryDailyLog() throws SQLException {
        List<DailyLog> list = dailyLogDao.query();

        //截去2020-04-14 00:30:00.0 前面的2020-04-14 和最后的.0
        for (DailyLog dailyLog : list) {
            dailyLog.setT_waketime(dailyLog.getT_waketime().substring(11, 19));
            dailyLog.setT_bedtime(dailyLog.getT_bedtime().substring(11, 19));
            String vc_point = dailyLog.getVc_point();
            if (vc_point != null) {
                dailyLog.setVc_point(String.format("%.2f", Double.parseDouble(vc_point)));
            }
        }
        return list;
    }

    @Override
    public List<Point> showDailyLog() throws SQLException {
        return dailyLogDao.show();
    }

    @Override
    public void add(DailyLog dailyLog) throws ParseException, SQLException {
        dailyLogDao.add(dailyLog);
    }

    @Override
    public void delete(int id) throws SQLException {
        dailyLogDao.delete(id);
    }

    @Override
    public DailyLog queryById(int id) throws SQLException {
        DailyLog dailyLog = dailyLogDao.queryById(id);
        return dailyLog;
    }

    @Override
    public void update(DailyLog dailyLog) throws ParseException, SQLException {
        dailyLogDao.update(dailyLog);
    }

    @Override
    public ArrayList<String> queryIpPool() throws SQLException {
        List<IpPool> ipPoolList = dailyLogDao.verify();
        ArrayList<String> ipRegexList = new ArrayList<>();
        for (IpPool ipPool : ipPoolList) {
            ipRegexList.add(ipPool.getVc_ipregex());
        }
        return ipRegexList;
    }
}
