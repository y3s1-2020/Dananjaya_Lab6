/**
 * 
 */
package docctors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AnupamaBalasooriya
 *
 */
public class DoctorRepo {
	Connection con = null;
	
	public DoctorRepo() {
		String url = "jdbc:mysql://localhost:3306/doctordb";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "", "");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Doctor> getDoctors() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		
		String qry = "SELECT * FROM doctors";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			
			while (rs.next()) {
				Doctor d = new Doctor();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setSpecialization(rs.getString(3));
				
				doctors.add(d);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return doctors;
	}
	
	public Doctor getDoctorById(int id) {
		String qry = "SELECT * FROM doctors WHERE id = " + id;

		Doctor d = new Doctor();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			
			if (rs.next()) {
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setSpecialization(rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return d;
	}

	public Doctor getDoctorBySpec(String specialization) {
		String qry = "SELECT * FROM doctors WHERE specialization = " + specialization;

		Doctor d = new Doctor();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			
			if (rs.next()) {
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				d.setSpecialization(rs.getString(3));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return d;
	}

	public void create(Doctor d1) {
		String qry = "INSERT INTO doctors VALUES (?, ?, ?)";

		Doctor d = new Doctor();
		
		try {
			PreparedStatement stmt = con.prepareStatement(qry);
			
			stmt.setInt(1, d.getId());
			stmt.setString(2, d.getName());
			stmt.setString(3, d.getSpecialization());
			
			stmt.executeUpdate();
			
			System.out.println("Inserted");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(Doctor d1) {
		String qry = "UPDATE doctors SET name = ?, specialization = ? WHERE id = ?";

		Doctor d = new Doctor();
		
		try {
			PreparedStatement stmt = con.prepareStatement(qry);
			
			stmt.setString(1, d.getName());
			stmt.setString(2, d.getSpecialization());
			stmt.setInt(3, d.getId());
			
			stmt.executeUpdate();
			
			System.out.println("Updated");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(int id) {
		String qry = "DELETE FROM doctors WHERE id = ?";

		Doctor d = new Doctor();
		
		try {
			PreparedStatement stmt = con.prepareStatement(qry);
			
			stmt.setInt(1, d.getId());
			
			stmt.executeUpdate();
			
			System.out.println("Deleted");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
