package com.horaoen.smart_safe_campus.mbg.model;

import java.io.Serializable;

public class Organization implements Serializable {
    private Long id;

    private String organName;

    private String parentId;

    private String organId;

    private Integer organType;

    private Long orderField;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public Integer getOrganType() {
        return organType;
    }

    public void setOrganType(Integer organType) {
        this.organType = organType;
    }

    public Long getOrderField() {
        return orderField;
    }

    public void setOrderField(Long orderField) {
        this.orderField = orderField;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", organName=").append(organName);
        sb.append(", parentId=").append(parentId);
        sb.append(", organId=").append(organId);
        sb.append(", organType=").append(organType);
        sb.append(", orderField=").append(orderField);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}