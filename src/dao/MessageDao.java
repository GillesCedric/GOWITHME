package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Message;
import models.Payment;
import models.Request;
import utilities.Utilitie;

public class MessageDao extends Dao{

	@Override
	public Object isExists(ArrayList<?> list, Object msg) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Message> dataList=(ArrayList<Message>) list;
		for(Message message:dataList) {
			if(message.equals(msg))
				return message;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<Message> dataList=(ArrayList<Message>) list;
		String values="";
		for(Message message:dataList) {
			values+="('" +message.getUserIdMessager()+ "','" + message.getUserIdMessagee()+ "','" + message.getMessage()+"','"
					+ message.getCreatedAt()+ "','" + message.getUpdatedAt()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO messages(userIdMessager,usedrIdMessagee,message,createdAt,updatedAt) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(MessageDao.class.getName(), ex);
		}
		this.closeConnection();
		
	}

	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Message> liste=new ArrayList();
		try {
			String sql="SELECT * FROM messages";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					liste.add(new Message(rs.getInt("userIdMessager"),rs.getInt("userIdMessagee"),rs.getString("message"),rs.getTimestamp("createdAt"),rs.getTimestamp("updatedAt")));
				}
			}catch(SQLException ex) {
				Utilitie.error(MessageDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(MessageDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		Message message=(Message) object;
		String sql="UPDATE messages SET message='"+message.getMessage()+"',createdAt='"+message.getCreatedAt()+"',updatedAt='"+message.getUpdatedAt()+"' WHERE id="+message.getUserIdMessager()+message.getUserIdMessagee();
		 try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
        } catch (SQLException ex) {
        	Utilitie.error(MessageDao.class.getName(), ex);
        }
        this.closeConnection();
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void delete(Object object) {
		Message message = (Message) object;
		this.connectionDatabase();
		String sql = "DELETE FROM messages WHERE id=" + message.getUserIdMessager()+message.getUserIdMessagee();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(MessageDao.class.getName(), ex);
		}
		this.closeConnection();
		
	}

}
