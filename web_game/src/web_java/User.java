package web_java;
import java.io.Serializable;


public class User implements Serializable {
	private static final long serialVersionUID = -7020619477594468968L;
	private String id;
	private String password;
	private String email;
	private boolean flag=false;
	public User(){
	}
	
	public User(String id,String password,String email){
		this.id=id;
		this.password=password;
		this.email=email;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	
}
