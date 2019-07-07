package learning.springbootdemo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "product-list")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "categories")
public class Category
{
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_name")
    private String categoryName;
    private String description;

    @XmlTransient
    @JsonIgnore
    private byte[] picture;

    @XmlTransient
    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> products;

    // helper function to do bidirectional association
    public void addProduct(final Product p)
    {
        this.products.add(p);
        p.setCategory(this);
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(final List<Product> products)
    {
        this.products = products;
    }

    public Category()
    {
    }

    public Integer getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(final Integer categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(final String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public byte[] getPicture()
    {
        return picture;
    }

    public void setPicture(final byte[] picture)
    {
        this.picture = picture;
    }

}
