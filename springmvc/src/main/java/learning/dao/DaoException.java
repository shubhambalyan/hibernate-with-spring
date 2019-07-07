package learning.dao;

public class DaoException extends Exception
{

    private static final long serialVersionUID = 1L;

    public DaoException()
    {
    }

    public DaoException(final String message)
    {
        super(message);
    }

    public DaoException(final Throwable cause)
    {
        super(cause); //Exception Funneling
    }

}
