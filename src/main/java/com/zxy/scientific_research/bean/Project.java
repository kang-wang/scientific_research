package com.zxy.scientific_research.bean;

public class Project {
    private String pno;

    private String pname;

    private String pleader;

    private Short pgrade;

    private String pstatus;

    private String pstarttime;

    private String pupdatetime;

    private String pendtime;

    private String pts;

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno == null ? null : pno.trim();
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
    }

    public String getPleader() {
        return pleader;
    }

    public void setPleader(String pleader) {
        this.pleader = pleader == null ? null : pleader.trim();
    }

    public Short getPgrade() {
        return pgrade;
    }

    public void setPgrade(Short pgrade) {
        this.pgrade = pgrade;
    }

    public String getPstatus() {
        return pstatus;
    }

    public void setPstatus(String pstatus) {
        this.pstatus = pstatus == null ? null : pstatus.trim();
    }

    public String getPstarttime() {
        return pstarttime;
    }

    public void setPstarttime(String pstarttime) {
        this.pstarttime = pstarttime == null ? null : pstarttime.trim();
    }

    public String getPupdatetime() {
        return pupdatetime;
    }

    public void setPupdatetime(String pupdatetime) {
        this.pupdatetime = pupdatetime == null ? null : pupdatetime.trim();
    }

    public String getPendtime() {
        return pendtime;
    }

    public void setPendtime(String pendtime) {
        this.pendtime = pendtime == null ? null : pendtime.trim();
    }

    public String getPts() {
        return pts;
    }

    public void setPts(String pts) {
        this.pts = pts == null ? null : pts.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pno=").append(pno);
        sb.append(", pname=").append(pname);
        sb.append(", pleader=").append(pleader);
        sb.append(", pgrade=").append(pgrade);
        sb.append(", pstatus=").append(pstatus);
        sb.append(", pstarttime=").append(pstarttime);
        sb.append(", pupdatetime=").append(pupdatetime);
        sb.append(", pendtime=").append(pendtime);
        sb.append(", pts=").append(pts);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Project other = (Project) that;
        return (this.getPno() == null ? other.getPno() == null : this.getPno().equals(other.getPno()))
            && (this.getPname() == null ? other.getPname() == null : this.getPname().equals(other.getPname()))
            && (this.getPleader() == null ? other.getPleader() == null : this.getPleader().equals(other.getPleader()))
            && (this.getPgrade() == null ? other.getPgrade() == null : this.getPgrade().equals(other.getPgrade()))
            && (this.getPstatus() == null ? other.getPstatus() == null : this.getPstatus().equals(other.getPstatus()))
            && (this.getPstarttime() == null ? other.getPstarttime() == null : this.getPstarttime().equals(other.getPstarttime()))
            && (this.getPupdatetime() == null ? other.getPupdatetime() == null : this.getPupdatetime().equals(other.getPupdatetime()))
            && (this.getPendtime() == null ? other.getPendtime() == null : this.getPendtime().equals(other.getPendtime()))
            && (this.getPts() == null ? other.getPts() == null : this.getPts().equals(other.getPts()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPno() == null) ? 0 : getPno().hashCode());
        result = prime * result + ((getPname() == null) ? 0 : getPname().hashCode());
        result = prime * result + ((getPleader() == null) ? 0 : getPleader().hashCode());
        result = prime * result + ((getPgrade() == null) ? 0 : getPgrade().hashCode());
        result = prime * result + ((getPstatus() == null) ? 0 : getPstatus().hashCode());
        result = prime * result + ((getPstarttime() == null) ? 0 : getPstarttime().hashCode());
        result = prime * result + ((getPupdatetime() == null) ? 0 : getPupdatetime().hashCode());
        result = prime * result + ((getPendtime() == null) ? 0 : getPendtime().hashCode());
        result = prime * result + ((getPts() == null) ? 0 : getPts().hashCode());
        return result;
    }
}