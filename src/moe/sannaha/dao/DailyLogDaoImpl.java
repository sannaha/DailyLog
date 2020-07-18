package moe.sannaha.dao;

import moe.sannaha.pojo.DailyLog;
import moe.sannaha.pojo.IpPool;
import moe.sannaha.pojo.Point;
import moe.sannaha.pojo.Sleep;
import moe.sannaha.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DailyLogDaoImpl implements DailyLogDao {

    private DataSource dataSource = JDBCUtils.getDataSource();
    private QueryRunner qr = new QueryRunner(dataSource);

    //查询
    @Override
    public List<DailyLog> query() throws SQLException {
        String sql = "select id,d_date,t_waketime,t_bedtime,vc_improvetime,vc_improve,vc_fishingtime,vc_fishing,vc_eurekatime,vc_eureka,vc_activitytime,vc_activity,vc_point,vc_remark,t_updatetime from fact_dailylog order by d_date desc";
        return qr.query(sql, new BeanListHandler<DailyLog>(DailyLog.class));
    }

    //查询得分（无权限用户）
    @Override
    public List<Point> showPoint() throws SQLException {
        String sql = "select d_date,vc_point from (select d_date,vc_point from fact_dailylog order by d_date desc limit 30) t1 order by d_date;";
        return qr.query(sql, new BeanListHandler<Point>(Point.class));
    }

    //查询睡觉时长（无权限用户）
    @Override
    public List<Sleep> showSleep() throws SQLException {
        String sql = "select d_date,vc_sleepTime from ( select t1.d_date,round(time_to_sec(timediff(t1.t_waketime,t2.t_bedtime))/3600,1) vc_sleepTime from fact_dailylog t1 join ( SELECT DATE_add(d_date,INTERVAL '1' DAY) d_date_add,t_bedtime FROM fact_dailylog ) t2 on t1.d_date=t2.d_date_add order by t1.d_date desc limit 7) t3 order by d_date;";
        return qr.query(sql, new BeanListHandler<Sleep>(Sleep.class));
    }

    //添加
    @Override
    public void add(DailyLog dailyLog) throws ParseException, SQLException {
        //获取更新时间
        Date updatetime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //插入
        String sql = "insert into fact_dailylog(id, d_date,t_waketime,t_bedtime,vc_improvetime,vc_improve,vc_fishingtime,vc_fishing,vc_eurekatime,vc_eureka,vc_activitytime,vc_activity,vc_point,vc_remark,t_updatetime) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql, dailyLog.getId(), dailyLog.getD_date(), sdf1.parse(dailyLog.getT_waketime()), sdf1.parse(dailyLog.getT_bedtime()), dailyLog.getVc_improvetime(), dailyLog.getVc_improve(), dailyLog.getVc_fishingtime(), dailyLog.getVc_fishing(), dailyLog.getVc_eurekatime(), dailyLog.getVc_eureka(), dailyLog.getVc_activitytime(), dailyLog.getVc_activity(), dailyLog.getVc_point(), dailyLog.getVc_remark(), updatetime);
    }


    //删除
    @Override
    public void delete(int id) throws SQLException {
        String sql = "delete from fact_dailylog where id = ?";
        qr.update(sql, id);
    }

    //回显
    @Override
    public DailyLog queryById(int id) throws SQLException {
        String sql = "select id,d_date,t_waketime,t_bedtime,vc_improvetime,vc_improve,vc_fishingtime,vc_fishing,vc_eurekatime,vc_eureka,vc_activitytime,vc_activity,vc_point,vc_remark,t_updatetime from fact_dailylog where id = ?";
        DailyLog dailyLog = qr.query(sql, new BeanHandler<DailyLog>(DailyLog.class), id);
        //截去2020-04-14 00:30:00.0 最后的.0
        if (dailyLog.getT_waketime() != null) {
            dailyLog.setT_waketime(dailyLog.getT_waketime().substring(0, 19));
        }
        if (dailyLog.getT_bedtime() != null) {
            dailyLog.setT_bedtime(dailyLog.getT_bedtime().substring(0, 19));
        }
        return dailyLog;
    }

    //修改
    @Override
    public void update(DailyLog dailyLog) throws ParseException, SQLException {
        //获取更新时间
        Date updatetime = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String sql = "update fact_dailylog set d_date = ?, t_waketime = ?, t_bedtime = ?, vc_improvetime = ?, vc_improve = ?, vc_fishingtime = ?, vc_fishing = ?, vc_eurekatime = ?, vc_eureka = ?, vc_activitytime = ?, vc_activity = ?, vc_remark = ?, t_updatetime = ? where id = ?";
        qr.update(sql, dailyLog.getD_date(), sdf1.parse(dailyLog.getT_waketime()), sdf1.parse(dailyLog.getT_bedtime()), dailyLog.getVc_improvetime(), dailyLog.getVc_improve(), dailyLog.getVc_fishingtime(), dailyLog.getVc_fishing(), dailyLog.getVc_eurekatime(), dailyLog.getVc_eureka(), dailyLog.getVc_activitytime(), dailyLog.getVc_activity(), dailyLog.getVc_remark(), updatetime, dailyLog.getId());
    }

    //ip鉴权
    @Override
    public List<IpPool> verify() throws SQLException {
        String sql = "select id,vc_ipregex from di_ippool";
        return qr.query(sql, new BeanListHandler<IpPool>(IpPool.class));
    }

}
