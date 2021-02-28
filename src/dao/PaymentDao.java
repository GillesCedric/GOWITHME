package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Payment;
import system.Log;

public class PaymentDao extends Dao {

	@Override
	public Payment isExists(ArrayList<?> list, Object payement) {
		// TODO Auto-generated method stub
		ArrayList<Payment> dataList = (ArrayList<Payment>) list;
		for (Payment payment : dataList) {
			if (payment.equals(payment))
				return payment;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		// TODO Auto-generated method stub
		
		this.connectionDatabase();
		ArrayList<Payment> dataList = (ArrayList<Payment>) list;

		String values = "";
		for (Payment payment : dataList) {
			values += "(NULL,'" + payment.getId() + "','" + payment.getMode() + "','" + payment.isState()+"','"+ payment.getAmount() + "','" + payment.getDate() + "','" + payment.getTime()+ "','" + payment.getReference() + "','" + payment.getUserId()+"','"+payment.getTravelId() +"'),"; 
			}
		values = values.substring(0, values.length() - 1);
		values += ";";
		String sql = "INSERT INTO payments VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Log.addLog(
					new Log(PaymentDao.class.getName(), "Erreur lors de l'insertion d'un utilisateur " + ex.getMessage()));
		}
		this.closeConnection();

		
	}

	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		ArrayList<Payment> liste = new ArrayList<Payment>();
		try {
			String sql = "SELECT * FROM payments";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			try {
				while (rs.next()) {
					liste.add(new Payment(rs.getInt("id"), rs.getString("mode"), rs.getBoolean("state"),rs.getInt("amount"), rs.getDate("date"),rs.getTime("time"),rs.getString("reference"), rs.getInt("userId"), rs.getInt("userId")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				Log.addLog(
						new Log(PaymentDao.class.getName(), "Erreur lors du listing des utlisateurs " + e.getMessage()));
			}

		} catch (SQLException e) {
			Log.addLog(new Log(PaymentDao.class.getName(), "Erreur lors du listing des utlisateurs " + e.getMessage()));
		}
		return liste;
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		Payment payment = (Payment) object;
        String sql = "UPDATE payments SET id='"+payment.getId()+"',mode='"+payment.getMode()+"',state='"+payment.isState()+"',date='"+payment.getDate()+"',time='"+payment.getTime()+"',reference='"+payment.getReference()+"',userId='"+payment.getUserId()+"',travelId='"+payment.getTravelId()+"' WHERE id="+payment.getId();
            try {
                PreparedStatement prepareStatement = connection.prepareStatement(sql);
                prepareStatement.execute();
            } catch (SQLException ex) {
                
            }

	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		Payment payment = (Payment) object;

		String sql = "DELETE FROM paymets WHERE id=" + payment.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			
		}
	}

}
