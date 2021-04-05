package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Car;
import models.Preference;
import utilities.Utilitie;

public class CarDao extends Dao {

	@Override
	public Object isExists(ArrayList<?> list, Object car) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Car> dataList=(ArrayList<Car>) list;
		for(Car cars:dataList) {
			if(cars.equals(car))
				return cars;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Car> dataList=(ArrayList<Car>) list;
		String values="";
		for(Car car:dataList) {
			values+="('" +car.getBrand()+ "','" +car.getRegistration()+ "','" +car.getDescription()+ "','" +car.getUserId()+ "','" +
						car.getModel()+ "','" +car.getColor()+"','" + car.getPicture()+ "','" +car.isActive()+ "','" +
						car.getCreatedAt()+ "','" + car.getUpdatedAt()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO cars(brand,model,color,registration,description,picture,isActive,createdAt,updatedAt,userId) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(CarDao.class.getName(), ex);
		}
		this.closeConnection();
		
	}

	@Override
	public ArrayList<?> list() {
		this.connectionDatabase();
		ArrayList<Car> liste=new ArrayList();
		try {
			String sql="SELECT * FROM cars";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					liste.add(new Car(rs.getInt("id"),
							rs.getString("brand"),rs.getString("model"),rs.getString("color"),rs.getString("registration"),rs.getString("description"),
							rs.getString("picture"),rs.getBoolean("isActive"),rs.getTimestamp("createdAt"),rs.getTimestamp("updatedAt"),rs.getInt("userId")));
				}
			}catch(SQLException ex) {
				Utilitie.error(CarDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(CarDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		Car car=(Car) object;
		String sql="UPDATE cars SET brand='"+car.getBrand()+"',model='"+car.getModel()+"',color='"+car.getColor()+"',registration='"+car.getRegistration()+"',description='"+car.getDescription()+"',picture='"+car.getPicture()+"',isActive='"+car.isActive()+"',userId='"+car.getUserId()+"',createdAt='"+car.getCreatedAt()+"',updatedAt='"+car.getUpdatedAt()+"' WHERE id="+car.getId();
		 try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
        } catch (SQLException ex) {
        	Utilitie.error(CarDao.class.getName(), ex);
        }
        this.closeConnection();
		
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		Car car=(Car) object;
		this.connectionDatabase();
		String sql = "DELETE FROM cars WHERE id=" + car.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(CarDao.class.getName(), ex);
		}
		this.closeConnection();
		
	}

}
