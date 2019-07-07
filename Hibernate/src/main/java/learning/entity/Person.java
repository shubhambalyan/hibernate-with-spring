package learning.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private Double height;
    @Column(name = "dob")
    private Date birthDate;

    @Override
    public String toString()
    {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", height=" + height + ", birthDate=" + birthDate + "]";
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(final Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(final Integer age)
    {
        this.age = age;
    }

    public Double getHeight()
    {
        return height;
    }

    public void setHeight(final Double height)
    {
        this.height = height;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(final Date birthDate)
    {
        this.birthDate = birthDate;
    }
}