package learning.entity;

import javax.persistence.Entity;

@Entity
// @DiscriminatorValue("PROF")
public class Professor extends Human
{
    /**
     * @return the salary
     */
    public Double getSalary()
    {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(final Double salary)
    {
        this.salary = salary;
    }

    private Double salary;

    public Professor()
    {
    }

    public Professor(final Integer id, final String name, final String email, final Double salary)
    {
        super(id, name, email);
        this.salary = salary;
    }

}