package com.example.dto;

import java.util.Date;
import java.util.List;

public class DscOrder {
    private Integer id;

    private String status;

    private Date createdDate;

    private Date updatedDate;

    private String orderNo;

    private List<ProductDetailDto> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public List<ProductDetailDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetailDto> products) {
        this.products = products;
    }
}