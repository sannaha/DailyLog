package moe.sannaha.pojo;

public class Sleep {
    private String d_date = "00-00";
    private double vc_sleepTime = 0.0;

    public Sleep() {
    }

    public Sleep(String d_date, double vc_sleepTime) {
        this.d_date = d_date;
        this.vc_sleepTime = vc_sleepTime;
    }

    public String getD_date() {
        return d_date;
    }

    public void setD_date(String d_date) {
        this.d_date = d_date;
    }

    public double getVc_sleepTime() {
        return vc_sleepTime;
    }

    public void setVc_sleepTime(double vc_sleepTime) {
        this.vc_sleepTime = vc_sleepTime;
    }
}
