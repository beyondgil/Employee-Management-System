package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
	private static DatabaseConnection instance = new DatabaseConnection();
	private static final String URL="jdbc:mysql://localhost:3306/marlabs";
	private static final String username="MOzil";
	private static final String password="0405114";
	private static final String driver_class="com.mysql.jdbc.Driver";
	public DatabaseConnection(){
		try{
			Class.forName(driver_class);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private Connection createConnection(){
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(URL, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public Connection getConnection(){
		return instance.createConnection();
	}
	public static void main(String args[]){
		new DatabaseConnection();
	}
}
