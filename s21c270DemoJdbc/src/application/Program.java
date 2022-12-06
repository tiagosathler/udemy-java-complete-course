package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;

		conn = DB.getConnection();

		System.out.println("Reading data...");
		readData(conn, st, rs);
		
		System.out.println();

		System.out.println("Inserting data...");
		insertData(conn, ps, rs);
		System.out.println();

		System.out.println("Updating data...");
		updateData(conn, ps);
		System.out.println();

		System.out.println("Deleting data...");
		deleteData(conn, ps);
		System.out.println();

		System.out.println("Safe updating with transaction...");
		safeTransaction(conn, st);
		System.out.println();

		DB.closeConnection();
	}

	public static void readData(Connection conn, Statement st, ResultSet rs) {
		try {
			st = conn.createStatement();

			rs = st.executeQuery("SELECT * FROM department");

			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}

		} catch (SQLException e) {
			throw new DbException("Error SQLException: " + e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	public static void insertData(Connection conn, PreparedStatement ps, ResultSet rs) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			ps = conn.prepareStatement(""
					+ "INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES"
					+ "(?, ?, ?, ?, ?);",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, "Carl Purple");
			ps.setString(2, "carl@gmail.com");
			ps.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			ps.setDouble(4, 3000.00);
			ps.setInt(5, 4);

			int rowsAffected = ps.executeUpdate();
			System.out.println("Insert done! Rows affected: " + rowsAffected);

			if (rowsAffected > 0) {
				rs = ps.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("New Id = " + id);
				}
				DB.closeResultSet(rs);
			} else {
				System.out.println("No row affected!");
			}
		} catch (ParseException e) {
			throw new DbException("Error parsing date: " + e.getMessage());
		} catch (SQLException e) {
			throw new DbException("Error SQLException: " + e.getMessage());
		} finally {
			DB.closePreparedStatment(ps);
		}
	}

	public static void updateData(Connection conn, PreparedStatement ps) {
		try {
			ps = conn.prepareStatement(""					
					+ "UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE " + "(DepartmentId = ?);",
					Statement.RETURN_GENERATED_KEYS);

			ps.setDouble(1, 200.00);
			ps.setInt(2, 2);

			int rowsAffected = ps.executeUpdate();
			System.out.println("Update Done! Rows affected: " + rowsAffected);

		} catch (SQLException e) {
			throw new DbException("Error SQLException: " + e.getMessage());
		} finally {
			DB.closePreparedStatment(ps);
		}
	}

	public static void deleteData(Connection conn, PreparedStatement ps) {
		try {
			ps = conn.prepareStatement(""
					+ "DELETE FROM seller "
					+ "WHERE " + "Id = ?;");

			ps.setInt(1, 6);

			int rowsAffected = ps.executeUpdate();
			System.out.println("Delete Done! Rows affected: " + rowsAffected);
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closePreparedStatment(ps);
		}
	}

	public static void safeTransaction(Connection conn, Statement st) {
		try {
			conn.setAutoCommit(false);

			st = conn.createStatement();

			int affectedRows1 = st.executeUpdate(""
					+ "UPDATE seller "
					+ "SET BaseSalary = 2090 "
					+ "WHERE DepartmentId = 1;");

			// simulate some fake error:
			// int x = 1;
			// if (x < 2) {
			// throw new SQLException("Fake error");
			// }

			int affectedRows2 = st.executeUpdate(""
					+ "UPDATE seller "
					+ "SET BaseSalary = 3090 "
					+ "WHERE DepartmentId = 2;");

			conn.commit();
			conn.setAutoCommit(true);

			System.out.println("Affected rows on updading 1: " + affectedRows1);
			System.out.println("Affected rows on updating 2: " + affectedRows2);

		} catch (SQLException e1) {
			try {
				conn.rollback();
				throw new DbException("Rollbacking actions caused by: " + e1.getMessage());
			} catch (SQLException e2) {
				throw new DbException("Error trying rollback actions: " + e2.getMessage());
			}
		} finally {
			DB.closeStatement(st);
		}
	}
}
