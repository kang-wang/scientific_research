package com.zxy.scientific_research.bean;

public class Manager {
    private String mno;

    private String mname;

    private String mpass;

    private String mtatus;

    private String mts;

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno == null ? null : mno.trim();
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getMpass() {
        return mpass;
    }

    public void setMpass(String mpass) {
        this.mpass = mpass == null ? null : mpass.trim();
    }

    public String getMtatus() {
        return mtatus;
    }

    public void setMtatus(String mtatus) {
        this.mtatus = mtatus == null ? null : mtatus.trim();
    }

    public String getMts() {
        return mts;
    }

    public void setMts(String mts) {
        this.mts = mts == null ? null : mts.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mno=").append(mno);
        sb.append(", mname=").append(mname);
        sb.append(", mpass=").append(mpass);
        sb.append(", mtatus=").append(mtatus);
        sb.append(", mts=").append(mts);
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
        Manager other = (Manager) that;
        return (this.getMno() == null ? other.getMno() == null : this.getMno().equals(other.getMno()))
            && (this.getMname() == null ? other.getMname() == null : this.getMname().equals(other.getMname()))
            && (this.getMpass() == null ? other.getMpass() == null : this.getMpass().equals(other.getMpass()))
            && (this.getMtatus() == null ? other.getMtatus() == null : this.getMtatus().equals(other.getMtatus()))
            && (this.getMts() == null ? other.getMts() == null : this.getMts().equals(other.getMts()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMno() == null) ? 0 : getMno().hashCode());
        result = prime * result + ((getMname() == null) ? 0 : getMname().hashCode());
        result = prime * result + ((getMpass() == null) ? 0 : getMpass().hashCode());
        result = prime * result + ((getMtatus() == null) ? 0 : getMtatus().hashCode());
        result = prime * result + ((getMts() == null) ? 0 : getMts().hashCode());
        return result;
    }
}