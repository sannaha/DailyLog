package moe.sannaha.pojo;

public class SleepQuality {
    private String quality = "";
    private int times = 0;

    public SleepQuality() {
    }

    public SleepQuality(String quality, int times) {
        this.quality = quality;
        this.times = times;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
