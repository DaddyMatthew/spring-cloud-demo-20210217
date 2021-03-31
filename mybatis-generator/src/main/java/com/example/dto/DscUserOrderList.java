package com.example.dto;

import java.util.Date;

public class DscUserOrderList {
    private Integer id;

    private Integer idOperatorUser;

    private Integer idOrder;

    private Date createdDate;

    private Date updatedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOperatorUser() {
        return idOperatorUser;
    }

    public void setIdOperatorUser(Integer idOperatorUser) {
        this.idOperatorUser = idOperatorUser;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}