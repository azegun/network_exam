package network_exam.dto;

public class Title {
	
	private int no;
	private String name;
	
	public Title() {}
	
	public Title(int no) {
		this.no = no;
	}

	public Title(String name) {
		super();
		this.name = name;
	}

	public Title(int no, String name) {
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		public String TitleLists() {	
			return String.format("%s", getName());
		}	

	@Override
	public String toString() {
		return "Title [no=" + no + ", name=" + name + "]";
	}
	
	
}
