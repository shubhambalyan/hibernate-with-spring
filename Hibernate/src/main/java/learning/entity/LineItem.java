package learning.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "order_details")
public class LineItem implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Integer order_id;
    @Id
    private Integer product_id;
    private Double unit_price;
    private Double discount;
    private Integer quantity;

    /**
     *
     */
    public LineItem()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param order_id
     * @param product_id
     */
    public LineItem(final Integer order_id, final Integer product_id)
    {
        this.order_id = order_id;
        this.product_id = product_id;
    }

    /*
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "LineItem [order_id="
                + order_id
                + ", product_id="
                + product_id
                + ", unit_price="
                + unit_price
                + ", discount="
                + discount
                + ", quantity="
                + quantity
                + "]";
    }

    //    @ManyToOne
    //    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    //    private Order order;
    //
    //    @ManyToOne
    //    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    //    private Product product;


    /**
     * @return the order_id
     */
    public Integer getOrder_id()
    {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(final Integer order_id)
    {
        this.order_id = order_id;
    }

    /**
     * @return the product_id
     */
    public Integer getProduct_id()
    {
        return product_id;
    }

    /**
     * @param product_id the product_id to set
     */
    public void setProduct_id(final Integer product_id)
    {
        this.product_id = product_id;
    }

    /**
     * @return the unit_price
     */
    public Double getUnit_price()
    {
        return unit_price;
    }

    /**
     * @param unit_price the unit_price to set
     */
    public void setUnit_price(final Double unit_price)
    {
        this.unit_price = unit_price;
    }

    /**
     * @return the discount
     */
    public Double getDiscount()
    {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(final Double discount)
    {
        this.discount = discount;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity()
    {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(final Integer quantity)
    {
        this.quantity = quantity;
    }
}
