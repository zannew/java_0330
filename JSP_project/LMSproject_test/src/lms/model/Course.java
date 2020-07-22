package lms.model;

import java.sql.Date;
import java.sql.Timestamp;


//자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
public class Course {
	
	private int cIdx;
	private String name;
	private String teacher;
	private String content;
	private String day;
	private Timestamp startTime;
	private Timestamp endTime;
	private int totalPer;
	private int applyPer;
	private int tIdx;
	
	
	public Course(int cIdx, String name, String teacher, String content, String day, Timestamp startTime, Timestamp endTime,
			int totalPer, int applyPer, int tIdx) {
		this.cIdx = cIdx;
		this.name = name;
		this.teacher = teacher;
		this.content = content;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.totalPer = totalPer;
		this.applyPer = applyPer;
		this.tIdx = tIdx;
	}
	
	public Course () {
		
	}

	public int getcIdx() {
		return cIdx;
	}

	public void setcIdx(int cIdx) {
		this.cIdx = cIdx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getTotalPer() {
		return totalPer;
	}

	public void setTotalPer(int totalPer) {
		this.totalPer = totalPer;
	}

	public int getApplyPer() {
		return applyPer;
	}

	public void setApplyPer(int applyPer) {
		this.applyPer = applyPer;
	}

	public int gettIdx() {
		return tIdx;
	}

	public void settIdx(int tIdx) {
		this.tIdx = tIdx;
	}

	@Override
	public String toString() {
		return "Course [cIdx=" + cIdx + ", name=" + name + ", teacher=" + teacher + ", content=" + content 
				+ ", day=" + day + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", totalPer=" + totalPer + ", applyPer=" + applyPer + ", tIdx=" + tIdx + "]";
	}
	
	
	
	
	
	
	
}