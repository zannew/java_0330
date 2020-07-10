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

import dao.ReportDAO;
import jdbc.ConnectionProvider;
import model.Report;

public class ReportRegService {

	private ReportRegService() {
	}

	private static ReportRegService service = new ReportRegService();

	public static ReportRegService getInstance() {
		return service;
	}

	ReportDAO dao;

	public int regReport(HttpServletRequest request) {

		int resultCnt = 0;

		String sname = "";
		String sno = "";
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

						if (paramName.equals("sname")) {
							sname = paramValue;
						} else if (paramName.equals("sno")) {
							sno = paramValue;
						}

					} else { // type=file인 경우
						// 파라미터의 이름
						String paramName = item.getFieldName();
						// 파일 이름
						String fileName = item.getName();
						// 파일 사이즈
						long file_size = item.getSize();
						// 파일 타입
						String contentType = item.getContentType();
						// 임시 메모리에 저장 여부
						boolean isInMemory = item.isInMemory();
						System.out.println("필드 이름 : " + paramName);
						System.out.println("파일 이름 : " + fileName);
						System.out.println("파일 사이즈 : " + file_size);
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

				// 데이터 베이스 저장
				Report report = new Report();
				report.setSname(sname);
				report.setSno(sno);
				report.setReport(filePath);
				
				conn = ConnectionProvider.getConnection();
				
				dao = ReportDAO.getInstance();
				
				resultCnt = dao.insertReport(conn, report);

				request.setAttribute("report", report);
				
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
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

		return resultCnt;
	}

}
