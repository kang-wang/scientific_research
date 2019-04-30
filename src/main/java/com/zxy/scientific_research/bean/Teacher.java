package com.zxy.scientific_research.bean;

public class Teacher {
    private String tno;

    private String tname;

    private Short tsex;

    private String ttel;

    private String tdept;

    private String tduty;

    private String tpass;

    private String temail;

    private String tstatus;

    private String tts;

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno == null ? null : tno.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Short getTsex() {
        return tsex;
    }

    public void setTsex(Short tsex) {
        this.tsex = tsex;
    }

    public String getTtel() {
        return ttel;
    }

    public void setTtel(String ttel) {
        this.ttel = ttel == null ? null : ttel.trim();
    }

    public String getTdept() {
        return tdept;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept == null ? null : tdept.trim();
    }

    public String getTduty() {
        return tduty;
    }

    public void setTduty(String tduty) {
        this.tduty = tduty == null ? null : tduty.trim();
    }

    public String getTpass() {
        return tpass;
    }

    public void setTpass(String tpass) {
        this.tpass = tpass == null ? null : tpass.trim();
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail == null ? null : temail.trim();
    }

    public String getTstatus() {
        return tstatus;
    }

    public void setTstatus(String tstatus) {
        this.tstatus = tstatus == null ? null : tstatus.trim();
    }

    public String getTts() {
        return tts;
    }

    public void setTts(String tts) {
        this.tts = tts == null ? null : tts.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tno=").append(tno);
        sb.append(", tname=").append(tname);
        sb.append(", tsex=").append(tsex);
        sb.append(", ttel=").append(ttel);
        sb.append(", tdept=").append(tdept);
        sb.append(", tduty=").append(tduty);
        sb.append(", tpass=").append(tpass);
        sb.append(", temail=").append(temail);
        sb.append(", tstatus=").append(tstatus);
        sb.append(", tts=").append(tts);
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
        Teacher other = (Teacher) that;
        return (this.getTno() == null ? other.getTno() == null : this.getTno().equals(other.getTno()))
            && (this.getTname() == null ? other.getTname() == null : this.getTname().equals(other.getTname()))
            && (this.getTsex() == null ? other.getTsex() == null : this.getTsex().equals(other.getTsex()))
            && (this.getTtel() == null ? other.getTtel() == null : this.getTtel().equals(other.getTtel()))
            && (this.getTdept() == null ? other.getTdept() == null : this.getTdept().equals(other.getTdept()))
            && (this.getTduty() == null ? other.getTduty() == null : this.getTduty().equals(other.getTduty()))
            && (this.getTpass() == null ? other.getTpass() == null : this.getTpass().equals(other.getTpass()))
            && (this.getTemail() == null ? other.getTemail() == null : this.getTemail().equals(other.getTemail()))
            && (this.getTstatus() == null ? other.getTstatus() == null : this.getTstatus().equals(other.getTstatus()))
            && (this.getTts() == null ? other.getTts() == null : this.getTts().equals(other.getTts()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTno() == null) ? 0 : getTno().hashCode());
        result = prime * result + ((getTname() == null) ? 0 : getTname().hashCode());
        result = prime * result + ((getTsex() == null) ? 0 : getTsex().hashCode());
        result = prime * result + ((getTtel() == null) ? 0 : getTtel().hashCode());
        result = prime * result + ((getTdept() == null) ? 0 : getTdept().hashCode());
        result = prime * result + ((getTduty() == null) ? 0 : getTduty().hashCode());
        result = prime * result + ((getTpass() == null) ? 0 : getTpass().hashCode());
        result = prime * result + ((getTemail() == null) ? 0 : getTemail().hashCode());
        result = prime * result + ((getTstatus() == null) ? 0 : getTstatus().hashCode());
        result = prime * result + ((getTts() == null) ? 0 : getTts().hashCode());
        return result;
    }
}