package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionUtil;
import entity.User;

public class UserDAO {

	public static UserDAO userDAO = null;

	private UserDAO() {

	}

	public static UserDAO getInstance() {
		synchronized (UserDAO.class) {
			if (userDAO == null) {
				userDAO = new UserDAO();
			}
		}
		return userDAO;
	}

	public User create(User user) throws SQLException, IllegalAccessException, IOException, ClassNotFoundException {

		Connection connection = ConnectionUtil.getInstance().getConnection();

		PreparedStatement query = connection.prepareStatement("INSERT INTO USER_1 VALUES (?,?)");
		query.setString(1, user.getName());
		query.setString(2, user.getAge());

		try {
			query.execute();
			return user;
		} catch (Exception e) {
			query.close();
			connection.close();
			throw new SQLException(e);
		}
	}

	public boolean delete(User user) {
		return false;
	}

	public boolean update(User user, int userId) {
		return false;
	}

	public List<User> findAll() throws ClassNotFoundException, IllegalAccessException, SQLException, IOException {

		List<User> list = new ArrayList<User>();

		Connection connection = ConnectionUtil.getInstance().getConnection();

		try (PreparedStatement query = connection.prepareStatement("SELECT * FROM USER")) {

			ResultSet resultSet = query.executeQuery();

			while (resultSet.next()) {
				list.add(new User.Builder()
						.setName(resultSet.getString("name"))
						.setAge(resultSet.getString("age"))
						.build());
			}
		}

		return list;
	}
}
