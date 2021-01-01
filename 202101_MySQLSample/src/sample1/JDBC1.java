package sample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC1 {

    public static void main(String[] args) {

        final String URL = "jdbc:mysql://localhost:3306/kiwidb?serverTimezone=JST";
        final String USER = "kiwi";
        final String PASS = "asdf";
        final String SQL = "select * from user where id = ? and name = ?;";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, 2);
            ps.setString(2, "Suzuki");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("address"));
                }
            };
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("処理が完了しました");
        }
    }
}