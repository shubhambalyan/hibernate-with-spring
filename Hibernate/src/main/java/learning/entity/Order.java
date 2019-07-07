package learning.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(generator = "increment")
    private Integer order_id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private Date order_date;
    private Date required_date;
    private Date shipped_date;
    private Double freight;
    private String ship_name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "ship_address")),
            @AttributeOverride(name = "city", column = @Column(name = "ship_city")),
            @AttributeOverride(name = "region", column = @Column(name = "ship_region")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "ship_postal_code")),
            @AttributeOverride(name = "country", column = @Column(name = "ship_country"))
    })
    private ContactDetails shipDetails;
    @ManyToOne
    @JoinColumn(name = "ship_via")
    private Shipper shippedBy;
    //    @OneToMany
    //    @JoinColumn(name = "order_id")
    //    private List<LineItem> items;
    //    /**
    //     * @return the items
    //     */
    //    public List<LineItem> getItems()
    //    {
    //        return items;
    //    }
    //
    //    /**
    //     * @param items the items to set
    //     */
    //    public void setItems(final List<LineItem> items)
    //    {
    //        this.items = items;
    //    }


    /**
     * @return the shippedBy
     */
    public Shipper getShippedBy()
    {
        return shippedBy;
    }

    /**
     * @param shippedBy the shippedBy to set
     */
    public void setShippedBy(final Shipper shippedBy)
    {
        this.shippedBy = shippedBy;
    }

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
     * @return the customer
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(final Customer customer)
    {
        this.customer = customer;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee()
    {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(final Employee employee)
    {
        this.employee = employee;
    }

    /**
     * @return the order_date
     */
    public Date getOrder_date()
    {
        return order_date;
    }

    /**
     * @param order_date the order_date to set
     */
    public void setOrder_date(final Date order_date)
    {
        this.order_date = order_date;
    }

    /**
     * @return the required_date
     */
    public Date getRequired_date()
    {
        return required_date;
    }

    /**
     * @param required_date the required_date to set
     */
    public void setRequired_date(final Date required_date)
    {
        this.required_date = required_date;
    }

    /**
     * @return the shipped_date
     */
    public Date getShipped_date()
    {
        return shipped_date;
    }

    /**
     * @param shipped_date the shipped_date to set
     */
    public void setShipped_date(final Date shipped_date)
    {
        this.shipped_date = shipped_date;
    }

    /**
     * @return the freight
     */
    public Double getFreight()
    {
        return freight;
    }

    /**
     * @param freight the freight to set
     */
    public void setFreight(final Double freight)
    {
        this.freight = freight;
    }

    /**
     * @return the ship_name
     */
    public String getShip_name()
    {
        return ship_name;
    }

    /**
     * @param ship_name the ship_name to set
     */
    public void setShip_name(final String ship_name)
    {
        this.ship_name = ship_name;
    }

    /**
     * @return the shipDetails
     */
    public ContactDetails getShipDetails()
    {
        return shipDetails;
    }

    /**
     * @param shipDetails the shipDetails to set
     */
    public void setShipDetails(final ContactDetails shipDetails)
    {
        this.shipDetails = shipDetails;
    }
}
