package moe.sannaha.pojo;

public class Point {
    private String date = "00-00";
    private double totalPoint = 0.00;
    private double improvePoint = 0.00;
    private double fishingPoint = 0.00;
    private double activityPoint = 0.00;

    public Point() {
    }

    public Point(String date, double totalPoint, double improvePoint, double fishingPoint, double activityPoint) {
        this.date = date;
        this.totalPoint = totalPoint;
        this.improvePoint = improvePoint;
        this.fishingPoint = fishingPoint;
        this.activityPoint = activityPoint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPoint() {
        return totalPoint;
    }

    public void setTotalPoint(double totalPoint) {
        this.totalPoint = totalPoint;
    }

    public double getImprovePoint() {
        return improvePoint;
    }

    public void setImprovePoint(double improvePoint) {
        this.improvePoint = improvePoint;
    }

    public double getFishingPoint() {
        return fishingPoint;
    }

    public void setFishingPoint(double fishingPoint) {
        this.fishingPoint = fishingPoint;
    }

    public double getActivityPoint() {
        return activityPoint;
    }

    public void setActivityPoint(double activityPoint) {
        this.activityPoint = activityPoint;
    }
}
