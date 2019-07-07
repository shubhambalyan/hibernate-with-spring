package learning.service;

import java.sql.Timestamp;
import java.util.Date;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisJava
{

    private static final JedisPoolConfig JEDIS_CONFIG = buildPoolConfig();

    private static final JedisPool pool = new JedisPool(
            JEDIS_CONFIG,
            "localhost",
            6381);

    private static JedisPoolConfig buildPoolConfig()
    {
        final JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);
        return poolConfig;
    }

    public static void main(final String[] args)
            throws Exception
    {
        final RedisJava main = new RedisJava();
        main.getData();
    }

    private void getData()
            throws Exception
    {
        Jedis jedis = null;
        String str1 = null;
        boolean broke = false;
        final Date date = new Date();
        String value = null;
        for (int i = 1; i <= 100; i++)
        {

            try
            {
                jedis = getJedisPoolResource();
                str1 = Integer.toString(i);
                if (jedis.exists(str1))
                {
                    value = jedis.get(str1);
                    System.out.println(new Timestamp(date.getTime()) + " key--> " + str1 + " value--> " + value);
                }
                Thread.sleep(1000);
            }
            catch (final Exception e)
            {
                System.out.println(new Timestamp(date.getTime()) + " key--> " + str1 + " value--> " + value + " Exception " + e);
                broke = true;
            }
            finally
            {
                jedis.close();
            }

        }
    }

    //    private void returnResource(final Jedis jedis, final boolean broke)
    //    {
    //        if (null != jedis && broke)
    //        {
    //            pool.returnBrokenResource(jedis);
    //        }
    //        else
    //        {
    //            pool.returnResource(jedis);
    //        }
    //    }

    private Jedis getJedisPoolResource()
            throws Exception
    {
        Jedis jedis = null;

        jedis = pool.getResource();

        if (null == jedis)
        {
            System.out.println("Could not get a jedis resource from pool");
            throw new Exception();
        }
        jedis.select(5);
        return jedis;
    }
}
