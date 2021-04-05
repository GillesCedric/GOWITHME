package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Favorite;
import models.Request;
import utilities.Utilitie;

public class FavoriteDao extends Dao {

	@Override
	public Object isExists(ArrayList<?> list, Object favorite) {
		// TODO Auto-generated method stub
		ArrayList<Favorite> dataList=(ArrayList<Favorite>) list;
		for(Favorite favorites:dataList) {
			if(favorites.equals(favorite))
				return favorites;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<Favorite> dataList=(ArrayList<Favorite>) list;
		String values="";
		for(Favorite favorite:dataList) {
			values+="('" +favorite.getUserIdFavoritee()+ "','" + favorite.getUserIdFavoritee()+ "','" + favorite.getCreatedAt()+ "','" + favorite.getUpdatedAt()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO favorites(userIdFavoriter,userIdFavoritee,createdAt,updatedAt) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(FavoriteDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public ArrayList<?> list() {
		this.connectionDatabase();
		ArrayList<Favorite> liste=new ArrayList();
		try {
			String sql="SELECT * FROM favorites";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					liste.add(new Favorite(rs.getInt("userIdFavoriter"),rs.getInt("userIdFavoritee"),rs.getTimestamp("createdAt"),rs.getTimestamp("updatedAt")));
				}
			}catch(SQLException ex) {
				Utilitie.error(FavoriteDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(FavoriteDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		Favorite favorite=(Favorite) object;
		String sql="UPDATE favorites SET createdAt='"+favorite.getCreatedAt()+"',updatedAt='"+favorite.getUpdatedAt()+"' WHERE id="+favorite.getUserIdFavoriter()+favorite.getUserIdFavoritee();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(FavoriteDao.class.getName(), ex);
		}
		this.closeConnection();
		
	}

	@Override
	public void delete(Object object) {
		Favorite favorite=(Favorite) object;
		this.connectionDatabase();
		String sql="DELETE FROM favorites WHERE id="+favorite.getUserIdFavoriter()+favorite.getUserIdFavoritee();
		try {
			PreparedStatement preparestatement=connection.prepareStatement(sql);
			preparestatement.executeQuery();
		}catch(SQLException ex) {
			Utilitie.error(FavoriteDao.class.getName(), ex);
			
		}
		this.closeConnection();
		
	}

}
