package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	@SuppressWarnings("unchecked")
	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<Travel> dataList=(ArrayList<Travel>) list;
		String values="";
		for(Travel travel:dataList) {
			values+="(\"" + travel.getDeparture()+ "\",\"" + travel.getArrival()+ "\",\"" + travel.getDepartureDate()+"\",\""
					+ travel.getDepartureTime()+ "\",\"" + travel.getDepartureTime()+ "\",\"" + travel.getDescription()+"\","
					+ travel.getSeat()+ "," + travel.getAmount() +"\",\"" + travel.getUserId()+ travel.getCarId()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO travels(departure,arrival,departureDate,departureTime,description,seat,amount,userId,carId) VALUES " + values;
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
	public int insert(Object object) {
		this.connectionDatabase();
		int id = 0;
		Travel travel = (Travel) object;
		String sql="INSERT INTO travels(departure,arrival,departureDate,departureTime,description,seat,amount,userId,carId) VALUES " + "(\"" + travel.getDeparture()+ "\",\"" + travel.getArrival()+ "\",\"" + travel.getDepartureDate()+"\",\""
				+ travel.getDepartureTime()+ "\",\"" + travel.getDescription()+"\","
				+ travel.getSeat()+ "," + travel.getAmount() +"," + travel.getUserId()+","+travel.getCarId()+")";
		try {
			PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) id = rs.getInt(1);
		}catch (SQLException ex) {
			Utilitie.error(TravelDao.class.getName(), ex);
		}
		this.closeConnection();
		return id;
	}

	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Travel> liste=new ArrayList<Travel>();
		try {
			String sql="SELECT * FROM travels";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					liste.add(new Travel(rs.getInt("id"),
							rs.getString("departure"),rs.getString("arrival"),rs.getDate("departureDate"),
							rs.getString("departureTime"),rs.getString("description"),rs.getInt("seat"),
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
		String sql="UPDATE travels SET departure=\""+travel.getDeparture()+"\",arrival=\""+travel.getArrival()+"\",departureDate=\""+travel.getDepartureDate()+"\",departureTime=\""+travel.getDepartureTime()+"\",description=\""+travel.getDescription()+"\",seat=\""+travel.getSeat()+"\",amount=\""+travel.getAmount()+"\",userId=\""+travel.getUserId()+"\",carId=\""+travel.getCarId()+"\",isActive=\""+travel.isActive()+"\",createdAt=\""+travel.getCreatedAt()+"\",updateAt=\""+travel.getUpdatedAt()+"\" WHERE id="+travel.getId();
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
