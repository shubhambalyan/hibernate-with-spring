package learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "products")
public class Product
{
    @Id
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

    /**
     * @return the supplier
     */
    public Supplier getSupplier()
    {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(final Supplier supplier)
    {
        this.supplier = supplier;
    }

    /**
     * @return the category
     */
    public Category getCategory()
    {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(final Category category)
    {
        this.category = category;
    }

    /**
     * @return the productId
     */
    public Integer getProductId()
    {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(final Integer productId)
    {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName()
    {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(final String productName)
    {
        this.productName = productName;
    }

    /**
     * @return the quantityPerUnit
     */
    public String getQuantityPerUnit()
    {
        return quantityPerUnit;
    }

    /**
     * @param quantityPerUnit the quantityPerUnit to set
     */
    public void setQuantityPerUnit(final String quantityPerUnit)
    {
        this.quantityPerUnit = quantityPerUnit;
    }

    /**
     * @return the unitPrice
     */
    public Double getUnitPrice()
    {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(final Double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the unitsInStock
     */
    public Integer getUnitsInStock()
    {
        return unitsInStock;
    }

    /**
     * @param unitsInStock the unitsInStock to set
     */
    public void setUnitsInStock(final Integer unitsInStock)
    {
        this.unitsInStock = unitsInStock;
    }

    /**
     * @return the unitsOnOrder
     */
    public Integer getUnitsOnOrder()
    {
        return unitsOnOrder;
    }

    /**
     * @param unitsOnOrder the unitsOnOrder to set
     */
    public void setUnitsOnOrder(final Integer unitsOnOrder)
    {
        this.unitsOnOrder = unitsOnOrder;
    }

    /**
     * @return the reorderLevel
     */
    public Integer getReorderLevel()
    {
        return reorderLevel;
    }

    /**
     * @param reorderLevel the reorderLevel to set
     */
    public void setReorderLevel(final Integer reorderLevel)
    {
        this.reorderLevel = reorderLevel;
    }

    /**
     * @return the discontinued
     */
    public Integer getDiscontinued()
    {
        return discontinued;
    }

    /**
     * @param discontinued the discontinued to set
     */
    public void setDiscontinued(final Integer discontinued)
    {
        this.discontinued = discontinued;
    }
}
