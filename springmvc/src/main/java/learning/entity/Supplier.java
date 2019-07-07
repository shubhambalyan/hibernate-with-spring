package learning.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @XmlTransient
    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(final List<Product> products)
    {
        this.products = products;
    }

    public Integer getSupplierId()
    {
        return supplierId;
    }

    public void setSupplierId(final Integer supplierId)
    {
        this.supplierId = supplierId;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(final String companyName)
    {
        this.companyName = companyName;
    }

    public String getContactName()
    {
        return contactName;
    }

    public void setContactName(final String contactName)
    {
        this.contactName = contactName;
    }

    public String getContactTitle()
    {
        return contactTitle;
    }

    public void setContactTitle(final String contactTitle)
    {
        this.contactTitle = contactTitle;
    }

    public ContactDetails getContactDetails()
    {
        return contactDetails;
    }

    public void setContactDetails(final ContactDetails contactDetails)
    {
        this.contactDetails = contactDetails;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(final String phone)
    {
        this.phone = phone;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(final String fax)
    {
        this.fax = fax;
    }

    public String getHomePage()
    {
        return homePage;
    }

    public void setHomePage(final String homePage)
    {
        this.homePage = homePage;
    }

}
