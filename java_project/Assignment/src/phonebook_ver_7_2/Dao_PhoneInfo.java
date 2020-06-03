package phonebook_ver_7_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao_PhoneInfo {

	int typeNum=0;

	// 1. 완성 /일단 전체 입력은 됨
	public int pbInsert(PhoneInfo info) {

		// JDBC 사용 객체
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			String sql = "insert into phonebook (pbidx, pbname, PbNumber, Pbaddr, pbmail, pbtype, "
												+ "pbmajor, pbgrade, "
												+ "pbcomname, pbcomdept, pbcomjob, "
												+ "pbcafename, pbcafenickname) "
												+ "values (PHONEBOOK7_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

//			pstmt.setInt(1, info.getPbidx());
			pstmt.setString(1, info.getPbname());
			pstmt.setString(2, info.getPbNumber());
			pstmt.setString(3, info.getPbaddr());
			pstmt.setString(4, info.getPbmail());
			pstmt.setString(5, info.getPBType());
			pstmt.setString(6, info.getPbmajor());
			pstmt.setInt(7, info.getPbgrade());
			pstmt.setString(8, info.getPbcomName());
			pstmt.setString(9, info.getPbComDept());
			pstmt.setString(10, info.getPbComJob());
			pstmt.setString(11, info.getPbcafeName());
			pstmt.setString(12, info.getPbNickName());
			

			resultCnt = pstmt.executeUpdate();

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		return resultCnt;

	}

	// 2. 완
	public List<PhoneInfo> pbSearch(String searchName) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<PhoneInfo> pbList = new ArrayList<>();

		try {
			conn = ConnectionProvider.getConnection();

			String sql = "select * from phonebook where pbname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				pbList.add(new PhoneInfo(rs.getInt("pbidx"), rs.getString("pbname"), rs.getString("pbnumber"),
						rs.getString("pbaddr"), rs.getString("pbmail"), rs.getString("pbtype"), rs.getString("pbmajor"), rs.getInt("pbgrade"),
						rs.getString("pbcomName"), rs.getString("pbcomdept"), rs.getString("pbcomjob"), rs.getString("pbcafename"), rs.getString("pbcafenickname")));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return pbList;

	}

	// 3.완- 삭제 가능
	public int pbDelete(String searchName) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {
			conn = ConnectionProvider.getConnection();

			String sql = "delete from phonebook where pbname=?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchName);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultCnt;

	}

	// 4.완?
	public int pbEdit(String searchName, String newPhoneNum, String newAddr, String newEmail) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {
			
			conn = ConnectionProvider.getConnection();

			String sql = "update phonebook set pbnumber=?, pbaddr=?, pbmail=? where pbname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPhoneNum);
			pstmt.setString(2, newAddr);
			pstmt.setString(3, newEmail);
			pstmt.setString(4, searchName);

			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return resultCnt;

	}

	// 5. 완성
	public List<PhoneInfo> pbShowAll() {

		// VO : Value Object , read only , getter
		// DTO : Data Transfer Object getter/setter , toString, equals

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PhoneInfo> pbList = new ArrayList<>();

		try {
			conn = ConnectionProvider.getConnection();

			String sql = "select * from phonebook order by pbidx";
			
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);


			rs = pstmt.executeQuery();

			while (rs.next()) {

				PhoneInfo info = new PhoneInfo(
												rs.getInt("pbidx"), 
												rs.getString("pbname"), 
												rs.getString("pbnumber"),
												rs.getString("pbaddr"), 
												rs.getString("pbmail"),
												rs.getString("pbtype"),
												rs.getString("pbmajor"), 
												rs.getInt("pbgrade"),
												rs.getString("pbcomName"),
												rs.getString("pbcomdept"),
												rs.getString("pbcomjob"),
												rs.getString("pbcafename"),
												rs.getString("pbcafenickname")
												
												);

				pbList.add(info);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return pbList;

	}

	public static int searchPbidx(String searchName) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pbidx=0;
		
		try {
			conn= ConnectionProvider.getConnection();
			
			String sql = "select pbidx from phonebook where pbname=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				pbidx=rs.getInt("pbidx");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
		return pbidx;
		
		
	}
	
	/////////폰북타입 찾기 메서드(숫자반환)
	public int searchTypeNum(String searchName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pbtype=null;
		int typeNum = 0;
		
		
		try {
			conn=ConnectionProvider.getConnection();
			
			String sql = "select pbtype from phonebook where pbname=?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				pbtype=rs.getString("pbtype");
			}
			
			if(pbtype.equals("com")) {
				typeNum=1;
			}else if(pbtype.equals("univ")) {
				typeNum=2;
			}else if(pbtype.equals("cafe")) {
				typeNum=3;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return typeNum;
		
		
	}
	
	
	////////타입 정하는 메서드(숫자반환)
//	public int searchTypeNum(String pbtype) {
//		
//		if(pbtype.equals("com")) {
//			typeNum=1;
//		}else if(pbtype.equals("univ")) {
//			typeNum=2;
//		}else if(pbtype.equals("cafe")) {
//			typeNum=3;
//		}
//		
//		return typeNum;
//	}
	
	
	/////////// sequence /쓰게 될지 말지..?

	public int getPbIdx(String name) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pbidx = 0;

		try {
			conn = ConnectionProvider.getConnection();

			stmt = conn.createStatement();
			
			String sql = "insert into phonebook (pbidx) "
					+ "values phonebook7_seq.nextval where pbname=?";

//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				pbidx = rs.getInt("pbidx");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return pbidx;

	}

}
