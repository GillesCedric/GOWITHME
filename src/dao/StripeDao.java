package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Stripe;
import utilities.Utilitie;

public class StripeDao extends Dao{
	
	public StripeDao() {
		super();
	}

	@Override
	public Object isExists(ArrayList<?> list, Object stripe) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Stripe> dataList=(ArrayList<Stripe>) list;
		for(Stripe stripes:dataList) {
			if(stripes.equals(stripe))
				return stripes;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<Stripe> dataList=(ArrayList<Stripe>) list;
		String values="";
		for(Stripe stripe:dataList) {
			values+="('" +stripe.getNumber()+ "','" + stripe.getExpirationMonth() + "','" + stripe.getExpirationYear()+"','"
					+ stripe.getCvv()+ "','" + stripe.getCreatedAt()+ "','" + stripe.getUpdatedAt()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO stripes(number,expirationMonth,expirationYear,cvv,createdAt,updatedAt) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(StripeDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<?> list() {
		this.connectionDatabase();
		ArrayList<Stripe> liste=new ArrayList();
		try {
			String sql="SELECT * FROM stripes";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					liste.add(new Stripe(rs.getInt("id"),rs.getInt("number"),rs.getInt("expirationMonth"),rs.getInt("expirationYear"),rs.getInt("cvv"),rs.getTimestamp("createdAt"),rs.getTimestamp("updatedAt")));
				}
			}catch(SQLException ex) {
				Utilitie.error(StripeDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(StripeDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		Stripe stripe=(Stripe) object;
		String sql="UPDATE stripes SET number='"+stripe.getNumber()+"',expirationMonth='"+stripe.getExpirationMonth()+"',expirationYear='"+stripe.getExpirationYear()+"',cvv='"+stripe.getCvv()+"',createdAt='"+stripe.getCreatedAt()+"',updatedAt='"+stripe.getUpdatedAt()+"' WHERE id="+stripe.getId();
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
		Stripe stripe = (Stripe) object;
		this.connectionDatabase();
		String sql = "DELETE FROM stripes WHERE id=" + stripe.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(StripeDao.class.getName(), ex);
		}
		this.closeConnection();
		
		// TODO Auto-generated method stub
		
	}

}
