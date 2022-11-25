package ir.sae.onlineshop.base;

import java.util.Date;

public abstract class BaseDto<T> {

    private T id;

    private Date createDate;

    private Date UpdateDate;

    public BaseDto() {
    }

    public BaseDto(T id) {
        this.id = id;
    }

    public BaseDto(T id, Date createDate, Date updateDate) {
        this.id = id;
        this.createDate = createDate;
        UpdateDate = updateDate;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }
}
