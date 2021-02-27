/**
 * 
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.User;
import system.Log;

/**
 * @author Gilles Cédric
 *
 */
public class UserDao extends Dao {

	/**
	 * 
	 */
	public UserDao() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public User isExists(ArrayList<?> list, Object user) {
		ArrayList<User> dataList = (ArrayList<User>) list;
		for (User users : dataList) {
			if (users.equals(user))
				return users;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<User> dataList = (ArrayList<User>) list;

		String values = "";
		for (User user : dataList) {
			values += "(NULL,'" + user.getNumCni() + "','" + user.getName() + "','" + user.getLastName()
					+ user.getPhone() + "','" + user.getMail() + "','" + user.getPassword() + user.getPicture() + "','"
					+ user.isAdmin() + "','" + user.isActive() + "'),";
		}
		values = values.substring(0, values.length() - 1);
		values += ";";
		String sql = "INSERT INTO users VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Log.addLog(
					new Log(UserDao.class.getName(), "Erreur lors de l'insertion d'un utilisateur " + ex.getMessage()));
		}
		this.closeConnection();

	}

	@Override
	public ArrayList<?> list() {
		ArrayList<User> liste = new ArrayList<User>();
		try {
			String sql = "SELECT * FROM users";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			try {
				while (rs.next()) {
					liste.add(new User(rs.getInt("id"), rs.getString("numCni"), rs.getString("name"),rs.getString("lastName"),rs.getString("phone"),rs.getString("mail"),rs.getString("password"),rs.getString("picture"),rs.getBoolean("isAdmin"),rs.getBoolean("isActive")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Log.addLog(
						new Log(UserDao.class.getName(), "Erreur lors du listing des utlisateurs " + e.getMessage()));
			}

		} catch (SQLException e) {
			Log.addLog(new Log(UserDao.class.getName(), "Erreur lors du listing des utlisateurs " + e.getMessage()));
		}
		return liste;
	}

	@Override
	public void update(Object object) {
		User user = (User) object;
        String sql = "UPDATE users SET numCni='"+user.getNumCni()+"',name='"+user.getName()+"',lastName='"+user.getLastName()+"',phone='"+user.getPhone()+"',mail='"+user.getMail()+"',password='"+user.getPassword()+"',picture='"+user.getPicture()+"',isAdmin='"+user.isAdmin()+"',isActive='"+user.isActive()+"' WHERE id="+user.getId();
            try {
                PreparedStatement prepareStatement = connection.prepareStatement(sql);
                prepareStatement.execute();
            } catch (SQLException ex) {
                 Log.addLog(new Log(UserDao.class.getName(),"Erreur lors de la modification de l'utilisateur"+user.getName()+" "+ex.getMessage()));
            }

	}

	@Override
	public void delete(Object object) {
		User user = (User) object;

		String sql = "DELETE FROM users WHERE id=" + user.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Log.addLog(new Log(UserDao.class.getName(),
					"Erreur lors de la suppression de l'utilisateur " + user.getName() + " " + ex.getMessage()));
		}

	}

	
	public int getLastID() {
		// TODO Auto-generated method stub
		return super.getLastID("users");
	}
	
	

}
