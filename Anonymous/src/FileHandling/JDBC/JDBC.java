package FileHandling.JDBC;

import java.sql.*;

public class JDBC {

    private static String url = "jdbc:mysql://localhost:3306/learn109";
    private static String userName = "root";
    private static String password = "Yaswanth2203$";
    private static PreparedStatement pst;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, userName, password);

        // String query = "insert into cou (name, price) values (?, ?)";
        String query = "update cou SET name = ? where id = ?";

        pst = con.prepareStatement(query);

        pst.setString(1, "MYSQL3");
        pst.setInt(2, 8);

        int res = pst.executeUpdate();

        if (res > 0) {
            System.out.println("Success");
        }
        else {
            System.out.println("Fail");
        }

        pst.close();
        con.close();
    }
}

//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        Connection con = DriverManager.getConnection(url, userName, password);
//
//        Statement st = con.createStatement();
//
//        String query = "select name, marks, age from Students";
//
//        ResultSet rs = st.executeQuery(query);
//
//        while (rs.next()) {
//
//            String name = rs.getString("name");
//            Double marks = rs.getDouble("marks");
//            int age = rs.getInt("age");
//
//            System.out.println(name);
//            System.out.println(marks);
//            System.out.println(age);
//        String query = String.format("Insert into Cou(name,price)"+"values('%s',%f)","SQL",80.03);
//        String query = String.format(
//                "UPDATE Cou SET name = '%s' WHERE id = %d",
//                "MYSQL",
//                6
//        );
//        String query = String.format("delete from Cou WHERE id = %d", 4);
//        int res = st.executeUpdate(query);
//        if(res>0){
//            System.out.println("Success");
//        }
//        else {
//            System.out.println("Failed");
//        }
//
//    }
