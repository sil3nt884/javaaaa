package challenge.entity;



import java.util.Base64;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table (name = "URL")
public class URL {
		
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	
	private String url;
	
	private String shortCode;
	

	public URL() {}
	

	public URL( String url, long count) {
		this.url = url;
		String bytes = count+new Random().nextInt()+""+url+Id+""+new Random().nextInt()+"";
		this.shortCode = Base64.getEncoder().encodeToString(bytes.getBytes()).substring(0, 5);
		}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	
	
	
	
}
