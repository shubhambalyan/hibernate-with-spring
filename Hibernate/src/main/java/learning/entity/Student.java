package learning.entity;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("STUD")
public class Student extends Human
{
    private String subject;
    private Double gpa;

    public Student()
    {
    }

    public Student(final Integer id, final String name, final String email, final String subject, final Double gpa)
    {
        super(id, name, email);
        this.subject = subject;
        this.gpa = gpa;
    }

    /**
     * @return the subject
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(final String subject)
    {
        this.subject = subject;
    }

    /**
     * @return the gpa
     */
    public Double getGpa()
    {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(final Double gpa)
    {
        this.gpa = gpa;
    }

}