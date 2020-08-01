package di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import di.dao.MemberDao;
import di.service.ChangePasswordService;
import di.service.MemberRegisterService;


//** 설정 파일
@Configuration
public class JavaConfig {

	@Bean(name = "dao")				//getBean()에서 쓰일 이름
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean(name = "regSvc")			//getBean()에서 쓰일 이름
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	//이름 지정 안 한 경우 메서드 이름으로 지정
	@Bean
	public ChangePasswordService changePwSvc() {
		return new ChangePasswordService(memberDao());
	}
	
}
