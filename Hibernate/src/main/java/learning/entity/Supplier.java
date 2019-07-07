package learning.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name="suppliers")
public class Supplier
{
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "supplier_id")
    private Integer supplierId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_title")
    private String contactTitle;

    //represents contact details
    @Embedded
    private ContactDetails contactDetails;

    private String phone;
    private String fax;
    @Column(name = "home_page")
    private String homePage;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    /**
     *
     */
    //    public Supplier()
    //    {
    //        System.out.println("New supplier created");
    //    }

    /**
     * @return the products
     */
    public List<Product> getProducts()
    {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(final List<Product> products)
    {
        this.products = products;
    }

    /**
     * @return the supplierId
     */
    public Integer getSupplierId()
    {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(final Integer supplierId)
    {
        this.supplierId = supplierId;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName()
    {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(final String companyName)
    {
        this.companyName = companyName;
    }

    /**
     * @return the contactName
     */
    public String getContactName()
    {
        return contactName;
    }

    /**
     * @param contactName the contactName to set
     */
    public void setContactName(final String contactName)
    {
        this.contactName = contactName;
    }

    /**
     * @return the contactTitle
     */
    public String getContactTitle()
    {
        return contactTitle;
    }

    /**
     * @param contactTitle the contactTitle to set
     */
    public void setContactTitle(final String contactTitle)
    {
        this.contactTitle = contactTitle;
    }

    /**
     * @return the contactDetails
     */
    public ContactDetails getContactDetails()
    {
        return contactDetails;
    }

    /**
     * @param contactDetails the contactDetails to set
     */
    public void setContactDetails(final ContactDetails contactDetails)
    {
        this.contactDetails = contactDetails;
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

    /**
     * @return the fax
     */
    public String getFax()
    {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(final String fax)
    {
        this.fax = fax;
    }

    /**
     * @return the homePage
     */
    public String getHomePage()
    {
        return homePage;
    }

    /**
     * @param homePage the homePage to set
     */
    public void setHomePage(final String homePage)
    {
        this.homePage = homePage;
    }

}
