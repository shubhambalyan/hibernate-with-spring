package learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 */
@Entity
public class Laptop
{
    @Id
    private String serialNumber;
    private String make;
    private String model;

    @ManyToOne
    @JoinColumn(name = "emp_id", unique = true)
    private Employee owner;

    /**
     * @return the serialNumber
     */
    public String getSerialNumber()
    {
        return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(final String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    /**
     * @return the make
     */
    public String getMake()
    {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(final String make)
    {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel()
    {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(final String model)
    {
        this.model = model;
    }

    /**
     * @return the owner
     */
    public Employee getOwner()
    {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(final Employee owner)
    {
        this.owner = owner;
    }
}
