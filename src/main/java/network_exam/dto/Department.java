package network_exam.dto;

public class Department {

	private int dNo;
	private String dName;
	private int floor;
	
//	private List<Employee> emplist;
	
	
	public Department() {
		super();
	}

	public Department(int dNo) {
		super();
		this.dNo = dNo;
	}

	public Department(int dNo, String dName, int floor) {
		super();
		this.dNo = dNo;
		this.dName = dName;
		this.floor = floor;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Department [dNo=" + dNo + ", dName=" + dName + ", floor=" + floor + "]";
	}
	
	
	
}
