package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Breakpoint;
import utilities.Utilitie;

public class BreakpointDao extends Dao {

	public BreakpointDao() {
		super();
	}

	@Override
	public Object isExists(ArrayList<?> list, Object object) {
		@SuppressWarnings("unchecked")
		ArrayList<Breakpoint> dataList = (ArrayList<Breakpoint>) list;
		for (Breakpoint breakpoint : dataList) {
			if (breakpoint.equals(breakpoint))
				return breakpoint;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(ArrayList<?> list) {
		this.connectionDatabase();
		ArrayList<Breakpoint> dataList = (ArrayList<Breakpoint>) list;
		String values = "";
		for (Breakpoint breakpoint : dataList) {
			values += "(\"" + breakpoint.getPoint() + "\",\"" + breakpoint.getTime() + "\"," + breakpoint.getTravelId()
					+ "),";
		}
		values = values.substring(0, values.length() - 1);
		values += ";";
		String sql = "INSERT INTO breakpoints(point,time,travelId) VALUES " + values;
		System.out.println(sql);
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(BreakpointDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub

	}

	@Override
	public int insert(Object object) {
		this.connectionDatabase();
		int id = 0;
		Breakpoint breakpoint = (Breakpoint) object;
		String sql = "INSERT INTO breakpoints(point,time,travelId) VALUES " + "(\"" + breakpoint.getPoint() + "\",\""
				+ breakpoint.getTime() + "\"," + breakpoint.getTravelId() + ")";
		try {
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
		} catch (SQLException ex) {
			Utilitie.error(BreakpointDao.class.getName(), ex);
		}
		this.closeConnection();
		return id;
	}

	@Override
	public ArrayList<?> list() {
		// TODO Auto-generated method stub
		this.connectionDatabase();
		ArrayList<Breakpoint> liste = new ArrayList<Breakpoint>();
		try {
			String sql = "SELECT * FROM breakpoints";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			try {
				while (rs.next()) {
					liste.add(new Breakpoint(rs.getInt("id"), rs.getString("point"), rs.getString("time"),
							rs.getTimestamp("createdAt"), rs.getTimestamp("updatedAt"), rs.getInt("travelId")));
				}
			} catch (SQLException ex) {
				Utilitie.error(BreakpointDao.class.getName(), ex);
			}
		} catch (SQLException ex) {
			Utilitie.error(BreakpointDao.class.getName(), ex);

		}
		this.closeConnection();
		return liste;
	}

	@Override
	public void update(Object object) {
		this.connectionDatabase();
		Breakpoint breakpoint=(Breakpoint) object;
		String sql="UPDATE breakpoints SET point=\""+breakpoint.getPoint()+"\",time=\""+breakpoint.getTime()+"\",WHERE id="+breakpoint.getId();
		 try {
             PreparedStatement prepareStatement = connection.prepareStatement(sql);
             prepareStatement.execute();
         } catch (SQLException ex) {
         	Utilitie.error(BreakpointDao.class.getName(), ex);
         }
         this.closeConnection();
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Object object) {
		Breakpoint breakpoint = (Breakpoint) object;
		this.connectionDatabase();
		String sql = "DELETE FROM breakpoints WHERE id=" + breakpoint.getId();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.execute();
		} catch (SQLException ex) {
			Utilitie.error(BreakpointDao.class.getName(), ex);
		}
		this.closeConnection();
		// TODO Auto-generated method stub
	}

}
