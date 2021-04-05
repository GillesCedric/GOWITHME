package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Travel;
import utilities.Utilitie;

public class TravelDao extends Dao {
	
	public TravelDao(){
		super();
	}

	@Override
	public Object isExists(ArrayList<?> list, Object travel) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Travel> dataList=(ArrayList<Travel>) list;
		for(Travel travels:dataList) {
			if(travels.equals(travel))
				return travels;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<Travel> dataList=(ArrayList<Travel>) list;
		String values="";
		for(Travel travel:dataList) {
			values+="('" + travel.getDeparture()+ "','" + travel.getArrival()+ "','" + travel.getDescription()+"','"
					+ travel.getDepartureDate()+ "','" + travel.getDepartureTime()+ "','" + travel.getSeat()+"',"
					+ travel.getCarId()+ "," + travel.getAmount() +"','" +travel.getCreatedAt()+ "','" + travel.getUpdatedAt()+"','" + travel.isActive()+ travel.getUserId()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO travels(departure,arrival,departureDate,departureTime,description,seat,amount,isActive,createdAt,updatedAt,userId,carId) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(TravelDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Travel> liste=new ArrayList();
		try {
			String sql="SELECT * FROM travels";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					liste.add(new Travel(rs.getInt("id"),
							rs.getString("departure"),rs.getString("arrival"),rs.getDate("departureDate"),
							rs.getTime("departureTime"),rs.getString("description"),rs.getInt("seat"),
							rs.getInt("amount"),rs.getBoolean("isActive"),rs.getTimestamp("createdAt"),
							rs.getTimestamp("updatedAt"),rs.getInt("userId"),rs.getInt("carId")));
				}
			}catch(SQLException ex) {
				Utilitie.error(TravelDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(TravelDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		Travel travel=(Travel) object;
		String sql="UPDATE travels SET departure='"+travel.getDeparture()+"',arrival='"+travel.getArrival()+"',departureDate='"+travel.getDepartureDate()+"',departureTime='"+travel.getDepartureTime()+"',description='"+travel.getDescription()+"',seat='"+travel.getSeat()+"',amount='"+travel.getAmount()+"',userId='"+travel.getUserId()+"',carId='"+travel.getCarId()+"',isActive='"+travel.isActive()+"',createdAt='"+travel.getCreatedAt()+"',updateAt='"+travel.getUpdatedAt()+"' WHERE id="+travel.getId();
		 try {
             PreparedStatement prepareStatement = connection.prepareStatement(sql);
             prepareStatement.execute();
         } catch (SQLException ex) {
         	Utilitie.error(TravelDao.class.getName(), ex);
         }
         this.closeConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) {
		Travel travel = (Travel) object;
		this.connectionDatabase();
		String sql = "DELETE FROM travels WHERE id=" + travel.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(TravelDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub
		
	}

}
