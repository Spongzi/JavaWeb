package com.github.pojo;

/**
 * 创建一个商品类
 */
public class Brand {
    private Integer id; // 主键
    private String brandName; // 品牌名称
    private String companyName; // 企业名称
    private Integer ordered; // 排序字段
    private String description; // 描述信息
    private Integer status; // 状态 0：禁用  1：启用

    public Brand() {
    }

    public Brand(int id, String brand_name, String company_name, int ordered, String description, int status) {
        this.id = id;
        this.brandName = brand_name;
        this.companyName = company_name;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brand_name='" + brandName + '\'' +
                ", company_name='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
