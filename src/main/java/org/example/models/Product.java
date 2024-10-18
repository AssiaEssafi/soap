package org.example.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Date;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product {
    private Integer code;
    private String name;
    private Double price;
    @XmlTransient
    private Date datecreation;

    public Product() {
    }


    public Product(Integer code, String name, Double price, Date datecreation) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.datecreation = datecreation;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }
}
