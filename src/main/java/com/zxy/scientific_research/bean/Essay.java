package com.zxy.scientific_research.bean;

public class Essay {
    private String eno;

    private String ename;

    private String eleader;

    private String egrade;

    private String estatus;

    private String estarttime;

    private String eupdatetime;

    private String eendtime;

    private String ets;

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno == null ? null : eno.trim();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getEleader() {
        return eleader;
    }

    public void setEleader(String eleader) {
        this.eleader = eleader == null ? null : eleader.trim();
    }

    public String getEgrade() {
        return egrade;
    }

    public void setEgrade(String egrade) {
        this.egrade = egrade == null ? null : egrade.trim();
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus == null ? null : estatus.trim();
    }

    public String getEstarttime() {
        return estarttime;
    }

    public void setEstarttime(String estarttime) {
        this.estarttime = estarttime == null ? null : estarttime.trim();
    }

    public String getEupdatetime() {
        return eupdatetime;
    }

    public void setEupdatetime(String eupdatetime) {
        this.eupdatetime = eupdatetime == null ? null : eupdatetime.trim();
    }

    public String getEendtime() {
        return eendtime;
    }

    public void setEendtime(String eendtime) {
        this.eendtime = eendtime == null ? null : eendtime.trim();
    }

    public String getEts() {
        return ets;
    }

    public void setEts(String ets) {
        this.ets = ets == null ? null : ets.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eno=").append(eno);
        sb.append(", ename=").append(ename);
        sb.append(", eleader=").append(eleader);
        sb.append(", egrade=").append(egrade);
        sb.append(", estatus=").append(estatus);
        sb.append(", estarttime=").append(estarttime);
        sb.append(", eupdatetime=").append(eupdatetime);
        sb.append(", eendtime=").append(eendtime);
        sb.append(", ets=").append(ets);
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
        Essay other = (Essay) that;
        return (this.getEno() == null ? other.getEno() == null : this.getEno().equals(other.getEno()))
            && (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()))
            && (this.getEleader() == null ? other.getEleader() == null : this.getEleader().equals(other.getEleader()))
            && (this.getEgrade() == null ? other.getEgrade() == null : this.getEgrade().equals(other.getEgrade()))
            && (this.getEstatus() == null ? other.getEstatus() == null : this.getEstatus().equals(other.getEstatus()))
            && (this.getEstarttime() == null ? other.getEstarttime() == null : this.getEstarttime().equals(other.getEstarttime()))
            && (this.getEupdatetime() == null ? other.getEupdatetime() == null : this.getEupdatetime().equals(other.getEupdatetime()))
            && (this.getEendtime() == null ? other.getEendtime() == null : this.getEendtime().equals(other.getEendtime()))
            && (this.getEts() == null ? other.getEts() == null : this.getEts().equals(other.getEts()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEno() == null) ? 0 : getEno().hashCode());
        result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
        result = prime * result + ((getEleader() == null) ? 0 : getEleader().hashCode());
        result = prime * result + ((getEgrade() == null) ? 0 : getEgrade().hashCode());
        result = prime * result + ((getEstatus() == null) ? 0 : getEstatus().hashCode());
        result = prime * result + ((getEstarttime() == null) ? 0 : getEstarttime().hashCode());
        result = prime * result + ((getEupdatetime() == null) ? 0 : getEupdatetime().hashCode());
        result = prime * result + ((getEendtime() == null) ? 0 : getEendtime().hashCode());
        result = prime * result + ((getEts() == null) ? 0 : getEts().hashCode());
        return result;
    }
}