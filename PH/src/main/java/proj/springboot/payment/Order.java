package proj.springboot.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import static proj.springboot.parking.Database_connection.testing_connection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private double price;
    private String intent="AUTHORIZE";
    private String description="drink";

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static Connection connection = testing_connection();
    static Statement stmt1;

    static {
        try {
            stmt1 = Objects.requireNonNull(connection).createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static int rs;
    static {
        try {
            rs = stmt1.executeUpdate("Use CSCI5308_14_TEST");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int parkingid;
    String pay_method;
    Double transID;
    public void payed(int parkingid) throws SQLException {
        this.parkingid=parkingid;
        ResultSet rs4 = stmt1.executeQuery("select slot_price from slot where id = '" + parkingid + "'");
        while (rs4.next())
        {
            price=rs4.getInt(1);
        }
    }


}
