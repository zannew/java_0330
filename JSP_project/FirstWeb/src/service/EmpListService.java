package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.EmpDAO;
import jdbc.ConnectionProvider;
import model.Emp;

// 핵심 코드들 집합 : 전송 기능
public class EmpListService {

	//default constructor
	private EmpListService() { }
	
	// singleton pattern
	private static EmpListService service = new EmpListService();
	public static EmpListService getInstance() {
		return service;
	}
	
	EmpDAO dao;
	
	// 여기서 예외, 트랜잭션 처리
	public List<Emp> getEmpList(){
		
		// 사용할 DAO instance
		dao = EmpDAO.getInstance();
		
		// Connection 
		Connection conn = null;
		List<Emp> list = null;
		try {
			conn = ConnectionProvider.getConnection();
			list = dao.getEmpList(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
