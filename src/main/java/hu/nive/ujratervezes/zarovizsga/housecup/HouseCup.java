package hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {
    DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getPointsOfHouse(String houdse) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT points_earned FROM house_points WHERE house_name = ?")) {
            stmt.setString(1, houdse);
            return getHousePointsFromPreparedStatment(stmt);
        } catch (
                SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }
    }

    private int getHousePointsFromPreparedStatment(PreparedStatement stmt){
        int points = 0;
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                points += rs.getInt("points_earned");
            }
            return points;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }
    }
}
