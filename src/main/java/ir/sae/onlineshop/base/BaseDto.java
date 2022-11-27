package ir.sae.onlineshop.base;

import java.util.Date;

public abstract class BaseDto{

    private Integer version;
    private Date createDate;

    private Date updateDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public BaseDto(Integer version, Date createDate, Date updateDate) {
        this.version = version;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public BaseDto() {
    }
}
