package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Paypal;
import models.Stripe;
import utilities.Utilitie;

public class PaypalDao extends Dao {

	@Override
	public Object isExists(ArrayList<?> list, Object paypal) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Paypal> dataList=(ArrayList<Paypal>) list;
		for(Paypal paypals:dataList) {
			if(paypals.equals(paypal))
				return paypals;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<Paypal> dataList=(ArrayList<Paypal>) list;
		String values="";
		for(Paypal paypal:dataList) {
			values+="('" +paypal.getUsername()+ "','" +
					paypal.getPassword()+ "','" +paypal.getUserId()+"','" + 
					paypal.getCreatedAt()+ "','" + paypal.getUpdatedAt()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO paypals(usernaùme,password,createdAt,updatedAt,userId) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(PaypalDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<?> list() {
		this.connectionDatabase();
		ArrayList<Paypal> liste=new ArrayList();
		try {
			String sql="SELECT * FROM paypals";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					liste.add(new Paypal(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getInt("userId"),rs.getTimestamp("createdAt"),rs.getTimestamp("updatedAt")));
				}
			}catch(SQLException ex) {
				Utilitie.error(PaypalDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(PaypalDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		Paypal paypal=(Paypal) object;
		String sql="UPDATE payplas SET username='"+paypal.getUsername()+"',password='"+paypal.getPassword()+"',userId='"+paypal.getUserId()+"',createdAt='"+paypal.getCreatedAt()+"',updatedAt='"+paypal.getUpdatedAt()+"' WHERE id="+paypal.getId();
		 try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
        } catch (SQLException ex) {
        	Utilitie.error(StripeDao.class.getName(), ex);
        }
        this.closeConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) {
		Paypal paypal = (Paypal) object;
		this.connectionDatabase();
		String sql = "DELETE FROM paypals WHERE id=" + paypal.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(PaypalDao.class.getName(), ex);
		}
		this.closeConnection();
		
		// TODO Auto-generated method stub
		
	}

}
