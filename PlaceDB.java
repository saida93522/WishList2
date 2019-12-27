import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaceDB {
    private static final String DB = "jdbc:sqlite:wishlist:sqlite";
    private static final String PLACE_ = "place";
    private static final String REASON_ = "reason";


    PlaceDB() {
        try (Connection connection = DriverManager.getConnection(DB);
             Statement statement = connection.createStatement()) {

            String TableSql = "CREATE TABLE IF NOT EXISTS wishList" +
                    "(Place TEXT PRIMARY KEY, Reason TEXT PRIMARY KEY)";
            statement.executeUpdate(TableSql);

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }

    }


    public List<Place> getAllList() {
        List<Place> allData = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB);
             Statement statement = conn.createStatement()) {
            String selectTable = "SELECT * FROM wishList";
            ResultSet resultSet = statement.executeQuery(selectTable);

            while (resultSet.next()) {
                String name = resultSet.getString(PLACE_);
                String reason = resultSet.getString(REASON_);

                Place placedata = new Place(name, reason);
            }
            return allData;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }


    public void Delete(Place location){
        String deleteTable = "DELETE FROM wishList Where name = ?";
        try(Connection connection = DriverManager.getConnection(DB);
        PreparedStatement preparedStatement = connection.prepareStatement(deleteTable)) {

            preparedStatement.setString(1,location.getName());
            preparedStatement.execute();

        }catch (SQLException sqle){
            throw new RuntimeException(sqle);
        }
    }
}
