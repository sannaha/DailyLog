package moe.sannaha.pojo;

public class DailyLog {
    private String id;
    private String d_date;
    private String t_waketime;
    private String t_bedtime;
    private String vc_improvetime;
    private String vc_improve;
    private String vc_fishingtime;
    private String vc_fishing;
    private String vc_eurekatime;
    private String vc_eureka;
    private String vc_activitytime;
    private String vc_activity;
    private String vc_point;
    private String vc_remark;
    private String t_updatetime;

    public DailyLog() {
    }


    @Override
    public String toString() {
        return id +
                d_date +
                t_waketime +
                t_bedtime +
                vc_improvetime +
                vc_improve +
                vc_fishingtime +
                vc_fishing +
                vc_eurekatime +
                vc_eureka +
                vc_activitytime +
                vc_activity +
                vc_point +
                vc_remark +
                t_updatetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getD_date() {
        return d_date;
    }

    public void setD_date(String d_date) {
        this.d_date = d_date;
    }

    public String getT_waketime() {
        return t_waketime;
    }

    public void setT_waketime(String t_waketime) {
        this.t_waketime = t_waketime;
    }

    public String getT_bedtime() {
        return t_bedtime;
    }

    public void setT_bedtime(String t_bedtime) {
        this.t_bedtime = t_bedtime;
    }

    public String getVc_improvetime() {
        return vc_improvetime;
    }

    public void setVc_improvetime(String vc_improvetime) {
        this.vc_improvetime = vc_improvetime;
    }

    public String getVc_improve() {
        return vc_improve;
    }

    public void setVc_improve(String vc_improve) {
        this.vc_improve = vc_improve;
    }

    public String getVc_fishingtime() {
        return vc_fishingtime;
    }

    public void setVc_fishingtime(String vc_fishingtime) {
        this.vc_fishingtime = vc_fishingtime;
    }

    public String getVc_fishing() {
        return vc_fishing;
    }

    public void setVc_fishing(String vc_fishing) {
        this.vc_fishing = vc_fishing;
    }

    public String getVc_eurekatime() {
        return vc_eurekatime;
    }

    public void setVc_eurekatime(String vc_eurekatime) {
        this.vc_eurekatime = vc_eurekatime;
    }

    public String getVc_eureka() {
        return vc_eureka;
    }

    public void setVc_eureka(String vc_eureka) {
        this.vc_eureka = vc_eureka;
    }

    public String getVc_activitytime() {
        return vc_activitytime;
    }

    public void setVc_activitytime(String vc_activitytime) {
        this.vc_activitytime = vc_activitytime;
    }

    public String getVc_activity() {
        return vc_activity;
    }

    public void setVc_activity(String vc_activity) {
        this.vc_activity = vc_activity;
    }

    public String getVc_point() {
        return vc_point;
    }

    public void setVc_point(String vc_point) {
        this.vc_point = vc_point;
    }

    public String getVc_remark() {
        return vc_remark;
    }

    public void setVc_remark(String vc_remark) {
        this.vc_remark = vc_remark;
    }

    public String getT_updatetime() {
        return t_updatetime;
    }

    public void setT_updatetime(String t_updatetime) {
        this.t_updatetime = t_updatetime;
    }

    public DailyLog(String id, String d_date, String t_waketime, String t_bedtime, String vc_improvetime, String vc_improve, String vc_fishingtime, String vc_fishing, String vc_eurekatime, String vc_eureka, String vc_activitytime, String vc_activity, String vc_point, String vc_remark, String t_updatetime) {
        this.id = id;
        this.d_date = d_date;
        this.t_waketime = t_waketime;
        this.t_bedtime = t_bedtime;
        this.vc_improvetime = vc_improvetime;
        this.vc_improve = vc_improve;
        this.vc_fishingtime = vc_fishingtime;
        this.vc_fishing = vc_fishing;
        this.vc_eurekatime = vc_eurekatime;
        this.vc_eureka = vc_eureka;
        this.vc_activitytime = vc_activitytime;
        this.vc_activity = vc_activity;
        this.vc_point = vc_point;
        this.vc_remark = vc_remark;
        this.t_updatetime = t_updatetime;
    }
}