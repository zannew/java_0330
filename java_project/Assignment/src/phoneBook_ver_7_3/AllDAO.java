package phoneBook_ver_7_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AllDAO {

	
	
	//1.입력-basic
	public int basicInsert(AllDTO allDto, Connection conn) throws SQLException {
		
		int rsCnt=0;
		
		PreparedStatement pstmt = null;
		
		try {
		
		String sql = "insert into phonebook_basic "
				+ "values(phonebook7_3_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, allDto.getName());
			pstmt.setString(2, allDto.getPhoneNum());
			pstmt.setString(3, allDto.getAddr());
			pstmt.setString(4, allDto.getEmail());
			pstmt.setString(5, allDto.getFr_type());
			pstmt.setDate(6, allDto.getRegdate());
			rsCnt=pstmt.executeUpdate();
			
		} 
		//finally로만 정리하는 방법 체크하기!!
		//ResultSet & Conn close가 필요 없다???
//		catch (SQLException e) {
//			e.printStackTrace();
//		} 
			finally {

			// 4. 데이터베이스 연결 종료
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}

			if (pstmt != null) {
				pstmt.close();
				
			}

//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}

		}
		return rsCnt;
		
	}
	
	//1.입력-univ
	public int univInsert(AllDTO allDto, Connection conn) throws SQLException {
		
		int rsCnt=0;
		
		PreparedStatement pstmt = null;
		
		try {
		
		String sql = "insert into phonebook_univ "
				+ "values(phonebook7_3_univ_seq.nextval, ?, ?, phonebook7_3_seq.currval)";
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, allDto.getMajor());
			pstmt.setInt(2, allDto.getGrade());
			rsCnt=pstmt.executeUpdate();
			
		} 
		//finally로만 정리하는 방법 체크하기!!
		//ResultSet & Conn close가 필요 없다???
//		catch (SQLException e) {
//			e.printStackTrace();
//		} 
			finally {

			if (pstmt != null) {
				pstmt.close();
			}
		}
		return rsCnt;
		
	}
	
	//1.입력-com
	public int comInsert(AllDTO allDto, Connection conn) throws SQLException {
		
		int rsCnt=0;
		
		PreparedStatement pstmt = null;
		
		try {
		
		String sql = "insert into phonebook_com "
				+ "values(phonebook7_3_com_seq.nextval, ?, ?, ?, phonebook7_3_seq.currval)";
		
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, allDto.getComName());
			pstmt.setString(2, allDto.getDname());
			pstmt.setString(3, allDto.getComJob());
			
			rsCnt=pstmt.executeUpdate();
			
		} 
		//finally로만 정리하는 방법 체크하기!!
		finally {

			if (pstmt != null) {
				pstmt.close();
			}

		}
		return rsCnt;
		
	}
	
	//2. 검색
	public List<AllDTO> searchInfo(String searchName) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<AllDTO> pbList = new ArrayList<>();

		try {
			conn = ConnectionProvider.getConnection();

			String sql = "select * from phonebook_basic b, phonebook_univ u, phonebook_com c " + 
					"where b.pidx=u.fr_ref(+) and b.pidx=c.fr_ref(+) and name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				pbList.add(new AllDTO(rs.getInt("pidx"), 
						rs.getString("name"), 
						rs.getString("phoneNum"),
						rs.getString("addr"), 
						rs.getString("email"), 
						rs.getString("fr_type"), 
						rs.getDate("regDate"), 
						rs.getString("major"), 
						rs.getInt("grade"),
						rs.getString("comName"),
						rs.getString("dname"), 
						rs.getString("comjob")));

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
	
	
	//3.삭제 - 이름으로
	public int pbDelete(String searchName, Connection conn){

		PreparedStatement pstmt = null;
		int rsCnt = 0;

		try {
			
			String sql = "delete from phonebook_basic where name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rsCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		return rsCnt;

	}
	
	//3. 삭제 - pidx로
	public int pidxDelete(int pidx, Connection conn) {
		
		PreparedStatement pstmt = null;
		int rsCnt = 0;

		try {
			
			String sql = "delete from phonebook_basic where pidx=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pidx);

			rsCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		return rsCnt;
		
	}
	
	
	//4.수정-basic
	public int pbBasicEdit(String searchName, String newPhoneNum, String newAddr, String newEmail, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt=0;

		try {
			
			conn = ConnectionProvider.getConnection();

			String sql = "update phonebook_basic set phoneNum=?, addr=?, email=? "
					+ "where name=?";

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
	
	
	//4.수정-univ
	public int pbUnivEdit(String searchName, String newMajor, int newGrade, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt=0;

		try {
			
			conn = ConnectionProvider.getConnection();

			String sql = "update phonebook_univ " + 
					"set major=?, grade=? " + 
					"where fr_ref=(select pidx from phonebook_basic where name=?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newMajor);
			pstmt.setInt(2, newGrade);
			pstmt.setString(3, searchName);

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
	
	
	
	//4.수정-com
	public int pbComEdit(String searchName, String newComName, String newDname, String newComJob, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt=0;

		try {
			
			conn = ConnectionProvider.getConnection();

			String sql = "update phonebook_com " + 
					"set comname=?, dname=?, comjob=? " + 
					"where fr_ref=(select pidx from phonebook_basic where name=?)";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newComName);
			pstmt.setString(2, newDname);
			pstmt.setString(3, newComJob);
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
	
	
	
	//5.정보 보기
	public List<AllDTO> showInfo() {

		// VO : Value Object , read only , getter
		// DTO : Data Transfer Object getter/setter , toString, equals

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<AllDTO> pbList = new ArrayList<>();

		try {
			conn = ConnectionProvider.getConnection();

			String sql = "select * from phonebook_basic b, phonebook_univ u, phonebook_com c "
					+ "where b.pidx=u.fr_ref(+) and b.pidx=c.fr_ref(+)";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				AllDTO allDto = new AllDTO(
												rs.getInt("pidx"), 
												rs.getString("name"), 
												rs.getString("phonenum"),
												rs.getString("addr"), 
												rs.getString("email"),
												rs.getString("fr_type"),
												rs.getDate("regdate"),
												rs.getString("major"), 
												rs.getInt("grade"),
												rs.getString("comName"),
												rs.getString("dname"),
												rs.getString("comjob")
												
												);

				pbList.add(allDto);

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
	
	
	
	/////////////타입 숫자로 찾기 메서드
	public int searchTypeNum(String searchName) {
			
			Connection conn=null;
			PreparedStatement pstmt = null;
			String fr_type=null;
			int typeNum = 0;
			ResultSet rs = null;
			try {
				
				conn=ConnectionProvider.getConnection();
				
				String sql = "select fr_type from phonebook_basic b, phonebook_univ u, phonebook_com c " + 
						"where b.pidx=u.fr_ref(+) and b.pidx=c.fr_ref(+) and name=?";
				
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, searchName);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					
					fr_type=rs.getString("fr_type");
				}
				
				if(fr_type.equals("basic")) {
					typeNum=1;
				}else if(fr_type.equals("univ")) {
					typeNum=2;
				}else if(fr_type.equals("com")) {
					typeNum=3;
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {

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

			}
			return typeNum;
		}
	
	///////서치 카운트메서드
	public int searchNameCnt(String name, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int existCnt = 0;
		
		
		try {
			
			String sql = "select count(*) " + 
					"from phonebook_basic b, phonebook_univ u, phonebook_com c " + 
					"where b.pidx=u.fr_ref(+) and b.pidx=c.fr_ref(+) and name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				existCnt= rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return existCnt;
	}
	
	/////////////////서치 네임메서드
	public AllDTO searchName(String searchName, Connection conn) {
		
		AllDTO allDto=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select * " + 
					"from phonebook_basic b, phonebook_univ u, phonebook_com c " + 
					"where b.pidx=u.fr_ref(+) and b.pidx=c.fr_ref(+) and name=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				allDto = new AllDTO(rs.getInt(1),
									rs.getString(2),
									rs.getString(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getDate(7),
									rs.getString(8),
									rs.getInt(9),
									rs.getString(10),
									rs.getString(11),
									rs.getString(12));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allDto;
		
	}
	
	}
	
	
	
