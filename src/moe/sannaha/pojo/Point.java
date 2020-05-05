package moe.sannaha.pojo;

public class Point {
    private String d_date = "00-00";
    private double vc_point = 0.00;

    public Point() {
    }

    public Point(String d_date, double vc_point) {
        this.d_date = d_date;
        this.vc_point = vc_point;
    }

    public String getD_date() {
        return d_date;
    }

    public void setD_date(String d_date) {
        this.d_date = d_date;
    }

    public double getVc_point() {
        return vc_point;
    }

    public void setVc_point(double vc_point) {
        this.vc_point = vc_point;
    }
}
