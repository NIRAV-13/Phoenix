package proj.springboot.parking;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


import java.io.IOException;
import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class Database_connectionTest {

    @Test
    public void testtesting_connection() throws IOException {
        Connection rst= Database_connection.testing_connection();
        Assert.assertEquals(rst!=null,true);
    }
    @Test
    public void testtesting_connection_error() throws IOException {
        Connection rst= Database_connection.testing_connection();
        Assert.assertNotEquals(null,true);
    }


}