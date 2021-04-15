package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Payment;
import models.Preference;
import utilities.Utilitie;

public class PaymentDao extends Dao {

	@Override
	public Object isExists(ArrayList<?> list, Object payment) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Payment> dataList=(ArrayList<Payment>) list;
		for(Payment payments:dataList) {
			if(payments.equals(payment))
				return payments;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Payment> dataList=(ArrayList<Payment>) list;
		String values="";
		for(Payment payment:dataList) {
			values+="('" +payment.getState()+ "','" +
					payment.getReference()+ "','" +payment.getCustomerId()+"','" + 
					payment.getCreatedAt()+ "','" + payment.getUpdatedAt()+payment.getSeat()+"','" +
					payment.getAmount()+"','" +payment.isReceive()+"','" +payment.isRefund()+"','" +
					payment.getReceiveDate()+"','" +payment.getRefundDate()+"','" +payment.getUserId()+"','" +payment.getTravelId()+"','" +
					payment.getPayementMethodId()+"','" +"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO payments(state,reference,customerId,seat,amount,isReceive,isRefund,receiveDate,refundDate,createdAt,updatedAt,userId,travelId,PayementMethodId) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(PaymentDao.class.getName(), ex);
		}
		this.closeConnection();
		
	}

	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Payment> liste=new ArrayList();
		try {
			String sql="SELECT * FROM payments";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					liste.add(new Payment(rs.getInt("id"),rs.getString("state"),
							rs.getString("reference"),rs.getInt("customerId"),rs.getInt("seat"),rs.getInt("amount"),
							rs.getBoolean("isReceive"),rs.getTimestamp("receiveDate"),rs.getBoolean("isRefund"),rs.getTimestamp("refundDate"),
							rs.getInt("userId"),rs.getInt("travelId"),rs.getInt("payementMethodId"),
							rs.getTimestamp("createdAt"),
							rs.getTimestamp("updatedAt")));
				}
			}catch(SQLException ex) {
				Utilitie.error(PaymentDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(PaymentDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		Payment payement=(Payment) object;
		String sql="UPDATE payments SET state='"+payement.getState()+"',reference='"+payement.getReference()+"'"
				+ ",customerId='"+payement.getCustomerId()+"',seat='"+payement.getSeat()+"',amount='" +payement.getAmount()+"'"
						+ ",isReceive='" +payement.isReceive()+"',receiveDate='" +payement.getReceiveDate()+"',refund='" +payement.isRefund()+"'"
								+ ",refundDate='" +payement.getRefundDate()+"',userId='" +payement.getUserId()+"',payementMethodId='" +payement.getPayementMethodId()+"',travelId='" +payement.getTravelId()+"'"
										+ ",createdAt='"+payement.getCreatedAt()+"'"
						+ ",updatedAt='"+payement.getUpdatedAt()+"' WHERE id="+payement.getId();
		 try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
        } catch (SQLException ex) {
        	Utilitie.error(PaymentDao.class.getName(), ex);
        }
        this.closeConnection();
		
		
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		Payment payement = (Payment) object;
				this.connectionDatabase();
				String sql = "DELETE FROM payments WHERE id=" + payement.getId();
				try {
					PreparedStatement prepareStatement = connection.prepareStatement(sql);
					prepareStatement.execute();
				} catch (SQLException ex) {
					Utilitie.error(PaymentDao.class.getName(), ex);
				}
				this.closeConnection();
				
		
	}

}
