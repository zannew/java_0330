package service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import guestbook.DAO.MemberDAO;
import guestbook.jdbc.ConnectionProvider;
import model.MemberInfo;

public class MemberRegService {

	//싱글톤
	private MemberRegService () {}
	
	private static MemberRegService service = new MemberRegService();
	public static MemberRegService getInstance () {
		return service;
	}
	
	MemberDAO dao;
	
	public int regMember(HttpServletRequest request) {
		
		int resultCnt = 0;
		
		String mid = "";
		String mpw = "";
		String mname = "";
		String filePath = "";
		
		Connection conn = null;
		
		try {

			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (isMultipart) {
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);

			List<FileItem> items = upload.parseRequest(request);
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

					if(paramName.equals("mid")) {
						mid=paramValue;
					} else if (paramName.equals("mpw")) {
						mpw=paramValue;
					} else if(paramName.equals("mname")) {
						mname=paramValue;
					}
					
				} else {// type=file인 경우
					//파라미터이름
					String paramName = item.getFieldName();
					//파일이름
					String fileName = item.getName();
					//파일 사이즈
					long fileSize = item.getSize();
					//파일 타입
					boolean contentType = item.isInMemory();
					System.out.println("필드 이름 : " + paramName);
					System.out.println("파일 이름 : " + fileName);
					System.out.println("파일 사이즈 : " + fileSize);
					System.out.println("파일 타입 : " + contentType);
					
					/* 파일 로드 : 절대 경로 */
					// 서버 내부의 경로
					// String uri = "/file";

					// re-compile unneccesary
					String uri = request.getSession().getServletContext().getInitParameter("uploadPath");

					// 시스템의 실제(절대)경로
					String realPath = request.getSession().getServletContext().getRealPath(uri);
					// System.out.println("real path : "+realPath);

					// Tokenizing → 확장자명 제거 후 새로운 파일 이름 생성 가능
					String newFileName = System.nanoTime() + "_" + fileName;

					// 서버의 저장소에 실제 저장
					File saveFile = new File(realPath, newFileName);
					item.write(saveFile);
					System.out.println("저장 완료");

					filePath = uri + "/" + newFileName;
					}
				}
					//데이터 베이스 저장
					MemberInfo memberInfo = new MemberInfo();
					memberInfo.setMid(mid);
					memberInfo.setMpw(mpw);
					memberInfo.setMname(mname);
					memberInfo.setMphoto(filePath);
				
					System.out.println(memberInfo.toString());
					
					conn = ConnectionProvider.getConnection();
					dao = MemberDAO.getInstance();
					
					resultCnt = dao.addMember(conn, memberInfo);
					
					request.setAttribute("memberInfo", memberInfo);
				
				}
				
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch(Exception e) {
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
			return resultCnt;
		}
		
	}
	
