package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Request;
import models.Stripe;
import utilities.Utilitie;

public class RequestDao extends Dao {

	@Override
	public Object isExists(ArrayList<?> list, Object request) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Request> dataList=(ArrayList<Request>) list;
		for(Request requests:dataList) {
			if(requests.equals(request))
				return requests;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<Request> dataList=(ArrayList<Request>) list;
		String values="";
		for(Request request:dataList) {
			values+="('" +request.getObject()+ "','" + request.getMessage()+ "','" + request.getUserId()+"','"
					+ request.getLogFile()+ "','" + request.getCreatedAt()+ "','" + request.getUpdatedAt()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO requests(object,message,logFile,createdAt,updatedAt,userId) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(RequestDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<?> list() {
		this.connectionDatabase();
		ArrayList<Request> liste=new ArrayList();
		try {
			String sql="SELECT * FROM requests";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					//liste.add(new Request(rs.getInt("id"),rs.getString("object"),rs.getString("message"),rs.get,rs.getInt("userId"),rs.getTimestamp("createdAt"),rs.getTimestamp("updatedAt")));
				}
			}catch(SQLException ex) {
				Utilitie.error(RequestDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(RequestDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		Request request=(Request) object;
		String sql="UPDATE requests SET object='"+request.getObject()+"',message='"+request.getMessage()+"',logFile='"+request.getLogFile()+"',userId='"+request.getUserId()+"',createdAt='"+request.getCreatedAt()+"',updateAt='"+request.getUpdatedAt()+"' WHERE id="+request.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(RequestDao.class.getName(), ex);
		}
		this.closeConnection();
	}
	
	// TODO Auto-generated method stub
	

	@Override
	public void delete(Object object) {
		Request request=(Request) object;
		this.connectionDatabase();
		String sql="DELETE FROM requests WHERE id="+request.getId();
		try {
			PreparedStatement preparestatement=connection.prepareStatement(sql);
			preparestatement.executeQuery();
		}catch(SQLException ex) {
			Utilitie.error(RequestDao.class.getName(), ex);
			
		}
		this.closeConnection();
		// TODO Auto-generated method stub
		
	}

}
