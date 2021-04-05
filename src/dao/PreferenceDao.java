package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Mark;
import models.Preference;
import utilities.Utilitie;

public class PreferenceDao extends Dao {
	
	public PreferenceDao() {
		super();
	}

	@Override
	public Object isExists(ArrayList<?> list, Object preference) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Preference> dataList=(ArrayList<Preference>) list;
		for(Preference preferences:dataList) {
			if(preferences.equals(preference))
				return preferences;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Preference> dataList=(ArrayList<Preference>) list;
		String values="";
		for(Preference preference:dataList) {
			values+="('" +preference.getType()+ "','" +
					preference.isValue()+ "','" +preference.getUserId()+"','" + 
					preference.getCreatedAt()+ "','" + preference.getUpdatedAt()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO preferences(type,value,userId,createdAt,updatedAt) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(PreferenceDao.class.getName(), ex);
		}
		this.closeConnection();
		
	}

	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Preference> liste=new ArrayList();
		try {
			String sql="SELECT * FROM preferences";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					//liste.add(new Preference(rs.getInt("id"),rs.getType("type"),rs.getInt("userId"),rs.getBoolean("value"),rs.getTimestamp("createdAt"),rs.getTimestamp("updatedAt")));
				}
			}catch(SQLException ex) {
				Utilitie.error(PreferenceDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(PreferenceDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		Preference preference=(Preference) object;
		String sql="UPDATE preferences SET type='"+preference.getType()+"',value='"+preference.isValue()+"',userId='"+preference.getUserId()+"',createdAt='"+preference.getCreatedAt()+"',updatedAt='"+preference.getUpdatedAt()+"' WHERE id="+preference.getId();
		 try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
        } catch (SQLException ex) {
        	Utilitie.error(PreferenceDao.class.getName(), ex);
        }
        this.closeConnection();
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		Preference preference = (Preference) object;
		this.connectionDatabase();
		String sql = "DELETE FROM preferences WHERE id=" + preference.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(PreferenceDao.class.getName(), ex);
		}
		this.closeConnection();
		
		
	}

}
