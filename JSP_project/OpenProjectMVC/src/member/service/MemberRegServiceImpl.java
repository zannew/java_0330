package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jdbc.ConnectionProvider;
import member.DAO.MemberDAO;
import member.model.Member;
import service.Service;

public class MemberRegServiceImpl implements Service {

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		// 1. 파일 업로드 - 사진 (binary file) : 특정 경로에 사진을 저장
		// 2. 사용자 데이터를 받기 - uid, upw, uname, photo
		// 1과 2를 받고 2는 DB에 저장
		
		int resultCnt = 0;

		//데이터베이스에 입력할 데이터 변수
		String uid=null;
		String upw=null;
		String uname=null;
		String uphoto=null;
		
		Connection conn = null;
		
		MemberDAO dao;

		try {
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);

			if (isMultipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();	//저장 팩토리 생성
				ServletFileUpload upload = new ServletFileUpload(factory);	

				List<FileItem> items = upload.parseRequest(request);	//데이터 분할해서 저장

				Iterator<FileItem> ite = items.iterator();

				while (ite.hasNext()) {
					FileItem item = ite.next();

					// isFormField() : text value를 가지는 input 체크
					if (item.isFormField()) { // type=file을 제외한 input
						// 파라미터의 이름
						String paramName = item.getFieldName();
						// 파라미터의 값
						String paramValue;
						paramValue = item.getString("utf-8");
						// System.out.println(paramName + " = " + paramValue);

						if (paramName.equals("uid")) {
							uid = paramValue;
						} else if (paramName.equals("upw")) {
							upw = paramValue;
						} else if (paramName.equals("uname")) {
							uname = paramValue;
						} 

					} else { // type=file인 경우
						
						/* 파일 로드 : 절대 경로 */
						// 서버 내부의 경로
						String uri = "/upload/users";

						// re-compile unneccesary
						//String uri = request.getSession().getServletContext().getInitParameter("uploadPath");

						// 시스템의 실제(절대)경로
						String realPath = request.getSession().getServletContext().getRealPath(uri);
						// System.out.println("real path : "+realPath);

						// Tokenizing 활용 시 → 확장자명 제거 후 새로운 파일 이름 생성 가능
						String newFileName = System.nanoTime() + "_" + item.getName();

						// 서버의 저장소에 실제 저장
						File saveFile = new File(realPath, newFileName);
						item.write(saveFile);
						System.out.println("저장 완료");

						uphoto = uri+"/"+newFileName;

					}

				}

				// 데이터 베이스 저장
				Member member = new Member();
				member.setUid(uid);
				member.setUpw(upw);
				member.setUname(uname);
				member.setUphoto(uphoto);
				
				conn = ConnectionProvider.getConnection();
				
				dao = MemberDAO.getInstance();
				
				resultCnt = dao.insertMember(conn, member);

				request.setAttribute("member", member);
				request.setAttribute("result", resultCnt);
				
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return "/WEB-INF/views/member/reg.jsp";
	}

}
