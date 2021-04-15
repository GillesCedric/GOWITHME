package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.User;
import utilities.Utilitie;

public class UserDao extends Dao {

	public UserDao() {
		super();
	}

	@Override
	public Object isExists(ArrayList<?> list, Object user) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<User> dataList = (ArrayList<User>) list;
		for (User users : dataList) {
			if (users.equals(user))
				return users;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		@SuppressWarnings("unchecked")
		ArrayList<User> dataList = (ArrayList<User>) list;
		String values = "";
		for (User user : dataList) {
			values += "(\"" + user.getName() + "\",\"" + user.getLastName() + "\",\"" + user.getPassword() + "\"),";
		}
		values = values.substring(0, values.length() - 1);
		values += ";";
		String sql = "INSERT INTO users(name,LastName,password) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(UserDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub

	}

	@Override
	public int insert(Object object) {
		this.connectionDatabase();
		int id = 0;
		User user = (User) object;
		String sql = "INSERT INTO users(name,LastName,password) VALUES " + "(\"" + user.getName() + "\",\"" + user.getLastName() + "\",\"" + user.getPassword() + "\")";
		try {
			PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
		} catch (SQLException ex) {
			Utilitie.error(UserDao.class.getName(), ex);
		}
		this.closeConnection();
		return id;
	}

	@Override
	public ArrayList<?> list() {
		this.connectionDatabase();
		ArrayList<User> liste = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			try {
				while (rs.next()) {
					liste.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("LastName"),
							rs.getString("password"), rs.getString("picture"), rs.getBoolean("isAdmin"),
							rs.getBoolean("isActive"), rs.getTimestamp("createdAt"), rs.getTimestamp("updatedAt")));
				}
			} catch (SQLException ex) {
				Utilitie.error(UserDao.class.getName(), ex);
			}
		} catch (SQLException ex) {
			Utilitie.error(UserDao.class.getName(), ex);

		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		User user = (User) object;
		String sql = "UPDATE users SET name=\"" + user.getLastName() + "\",LastName=\"" + user.getLastName()
				+ "\",password=\"" + user.getPassword() + "\",picture=\"" + user.getPicture() + "\",isAdmin=\""
				+ user.isAdmin() + "\",isActive=\"" + user.isActive() + "\",createdAt=\"" + user.getCreatedAt()
				+ "\",updateAt=\"" + user.getUpdatedAt() + "\" WHERE id=" + user.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(UserDao.class.getName(), ex);
		}
		this.closeConnection();

	}

	@Override
	public void delete(Object object) {
		User user = (User) object;
		this.connectionDatabase();
		String sql = "DELETE FROM users WHERE id=" + user.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(UserDao.class.getName(), ex);
		}
		this.closeConnection();

	}

	public int getLastID() {
		// TODO Auto-generated method stub
		return super.getLastID("users");
	}

}
