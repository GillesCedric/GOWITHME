package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Participate;
import models.Payment;
import dao.Dao; 
import java.sql.Connection;
import java.util.ArrayList;
import system.Log;

public  class ParticipateDao extends Dao {
	
	
	public ParticipateDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public Participate isExists(ArrayList<?> list, Object participate) {
		// TODO Auto-generated method stub
		ArrayList<Participate> dataList = (ArrayList<Participate>) list;
		for (Participate participate : dataList) {
			if (participate.equals(participate))
				return participate;

		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		// TODO Auto-generated method stub
		
			this.connectionDatabase();
			ArrayList<Participate> dataList = (ArrayList<Participate>) list;

			String values = "";
			for (Participate participate : dataList) {
				values += "(NULL,'" + participate.getId() + "','" + participate.getSeats() + "','" + participate.getMark()
						+ participate.getComments() + "','" + participate.getUserId() + "','" + participate.getTravelId()+ "'),";
			}
			values = values.substring(0, values.length() - 1);
			values += ";";
			String sql = "INSERT INTO participate VALUES " + values;
			try {
				PreparedStatement prepareStatement = connection.prepareStatement(sql);
				prepareStatement.execute();
			} catch (SQLException ex) {

			}
			this.closeConnection();

		}


	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		
		ArrayList<Participate> liste = new ArrayList<Participate>();
		try {
			String sql = "SELECT * FROM participate";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			try {
				while (rs.next()) {
					liste.add(new Participate(rs.getInt("id"), rs.getInt("seats"), rs.getInt("mark"),rs.getString("comment"),rs.getInt("userId"),rs.getInt("travelId")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block

				Log.addLog(
						new Log(ParticipateDao.class.getName(), "Erreur lors du listing des utlisateurs " + e.getMessage()));
			}

		} catch (SQLException e) {
			Log.addLog(new Log(ParticipateDao.class.getName(), "Erreur lors du listing des utlisateurs " + e.getMessage()));
		}
		
		return liste;
	}

		

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		Participate participate = (Participate) object;
        String sql = "UPDATE participate SET ID='"+participate.getId()+"',seats='"+participate.getSeats()+"',mark='"+participate.getMark()+"',comment='"+participate.getComments()+"',userId='"+participate.getUserId()+"',travelId='"+participate.getTravelId()+"' WHERE id="+participate.getId();;
            try {
                PreparedStatement prepareStatement = connection.prepareStatement(sql);
                prepareStatement.execute();
            } catch (SQLException ex) {
            
            }
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		
		Participate participate = (Participate) object;

		String sql = "DELETE FROM participate WHERE id=" + participate.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			
		}
		
	}
	
}