package learning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "shippers")
public class Shipper
{
    @Id
    @GeneratedValue(generator = "increment")
    private Integer shipper_id;
    private String company_name;
    private String phone;

    /**
     * @return the shipper_id
     */
    public Integer getShipper_id()
    {
        return shipper_id;
    }

    /**
     * @param shipper_id the shipper_id to set
     */
    public void setShipper_id(final Integer shipper_id)
    {
        this.shipper_id = shipper_id;
    }

    /**
     * @return the company_name
     */
    public String getCompany_name()
    {
        return company_name;
    }

    /**
     * @param company_name the company_name to set
     */
    public void setCompany_name(final String company_name)
    {
        this.company_name = company_name;
    }

    /**
     * @return the phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(final String phone)
    {
        this.phone = phone;
    }

}
