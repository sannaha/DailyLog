package moe.sannaha.service;

import moe.sannaha.dao.DailyLogDaoImpl;
import moe.sannaha.pojo.*;

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
    public List<Point> showPoint() throws SQLException {
        List<DailyLog> dailylogList = dailyLogDao.showPoint();
        ArrayList<Point> pointList = new ArrayList<>();
        for (DailyLog dailylog : dailylogList) {
            Point point = new Point();
            if (dailylog.getD_date() != null && dailylog.getD_date().length() != 0) {
                point.setDate(dailylog.getD_date());
            } else {
                continue;
            }
            if (dailylog.getVc_improvetime() != null && dailylog.getVc_eurekatime() != null && dailylog.getVc_improvetime().length() != 0 && dailylog.getVc_eurekatime().length() != 0) {
                double improveTime = Double.parseDouble(dailylog.getVc_improvetime());
                double eurekaTime = Double.parseDouble(dailylog.getVc_eurekatime());
                point.setImprovePoint((double) (Math.round((improveTime + eurekaTime) * 2500 / 3)) / 100);
            }
            if (dailylog.getVc_fishingtime() != null && dailylog.getVc_fishingtime().length() != 0) {
                double fishingTime = Double.parseDouble(dailylog.getVc_fishingtime());
                point.setFishingPoint(fishingTime <= 4.0 ? (double) (Math.round(20 - 3.2 * (fishingTime - 1.5) * (fishingTime - 1.5)) * 100) / 100 : 0.00);
            }
            if (dailylog.getVc_activity() != null && dailylog.getVc_activity().length() != 0) {
                double activity = Double.parseDouble(dailylog.getVc_activity());
                point.setActivityPoint((double) Math.round(activity / 2) / 100);
            }
            point.setTotalPoint((double) Math.round((point.getImprovePoint() + point.getFishingPoint() + point.getActivityPoint()) * 100) / 100);
            pointList.add(point);
        }
        return pointList;
    }

    @Override
    public List<SleepQuality> showSleep() throws SQLException {
        int goodTimes = 0;
        int fairTimes = 0;
        int poorTimes = 0;
        List<SleepQuality> sleepQualityList = new ArrayList<SleepQuality>();

        List<Sleep> sleepList = dailyLogDao.showSleep();

        for (Sleep sleep : sleepList) {
            if (sleep.getVc_sleepTime() >= 7) {
                goodTimes++;
            } else if (sleep.getVc_sleepTime() <= 5) {
                poorTimes++;
            } else {
                fairTimes++;
            }
        }

        sleepQualityList.add(new SleepQuality("优", goodTimes));
        sleepQualityList.add(new SleepQuality("良", fairTimes));
        sleepQualityList.add(new SleepQuality("差", poorTimes));

        return sleepQualityList;
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
        return dailyLogDao.queryById(id);
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
