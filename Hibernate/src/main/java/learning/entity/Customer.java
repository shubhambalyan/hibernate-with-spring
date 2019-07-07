package learning.entity;

import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "customers")
public class Customer
{
    @Id
    private String customer_id;
    private String company_name;
    private String contact_name;
    private String contact_title;
    @Embedded
    private ContactDetails contactDetails;
    private String phone;
    private String fax;

    //list of all employees who have processed this customer order
    @ManyToMany
    @JoinTable(name = "orders",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees;

    /**
     * @return the employees
     */
    public Set<Employee> getEmployees()
    {
        return employees;
    }

    /**
     * @param employees the employees to set
     */
    public void setEmployees(final Set<Employee> employees)
    {
        this.employees = employees;
    }

    /**
     * @return the customer_id
     */
    public String getCustomer_id()
    {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(final String customer_id)
    {
        this.customer_id = customer_id;
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
     * @return the contact_name
     */
    public String getContact_name()
    {
        return contact_name;
    }

    /**
     * @param contact_name the contact_name to set
     */
    public void setContact_name(final String contact_name)
    {
        this.contact_name = contact_name;
    }

    /**
     * @return the contact_title
     */
    public String getContact_title()
    {
        return contact_title;
    }

    /**
     * @param contact_title the contact_title to set
     */
    public void setContact_title(final String contact_title)
    {
        this.contact_title = contact_title;
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
}
