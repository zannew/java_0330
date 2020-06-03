package phoneBook_ver_7_3;

public class ComDTO {

	private int pidx;
	private String comName;
	private String dname;
	private String comJob;
	private int fr_ref;
	
	//default constructor
	ComDTO(){}

	public ComDTO(int pidx, String comName, String dname, String comJob, int fr_ref) {
		this.pidx = pidx;
		this.comName = comName;
		this.dname = dname;
		this.comJob = comJob;
		this.fr_ref = fr_ref;
	}

	//GETTER
	public int getPidx() {
		return pidx;
	}

	public String getComName() {
		return comName;
	}

	public String getDname() {
		return dname;
	}

	public String getComJob() {
		return comJob;
	}

	public int getFr_ref() {
		return fr_ref;
	}
	
	

	
	
	
}
