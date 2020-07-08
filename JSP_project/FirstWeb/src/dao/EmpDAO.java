package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Emp;

public class EmpDAO {
	
	
	// 싱글톤패턴 : 외부에서 객체 생성 하는 것을 막는다.
	// 생성자의 접근제어지시자 이용 : private
	private EmpDAO() {
		/* 아직 클래스 내에 처리할 내용이 없음 */
	}
	
	// 사용할 인스턴스 하나를 생성한다.
	// iv → cv화
	private static EmpDAO dao = new EmpDAO();
	// 외부에서 가져다 쓸 수 있는 메서드 : EmpDAO 인스턴스의 참조값을 반환
	public static EmpDAO getInstance() {
		return dao;
	}
	
	
	
	// Connection을 parameter로 받음 ∵ 트랜잭션 처리(같은 connection 공유)
	// cf. 테이블 이름을 매개변수로 받을 수 있다.
	public List<Emp> getEmpList(Connection conn) throws SQLException{
		
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Emp> empList = new ArrayList<>();
		
		// 3. Statement 생성
		stmt = conn.createStatement();
		
		// 실행할 수 있는 SQL문 
		String sql = "select * from emp order by ename desc"; 

		// sql문 결과를 ResultSet 객체에 담는다.
		rs = stmt.executeQuery(sql);
		
		//결과 출력
		while(rs.next()){
			
			empList.add(new Emp(rs.getInt("empno"),
								rs.getString("ename"),
								rs.getInt("sal"), 
								rs.getString("job")
								)
						);
		}
					
		
		return empList;
	}

}
