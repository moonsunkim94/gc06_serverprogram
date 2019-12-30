package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import util.JDBCUtil;
import vo.memberVO;

public class memberDAO {
	private Connection cn = JDBCUtil.getConnection();
	private Statement st ;
	private PreparedStatement pst ;
	private ResultSet rs;
	private String sql;
	
	// memberList() : 전체 조회.
	public ArrayList<memberVO> memberList() {
		sql = "select * from member";
		ArrayList<memberVO> mList = new ArrayList<memberVO>();
		try {
			st = cn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				do {
					memberVO vo = new memberVO();
					vo.setId(rs.getString(1));
					vo.setPassword(rs.getString(2));
					vo.setName(rs.getString(3));
					vo.setLev(rs.getString("lev"));
					vo.setPay(rs.getInt("pay"));
					vo.setBirthd(rs.getString(6));
					vo.setWeight(rs.getDouble(7));
					mList.add(vo);
					
				} while(rs.next());
				
			} else {
				System.out.println("출력할 memberList 자료가 1건도 없음~~~");
				mList = null ;
			}
			
		} catch(Exception e) {
			System.out.println("memberList Exception=>"+e.toString());
			mList = null ;
		}
		return mList;
	}
	
	public memberVO loginCheck(memberVO vo) { // member 로그인
		sql = "select * from member where id = ? and password= ?" ; // ? :바인딩 변수
		try {
			pst = cn.prepareStatement(sql); 
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPassword());
			rs = pst.executeQuery();
			if (rs.next()) {return vo;}
		
			
		} catch (Exception e) {
			System.out.println("memberLogin Exception=> "+e.toString());
		}
		return null;
	}
}
