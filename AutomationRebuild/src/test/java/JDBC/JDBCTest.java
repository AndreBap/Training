package JDBC;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.sql.*;

public class JDBCTest {
	@Test
	public void problem1() throws SQLException {
		final String QUERY = "SELECT city FROM sakila.city ORDER BY city DESC LIMIT 10";
		String[] cities = new String[10];
		int index = 0;
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				cities[index++] = rs.getString("city");
			}
		} catch (SQLException e) {
			System.out.println("problem 1 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}

		assertEquals(cities[0], "Ziguinchor");
		assertEquals(cities[1], "Zhoushan");
		assertEquals(cities[2], "Zhezqazghan");
		assertEquals(cities[3], "Zeleznogorsk");
		assertEquals(cities[4], "Zaria");
		assertEquals(cities[5], "Zapopan");
		assertEquals(cities[6], "Zaoyang");
		assertEquals(cities[7], "Zanzibar");
		assertEquals(cities[8], "Zalantun");
		assertEquals(cities[9], "Yuzhou");
	}
	@Test
	public void problem2() throws SQLException {
		final String QUERY = "SELECT title FROM sakila.film WHERE title LIKE '%airplane%'";
		String[] titles = new String[2];
		int index = 0;
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");

		try (
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY)) {
			while (rs.next()) {
				titles[index++] = rs.getString("title");
			}
		} catch (SQLException e) {
			System.out.println("problem 2 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}

		assertEquals(titles[0], "AIRPLANE SIERRA");
		assertEquals(titles[1], "RAGING AIRPLANE");
	}
	@Test
	public void problem3() throws SQLException {
		final String QUERY = "SELECT MAX(amount) FROM payment";
		double amount = 0;
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				amount = rs.getDouble("MAX(amount)");
			}
		} catch (SQLException e) {
			System.out.println("problem 3 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}

		assertEquals(amount, 11.99);
	}
	@Test
	public void problem4() throws SQLException {
		final String QUERY = "SELECT COUNT(*) FROM customer AS c WHERE c.store_id = 1";
		int customers = 0;
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				customers = rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			System.out.println("problem 4 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}

		assertEquals(customers, 326);
	}
	@Test
	public void problem5() throws SQLException {
		final String QUERY = "SELECT p.* FROM payment AS p JOIN customer AS c ON c.customer_id = p.customer_id WHERE c.email = 'NANCY.THOMAS@sakilacustomer.org'";
		int[] payIDs = new int[28];
		int index = 0;
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				payIDs[index++] = rs.getInt("payment_id");
			}
		} catch (SQLException e) {
			System.out.println("problem 5 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}

		assertEquals(payIDs[0], 303);
		assertEquals(payIDs[27], 330);
	}
	@Test
	public void problem6() throws SQLException {
		final String QUERY = "SELECT * FROM film_list WHERE actors LIKE '%BOB FAWCETT%';";
		int numberOfResults = 0;
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				numberOfResults++;
			}
		} catch (SQLException e) {
			System.out.println("problem 6 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}

		assertEquals(numberOfResults, 25);
	}
	@Test
	public void problem7() throws SQLException {
		final String QUERY = "SELECT f.film_id FROM film AS f WHERE f.title = 'Alien Center'";
		PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    int[] invIDs = new int[4];
	    int index = 0;
	    Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");
	    
		try {
			Statement stmt = connection.createStatement();
			ResultSet filmID = stmt.executeQuery(QUERY);
			pstmt = connection.prepareCall("{call film_in_stock(?, 2, ?)}");
			filmID.next();
			pstmt.setInt(1, filmID.getInt(1));
			pstmt.setInt(2, 0);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				invIDs[index++] = rs.getInt("inventory_id");
			}
		} catch (SQLException e) {
			System.out.println("problem 7 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}

		assertEquals(invIDs[0], 73);
		assertEquals(invIDs[1], 74);
		assertEquals(invIDs[2], 75);
		assertEquals(invIDs[3], 76);
}
	@Test
	public void problem8() throws SQLException {
		int ids = 0;
		ResultSet rs = null;
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");

		try {
				connection.setAutoCommit(false);
				PreparedStatement stmt = connection.prepareStatement("INSERT INTO staff (first_name, last_name, address_id, email, store_id, `active`, username) \n"
						+ "VALUES (\"John\", \"Doe\", \"18\", \"rando@gmail.com\", \"2\", \"1\", \"newJohn\")",Statement.RETURN_GENERATED_KEYS);
				int rowsAffected = stmt.executeUpdate();
	            if(rowsAffected == 1)
	            {
	                rs = stmt.getGeneratedKeys();
	                if(rs.next())
	                    ids = rs.getInt(1);
	            } 
	            int staffId = ids;
	            stmt = connection.prepareStatement("INSERT INTO address (address, district, city_id, phone, location) \n"
						+ "VALUES ('110 Main', 'Dime Box', 300, 7137778888, ST_GeomFromText('POINT(1 1)'));",Statement.RETURN_GENERATED_KEYS);
	            rowsAffected = stmt.executeUpdate();
	            if(rowsAffected == 1)
	            {
	                rs = stmt.getGeneratedKeys();
	                if(rs.next())
	                    ids = rs.getInt(1);
	            }
				int addressId = ids;
				stmt = connection.prepareStatement("INSERT INTO store (manager_staff_id, address_id) \n"
						+ "VALUES (" + staffId + ", " + addressId + ");",Statement.RETURN_GENERATED_KEYS);
				rowsAffected = stmt.executeUpdate();
	            if(rowsAffected == 1)
	            {
	                rs = stmt.getGeneratedKeys();
	                if(rs.next())
	                    ids = rs.getInt(1);
	            }
				int storeId = ids;
				stmt.executeUpdate("UPDATE staff \n"
						+ "SET store_id = " + storeId + "\n"
						+ "WHERE staff_id = " + staffId + ";");
				{
				connection.rollback();
				}
		} catch (SQLException e) {
			System.out.println("problem 8 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}
	}
	@Test
	public void problem9() throws SQLException {
		PreparedStatement stmt;
		int rowsAffected = 0;
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");

		try {
				connection.setAutoCommit(false);
				stmt = connection.prepareStatement("UPDATE store AS s\n"
						+ "INNER JOIN address AS a ON a.address_id = s.address_id\n"
						+ "SET s.last_update = CURDATE()\n"
						+ "WHERE a.address = '110 Main';");
				rowsAffected = stmt.executeUpdate();
				connection.rollback();
		} catch (SQLException e) {
			System.out.println("problem 9 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}
		
		assertEquals(rowsAffected, 1);
	}
	@Test
	public void problem10() throws SQLException {
		PreparedStatement stmt;
		int rowsAffected = 0;
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "password");

		try {
				connection.setAutoCommit(false);
				stmt = connection.prepareStatement("SET SQL_SAFE_UPDATES = 0;");
				stmt.executeUpdate();
				stmt = connection.prepareStatement("DELETE s.*\n"
						+ "FROM store AS s\n"
						+ "INNER JOIN address AS a ON a.address_id = s.address_id\n"
						+ "WHERE a.address = '110 Main';");
				rowsAffected = stmt.executeUpdate();
				stmt = connection.prepareStatement("SET SQL_SAFE_UPDATES = 1;");
				stmt.executeUpdate();
				connection.rollback();
		} catch (SQLException e) {
			System.out.println("problem 10 error");
			e.printStackTrace();
		}
		finally {
			if(connection != null) {
				connection.close();
			}
		}
		
		assertEquals(rowsAffected, 1);
	}
}
