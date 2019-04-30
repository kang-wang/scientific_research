package com.zxy.scientific_research.bean;

public class Pt {
    private Integer ptno;

    private String pno;

    private String tno;

    public Integer getPtno() {
        return ptno;
    }

    public void setPtno(Integer ptno) {
        this.ptno = ptno;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno == null ? null : pno.trim();
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno == null ? null : tno.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ptno=").append(ptno);
        sb.append(", pno=").append(pno);
        sb.append(", tno=").append(tno);
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
        Pt other = (Pt) that;
        return (this.getPtno() == null ? other.getPtno() == null : this.getPtno().equals(other.getPtno()))
            && (this.getPno() == null ? other.getPno() == null : this.getPno().equals(other.getPno()))
            && (this.getTno() == null ? other.getTno() == null : this.getTno().equals(other.getTno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPtno() == null) ? 0 : getPtno().hashCode());
        result = prime * result + ((getPno() == null) ? 0 : getPno().hashCode());
        result = prime * result + ((getTno() == null) ? 0 : getTno().hashCode());
        return result;
    }
}