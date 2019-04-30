package com.zxy.scientific_research.bean;

public class Et {
    private Integer etno;

    private String eno;

    private String tno;

    public Integer getEtno() {
        return etno;
    }

    public void setEtno(Integer etno) {
        this.etno = etno;
    }

    public String getEno() {
        return eno;
    }

    public void setEno(String eno) {
        this.eno = eno == null ? null : eno.trim();
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
        sb.append(", etno=").append(etno);
        sb.append(", eno=").append(eno);
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
        Et other = (Et) that;
        return (this.getEtno() == null ? other.getEtno() == null : this.getEtno().equals(other.getEtno()))
            && (this.getEno() == null ? other.getEno() == null : this.getEno().equals(other.getEno()))
            && (this.getTno() == null ? other.getTno() == null : this.getTno().equals(other.getTno()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEtno() == null) ? 0 : getEtno().hashCode());
        result = prime * result + ((getEno() == null) ? 0 : getEno().hashCode());
        result = prime * result + ((getTno() == null) ? 0 : getTno().hashCode());
        return result;
    }
}