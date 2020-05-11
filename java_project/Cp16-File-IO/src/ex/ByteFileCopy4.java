package ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteFileCopy4 {

	public static void main(String[] args) {

		InputStream in = null;
		OutputStream out = null;
		BufferedInputStream bin=null;
		BufferedOutputStream bout=null;

		int copyByte = 0;
		int bData;

		try {

			// 원본 파일의 데이터를 프로그램안으로 가져와야한다.
			// => InputStream 인스턴스 생성
			in = new FileInputStream("KakaoTalk_Setup (1).exe");

			// 새로운 파일을 생성
			// => OutputStream 인스턴스 생성
			out = new FileOutputStream("copy-2.exe");
			
			//필터스트림 생성→속도 향상
			bin = new BufferedInputStream(in);
			bout = new BufferedOutputStream(out);
			

			while (true) {

				bData = bin.read();

				if (bData == -1) {
					break;
				}
				bout.write(bData);
				copyByte++;

			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bin.close();
				bout.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("복사된 바이트 크기 : " + copyByte);

	}

}
