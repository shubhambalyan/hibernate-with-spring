package learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product-list")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "products")
public class Product
{
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;
    @Column(name = "unit_price")
    private Double unitPrice;
    @Column(name = "units_in_stock")
    private Integer unitsInStock;
    @Column(name = "units_on_order")
    private Integer unitsOnOrder;
    @Column(name = "reorder_level")
    private Integer reorderLevel;
    private Integer discontinued;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Supplier getSupplier()
    {
        return supplier;
    }

    public void setSupplier(final Supplier supplier)
    {
        this.supplier = supplier;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(final Category category)
    {
        this.category = category;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public void setProductId(final Integer productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(final String productName)
    {
        this.productName = productName;
    }

    public String getQuantityPerUnit()
    {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(final String quantityPerUnit)
    {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Double getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(final Double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitsInStock()
    {
        return unitsInStock;
    }

    public void setUnitsInStock(final Integer unitsInStock)
    {
        this.unitsInStock = unitsInStock;
    }

    public Integer getUnitsOnOrder()
    {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(final Integer unitsOnOrder)
    {
        this.unitsOnOrder = unitsOnOrder;
    }

    public Integer getReorderLevel()
    {
        return reorderLevel;
    }

    public void setReorderLevel(final Integer reorderLevel)
    {
        this.reorderLevel = reorderLevel;
    }

    public Integer getDiscontinued()
    {
        return discontinued;
    }

    public void setDiscontinued(final Integer discontinued)
    {
        this.discontinued = discontinued;
    }
}
