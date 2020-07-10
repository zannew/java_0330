package guestbook.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.model.Message;

public class MessageDAO {

	// 일단 싱글톤 처리부터..
	private MessageDAO() {
	}

	private static MessageDAO dao = new MessageDAO();

	public static MessageDAO getInstance() {
		return dao;
	}

	public int insertMessage(Connection conn, Message msg) throws SQLException {

		int resultCnt = 0;

		// Statement
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into guestbook_message values (message_id_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, msg.getUname());
			pstmt.setString(2, msg.getPw());
			pstmt.setString(3, msg.getMsg());

			resultCnt = pstmt.executeUpdate();

		} finally {

			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	public List<Message> selectMessageList(Connection conn, int startRow, int endRow) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Message> list = new ArrayList<Message>();

		try {
			String sql = "select message_id, guest_name, password, message " + "from ( "
					+ " select rownum rnum, message_id, guest_name, password, message " + "from ( "
					+ " select * from guestbook_message m order by m.message_id desc " + " ) where rownum <= ? "
					+ ") where rnum >= ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);

			while (rs.next()) {
				Message message = new Message(rs.getInt("message_id"), rs.getString("guest_name"),
						rs.getString("password"), rs.getString("message"));

				list.add(message);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return list;
	}

	// not yet
	public int selectTotalCount(Connection conn) {

		return 0;
	}

}
