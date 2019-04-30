package com.zxy.scientific_research.bean;

public class Bt {
    private Integer btno;

    private String bno;

    private String tno;

    public Integer getBtno() {
        return btno;
    }

    public void setBtno(Integer btno) {
        this.btno = btno;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno == null ? null : bno.trim();
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
        sb.append(", btno=").append(btno);
        sb.append(", bno=").append(bno);
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
        Bt other = (Bt) that;
        return (this.getBtno() == null ? other.getBtno() == null : this.getBtno().equals(other.getBtno()))
            && (this.getBno() == null ? other.getBno() == null : this.getBno().equals(other.getBno()))
            && (this.getTno() == null ? other.getTno() == null : this.getTno().equals(other.getTno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBtno() == null) ? 0 : getBtno().hashCode());
        result = prime * result + ((getBno() == null) ? 0 : getBno().hashCode());
        result = prime * result + ((getTno() == null) ? 0 : getTno().hashCode());
        return result;
    }
}