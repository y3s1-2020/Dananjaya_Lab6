/**
 * 
 */
package docctors;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AnupamaBalasooriya
 *
 */
@XmlRootElement
public class Doctor {

	private int id;
	private String name;
	private String specialization;
	
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
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id 
				+ ", name=" + name 
				+ ", specialization=" + specialization + "]";
	}
	
}
