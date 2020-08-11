package encrypt;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

public class EncTestMain {

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, GeneralSecurityException {

		String str = "HelloJava??";
		
		// 단방향 암호화 객체 생성 : SHA-256
		Sha256 sha256 = new Sha256();
		
		String encStr = sha256.encrypt(str);
		
		
		System.out.println("평문 ▶  "+str);
		System.out.println("SHA-256 암호화 ▶  "+encStr);
		// 단방향 (non-key)이기 때문에 항상 같은 암호문이 나온다.
		System.out.println(sha256.encrypt("1"));
		System.out.println(sha256.encrypt("1"));
		System.out.println(sha256.encrypt("1").length());
		
		
		// 양방향 암호화 객체 생성 : AES-256
		// key : 16자리 - key의 값도 암호화 처리를 한다.
		String key = "0000000000000001";
		String key2 = "0000000000000002";
		AES256Util aes256Util = new AES256Util(key);
		AES256Util aes256Util2 = new AES256Util(key2);
		
		System.out.println("===============================================");
		
		String encStr1 = aes256Util.encrypt(str);
		String encStr2 = aes256Util2.encrypt(str);
		
		// 암호화
		System.out.println("평문 ▶ "+str);
		System.out.println("AES256Util 암호화 1 ▶  "+encStr1);
		System.out.println("AES256Util2 암호화 2 ▶  "+encStr2);
		
		System.out.println("==================================================");
		
		String plainStr1 = aes256Util.decrypt(encStr1);
		String plainStr2 = aes256Util2.decrypt(encStr2);
		System.out.println("AES256Util 복호화 1 ▶  "+plainStr1);
		//System.out.println("AES256Util 복호화 2 ▶  "+plainStr2);	//오류 발생!!
		System.out.println("AES256Util2 복호화 2 ▶  "+plainStr2);
		
		
	}

}
