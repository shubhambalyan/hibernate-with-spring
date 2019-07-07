package learning.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name = "employees")
public class Employee
{
    @Id
    @GeneratedValue(generator = "increment")
    private Integer employee_id;
    private String first_name;
    private String last_name;
    private String title;
    private String title_of_courtesy;
    private Date birth_date;
    private Date hire_date;
    private String home_phone;

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
     * @return the laptop
     */
    public Laptop getLaptop()
    {
        return laptop;
    }

    /**
     * @param laptop the laptop to set
     */
    public void setLaptop(final Laptop laptop)
    {
        this.laptop = laptop;
    }

    private String extension;
    @Embedded
    private ContactDetails contactDetails;
    private byte[] photo;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "reports_to")
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates;

    @OneToOne(mappedBy = "owner") // owner is the member in laptop with foreign key info
    private Laptop laptop;

    /**
     * @return the employee_id
     */
    public Integer getEmployee_id()
    {
        return employee_id;
    }

    /**
     * @param employee_id the employee_id to set
     */
    public void setEmployee_id(final Integer employee_id)
    {
        this.employee_id = employee_id;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name()
    {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(final String first_name)
    {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name()
    {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(final String last_name)
    {
        this.last_name = last_name;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(final String title)
    {
        this.title = title;
    }

    /**
     * @return the title_of_courtesy
     */
    public String getTitle_of_courtesy()
    {
        return title_of_courtesy;
    }

    /**
     * @param title_of_courtesy the title_of_courtesy to set
     */
    public void setTitle_of_courtesy(final String title_of_courtesy)
    {
        this.title_of_courtesy = title_of_courtesy;
    }

    /**
     * @return the birth_date
     */
    public Date getBirth_date()
    {
        return birth_date;
    }

    /**
     * @param birth_date the birth_date to set
     */
    public void setBirth_date(final Date birth_date)
    {
        this.birth_date = birth_date;
    }

    /**
     * @return the hire_date
     */
    public Date getHire_date()
    {
        return hire_date;
    }

    /**
     * @param hire_date the hire_date to set
     */
    public void setHire_date(final Date hire_date)
    {
        this.hire_date = hire_date;
    }

    /**
     * @return the home_phone
     */
    public String getHome_phone()
    {
        return home_phone;
    }

    /**
     * @param home_phone the home_phone to set
     */
    public void setHome_phone(final String home_phone)
    {
        this.home_phone = home_phone;
    }

    /**
     * @return the extension
     */
    public String getExtension()
    {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(final String extension)
    {
        this.extension = extension;
    }

    /**
     * @return the photo
     */
    public byte[] getPhoto()
    {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(final byte[] photo)
    {
        this.photo = photo;
    }

    /**
     * @return the notes
     */
    public String getNotes()
    {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(final String notes)
    {
        this.notes = notes;
    }

    /**
     * @return the manager
     */
    public Employee getManager()
    {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(final Employee manager)
    {
        this.manager = manager;
    }

    /**
     * @return the subordinates
     */
    public List<Employee> getSubordinates()
    {
        return subordinates;
    }

    /**
     * @param subordinates the subordinates to set
     */
    public void setSubordinates(final List<Employee> subordinates)
    {
        this.subordinates = subordinates;
    }
}
