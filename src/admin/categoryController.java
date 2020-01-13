package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class categoryController {
    List<categoryModel> categoryModels = new ArrayList<>();
    Connection connection = singleton.databaseConnection.getInstance().getConnected();
    public List<categoryModel> getCategory() throws SQLException{
        String SQL_SELECT = "Select * from category";
        PreparedStatement preparedStatement=connection.prepareStatement(SQL_SELECT);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            categoryModel categoryModel = new categoryModel();
            categoryModel.setName(name);
            categoryModels.add(categoryModel);
        }
        return categoryModels;
    }

    public int addCategory(String name) throws SQLException {
        String SQL_ADD = "insert into category values(?)";
        PreparedStatement preparedStatement=connection.prepareStatement(SQL_ADD);
        preparedStatement.setString(1,name);
        int resultSet = preparedStatement.executeUpdate();
        return resultSet;
    }

}
