package sqlbean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "messagetable")
public class messagetable {
	private  String name;
	private  String message;
	private  int respond;
	private  String time;
	private  int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getRespond() {
		return respond;
	}
	public void setRespond(int respond) {
		this.respond = respond;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "messagetable [name=" + name + ", message=" + message + ", respond=" + respond + ", time=" + time
				+ ", id=" + id + "]";
	}


}
