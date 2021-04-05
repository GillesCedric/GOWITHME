package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Mark;
import models.Paypal;
import utilities.Utilitie;

public class MarkDao extends Dao{
	
	public MarkDao() {
		super();
	}

	@Override
	public Object isExists(ArrayList<?> list, Object mark) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Mark> dataList=(ArrayList<Mark>) list;
		for(Mark marks:dataList) {
			if(marks.equals(mark))
				return marks;
		}
		return null;
	}

	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<Mark> dataList=(ArrayList<Mark>) list;
		String values="";
		for(Mark mark:dataList) {
			values+="('" +mark.getUserIdMaker()+ "','" +
					mark.getUserIdMakee()+ "','" +mark.getMark()+"','" + 
					mark.getCreatedAt()+ "','" + mark.getUpdatedAt()+"),";
		}
		values=values.substring(0, values.length()-1);
		values+=";";
		String sql="INSERT INTO marks(userIdMarker,userIdMarkee,mark,createdAt,updatedAt) VALUES " + values;
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		}catch (SQLException ex) {
			Utilitie.error(MarkDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Mark> liste=new ArrayList();
		try {
			String sql="SELECT * FROM marks";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			try {
				while(rs.next()) {
					liste.add(new Mark(rs.getInt("userIdMarker"),rs.getInt("userIdMarkee"),rs.getInt("mark"),rs.getTimestamp("createdAt"),rs.getTimestamp("updatedAt")));
				}
			}catch(SQLException ex) {
				Utilitie.error(MarkDao.class.getName(), ex);
			}
		}catch(SQLException ex) {
			Utilitie.error(MarkDao.class.getName(), ex);
			
		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		Mark mark=(Mark) object;
		String sql="UPDATE marks SET mark='"+mark.getMark()+"',createdAt='"+mark.getCreatedAt()+"',updatedAt='"+mark.getUpdatedAt()+"' WHERE id="+mark.getUserIdMaker()+mark.getUserIdMakee();
		 try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
        } catch (SQLException ex) {
        	Utilitie.error(MarkDao.class.getName(), ex);
        }
        this.closeConnection();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object object) {
		Mark mark = (Mark) object;
		this.connectionDatabase();
		String sql = "DELETE FROM marks WHERE id=" + mark.getUserIdMaker()+mark.getUserIdMakee();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(MarkDao.class.getName(), ex);
		}
		this.closeConnection();
		
		// TODO Auto-generated method stub
		
	}

}
