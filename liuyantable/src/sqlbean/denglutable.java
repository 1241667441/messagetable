package sqlbean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "denglutable")
public class denglutable {
    private int id;
	private String name;
	private String password;
	private Integer status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "denglutable [id=" + id + ", name=" + name + ", password=" + password + ", status=" + status + "]";
	}

}
