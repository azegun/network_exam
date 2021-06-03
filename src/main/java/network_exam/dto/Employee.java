package network_exam.dto;

public class Employee {
	private int empNo;
	private	String empName;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dept;
	
	public Employee() {
		super();
	}


	public Employee(int empNo) {
		super();
		this.empNo = empNo;
	}


	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dept) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dept = dept;
	}

	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}


	public Employee getManager() {
		return manager;
	}


	public void setManager(Employee manager) {
		this.manager = manager;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}
	public String ManagerList() {
		if(manager.getEmpName() == null) {
			return "";
		}
		return String.format(" %s", manager.getEmpName());
	}
	public String TitleList() {	
		return String.format("%s", title.getName());
	}	
	public String DeptList() {
		return String.format("%s", dept.getdName());
	}


	@Override
	public String toString() {
		return String.format("Employee [empNo=%s, empName=%s, title=%s, manager=%s, salary=%s, dept=%s]", empNo,
				empName, title.getNo(), manager.getEmpNo(), salary, dept.getdNo());
	}
}
