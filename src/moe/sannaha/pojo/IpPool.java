package moe.sannaha.pojo;

import java.util.Objects;

public class IpPool {
    private int id;
    private String vc_ipregex;

    public IpPool() {
    }

    public IpPool(int id, String vc_ipregex) {
        this.id = id;
        this.vc_ipregex = vc_ipregex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVc_ipregex() {
        return vc_ipregex;
    }

    public void setVc_ipregex(String vc_ipregex) {
        this.vc_ipregex = vc_ipregex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IpPool ipPool = (IpPool) o;
        return id == ipPool.id &&
                Objects.equals(vc_ipregex, ipPool.vc_ipregex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vc_ipregex);
    }

    @Override
    public String toString() {
        return "IpPool{" +
                "id=" + id +
                ", vc_ipregex='" + vc_ipregex + '\'' +
                '}';
    }
}
