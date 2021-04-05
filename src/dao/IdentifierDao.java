package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Identifier;
import models.Preference;
import utilities.Utilitie;

public class IdentifierDao extends Dao{

	@Override
	public Object isExists(ArrayList<?> list, Object identifier) {
		// TODO Auto-generated method stub
		ArrayList<Identifier> dataList=(ArrayList<Identifier>) list;
		for(Identifier identifiers:dataList) {
			if(identifiers.equals(identifier))
				return identifiers;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Identifier> dataList=(ArrayList<Identifier>) list;
		String values="";
		for(Identifier identifier:dataList) {
			values+="('" +identifier.getType()+ "','" +
					identifier.isVerified()+ "','" +identifier.getUserId()+"','" + identifier.getVerifiedDate()+"','"+ 
					identifier.getCreatedAt()+ "','" + identifier.getUpdatedAt()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO identifiers(type,isVerified,VerifiedDate,userId,createdAt,updatedAt) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(IdentifierDao.class.getName(), ex);
		}
		this.closeConnection();
		
	}

	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Identifier> liste=new ArrayList();
		try {
			String sql="SELECT * FROM identifiers";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					//liste.add(new Identifier(rs.getInt("id"),rs.getType("type"),rs.getInt("userId"),rs.getBoolean("isVerified"),rs.getTimestamp("VerifiedDate"),rs.getTimestamp("createdAt"),rs.getTimestamp("updatedAt")));
				}
			}catch(SQLException ex) {
				Utilitie.error(IdentifierDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(IdentifierDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		Identifier identifier = (Identifier) object;
		String sql="UPDATE identifiers SET type='"+identifier.getType()+"',isVerified='"+identifier.isVerified()+"',userId='"+identifier.getUserId()+"',VerifiedDate='"+identifier.getVerifiedDate()+"',createdAt='"+identifier.getCreatedAt()+"',updatedAt='"+identifier.getUpdatedAt()+"' WHERE id="+identifier.getId();
		 try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
        } catch (SQLException ex) {
        	Utilitie.error(IdentifierDao.class.getName(), ex);
        }
        this.closeConnection();
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		Identifier identifier = (Identifier) object;
		this.connectionDatabase();
		String sql = "DELETE FROM identifiers WHERE id=" + identifier.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(PreferenceDao.class.getName(), ex);
		}
		this.closeConnection();
		
	}

}
