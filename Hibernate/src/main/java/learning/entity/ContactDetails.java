package learning.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 */
@Embeddable
public class ContactDetails
{
    private String address;
    private String city;
    private String region;
    @Column(name = "postal_code")
    private String postalCode;
    private String country;

    /**
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(final String address)
    {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(final String city)
    {
        this.city = city;
    }

    /**
     * @return the region
     */
    public String getRegion()
    {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(final String region)
    {
        this.region = region;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode()
    {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(final String postalCode)
    {
        this.postalCode = postalCode;
    }

    /**
     * @return the country
     */
    public String getCountry()
    {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(final String country)
    {
        this.country = country;
    }
}
