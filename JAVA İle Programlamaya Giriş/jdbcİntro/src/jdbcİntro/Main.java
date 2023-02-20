package jdbcİntro;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws SQLException{
		 Connection connection = null;
			
			DbHelper helper = new DbHelper();
			PreparedStatement statement = null;
			ResultSet resultSet;
			try {
				
				connection = helper.getConnection();
				String sql = "delete from category where category_id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, 18);
				statement.executeUpdate(); 
				System.out.println("Kayit silindi");
				
			}catch (SQLException exception) {
				helper.showErrorMessage(exception);
			}
			finally {
				statement.close();
				connection.close();
				
			}
	}
	public static void selectDemo() throws SQLException{
        Connection connection = null;
		
		DbHelper helper = new DbHelper();
		Statement statement = null;
		ResultSet resultSet;
		try {
			
			connection = helper.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select actor_id,first_name,last_name,last_update from actor");
			ArrayList<Actor> actor = new ArrayList<Actor>();
			
			while (resultSet.next()) {
				actor.add(new Actor(resultSet.getString("actor_id"),resultSet.getString("first_name"),resultSet.getString("last_name"),resultSet.getString("last_update")));
			}
			
			System.out.println(actor.size());
			
		}catch (SQLException exception) {
			helper.showErrorMessage(exception);
		}
		finally {
			connection.close();
			
		}
	}
	public static void insertData() throws SQLException {
		 Connection connection = null;
			
			DbHelper helper = new DbHelper();
			PreparedStatement statement = null;
			ResultSet resultSet;
			try {
				
				connection = helper.getConnection();
				String sql = "insert into category (category_id,name,last_update) values(?,?,?)";
				statement = connection.prepareStatement(sql);
				statement.setString(1, "18");
				statement.setString(2, "Rap");
				statement.setString(3, "2022-12-18 14:53:41");
				
				
				statement.executeUpdate(); 
				System.out.println("Kayit eklendi");
				
			}catch (SQLException exception) {
				helper.showErrorMessage(exception);
			}
			finally {
				statement.close();
				connection.close();
				
			}
	}
	public void updateData() throws SQLException{
		 Connection connection = null;
			
			DbHelper helper = new DbHelper();
			PreparedStatement statement = null;
			ResultSet resultSet;
			try {
				
				connection = helper.getConnection();
				String sql = "update category set name='Pop' where category_id = ?";
				statement = connection.prepareStatement(sql);
				statement.setInt(1, 18);
				statement.executeUpdate(); 
				System.out.println("Kayit guncellendi");
				
			}catch (SQLException exception) {
				helper.showErrorMessage(exception);
			}
			finally {
				statement.close();
				connection.close();
				
			}
	}
}
