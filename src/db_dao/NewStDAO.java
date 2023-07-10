package db_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db_dto.NewStDTO;

public class NewStDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public ArrayList<NewStDTO> getList(){
		ArrayList<NewStDTO> list = new ArrayList<>();
		String sql = "select * from newst";
		try {
			ps = con.prepareStatement( sql );
			rs = ps.executeQuery();
			while( rs.next() ) {
				NewStDTO dto = new NewStDTO();
				dto.setName( rs.getString("name") );
				dto.setKor( rs.getInt("kor") );
				dto.setEng( rs.getInt("eng") );
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("sum"));
				dto.setAvg(rs.getInt("avg"));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public NewStDTO search( String name ) {
		NewStDTO dto = null;
		String sql ="select * from newst where name='"+name+"'";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if( rs.next() ) { 
				dto = new NewStDTO( rs.getString("name"),
						rs.getInt("kor"),
						rs.getInt("eng"),
						rs.getInt("mat"),
						rs.getInt("sum"),
						rs.getInt("avg")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println( "dto : "+dto);
		return dto;
	}

	public int insert( NewStDTO dto ) {
		String sql = "insert into newst values(?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getName() );
			ps.setInt(2, dto.getKor() );
			ps.setInt(3, dto.getEng() );
			ps.setInt(3, dto.getMat() );
			ps.setInt(3, dto.getSum() );
			ps.setInt(3, dto.getAvg() );

			result = ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int modify( NewStDTO d ) {
		String sql = "update newst set kor=?, eng=?, mat=?, sum=?, avg=? where name=?";
		int result = 0;
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, d.getName() );
			ps.setInt(2, d.getKor() );
			ps.setInt(3, d.getEng() );
			ps.setInt(4, d.getMat() );
			ps.setInt(5, d.getSum() );
			ps.setInt(6, d.getAvg() );

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delete(String name) {
		int result = 0;
		String sql ="delete from newst where name = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1 , name );
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
