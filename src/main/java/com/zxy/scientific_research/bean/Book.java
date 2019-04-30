package com.zxy.scientific_research.bean;

public class Book {
    private String bno;

    private String bname;

    private String bleader;

    private Short bgrade;

    private String bstatus;

    private String bstarttime;

    private String bupdatetime;

    private String bendtime;

    private String bts;

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno == null ? null : bno.trim();
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getBleader() {
        return bleader;
    }

    public void setBleader(String bleader) {
        this.bleader = bleader == null ? null : bleader.trim();
    }

    public Short getBgrade() {
        return bgrade;
    }

    public void setBgrade(Short bgrade) {
        this.bgrade = bgrade;
    }

    public String getBstatus() {
        return bstatus;
    }

    public void setBstatus(String bstatus) {
        this.bstatus = bstatus == null ? null : bstatus.trim();
    }

    public String getBstarttime() {
        return bstarttime;
    }

    public void setBstarttime(String bstarttime) {
        this.bstarttime = bstarttime == null ? null : bstarttime.trim();
    }

    public String getBupdatetime() {
        return bupdatetime;
    }

    public void setBupdatetime(String bupdatetime) {
        this.bupdatetime = bupdatetime == null ? null : bupdatetime.trim();
    }

    public String getBendtime() {
        return bendtime;
    }

    public void setBendtime(String bendtime) {
        this.bendtime = bendtime == null ? null : bendtime.trim();
    }

    public String getBts() {
        return bts;
    }

    public void setBts(String bts) {
        this.bts = bts == null ? null : bts.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bno=").append(bno);
        sb.append(", bname=").append(bname);
        sb.append(", bleader=").append(bleader);
        sb.append(", bgrade=").append(bgrade);
        sb.append(", bstatus=").append(bstatus);
        sb.append(", bstarttime=").append(bstarttime);
        sb.append(", bupdatetime=").append(bupdatetime);
        sb.append(", bendtime=").append(bendtime);
        sb.append(", bts=").append(bts);
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
        Book other = (Book) that;
        return (this.getBno() == null ? other.getBno() == null : this.getBno().equals(other.getBno()))
            && (this.getBname() == null ? other.getBname() == null : this.getBname().equals(other.getBname()))
            && (this.getBleader() == null ? other.getBleader() == null : this.getBleader().equals(other.getBleader()))
            && (this.getBgrade() == null ? other.getBgrade() == null : this.getBgrade().equals(other.getBgrade()))
            && (this.getBstatus() == null ? other.getBstatus() == null : this.getBstatus().equals(other.getBstatus()))
            && (this.getBstarttime() == null ? other.getBstarttime() == null : this.getBstarttime().equals(other.getBstarttime()))
            && (this.getBupdatetime() == null ? other.getBupdatetime() == null : this.getBupdatetime().equals(other.getBupdatetime()))
            && (this.getBendtime() == null ? other.getBendtime() == null : this.getBendtime().equals(other.getBendtime()))
            && (this.getBts() == null ? other.getBts() == null : this.getBts().equals(other.getBts()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBno() == null) ? 0 : getBno().hashCode());
        result = prime * result + ((getBname() == null) ? 0 : getBname().hashCode());
        result = prime * result + ((getBleader() == null) ? 0 : getBleader().hashCode());
        result = prime * result + ((getBgrade() == null) ? 0 : getBgrade().hashCode());
        result = prime * result + ((getBstatus() == null) ? 0 : getBstatus().hashCode());
        result = prime * result + ((getBstarttime() == null) ? 0 : getBstarttime().hashCode());
        result = prime * result + ((getBupdatetime() == null) ? 0 : getBupdatetime().hashCode());
        result = prime * result + ((getBendtime() == null) ? 0 : getBendtime().hashCode());
        result = prime * result + ((getBts() == null) ? 0 : getBts().hashCode());
        return result;
    }
}