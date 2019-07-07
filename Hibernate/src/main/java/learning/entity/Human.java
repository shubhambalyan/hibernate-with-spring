package learning.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
// Approach #1
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "HUMAN_TYPE", discriminatorType =
// DiscriminatorType.STRING)

// Approach #2
// @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

// Approach #3 (normalized)
@Inheritance(strategy = InheritanceType.JOINED)
public class Human
{
    @Id
    private Integer id;
    private String name;
    private String email;

    public Human()
    {
    }

    public Human(final Integer id, final String name, final String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * @return the id
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name)
    {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(final String email)
    {
        this.email = email;
    }

}