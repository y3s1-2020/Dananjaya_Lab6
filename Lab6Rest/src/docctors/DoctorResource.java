/**
 * 
 */
package docctors;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author AnupamaBalasooriya
 *
 */
@Path("doctors")
public class DoctorResource {
	DoctorRepo repo = new DoctorRepo();
	
	// View all doctors
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Doctor> getDoctors() {		
		return repo.getDoctors();
	}
	
	// Search a doctor by id
	@GET
	@Path("doctor/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Doctor getDoctorById(@PathParam("id") int id) {		
		return repo.getDoctorById(id);
	}
	
	// Search a doctor by specialization
	@GET
	@Path("doctor/{specialization}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Doctor getDoctorBySpec(@PathParam("specialization") String specialization) {		
		return repo.getDoctorBySpec(specialization);
	}
	
	// Add a doctor
	@POST
	@Path("doctor")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Doctor createDoctor(Doctor d1) {
		repo.create(d1);
		
		return d1;
	}
	
	// Update a doctor
	@PUT
	@Path("doctor")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Doctor updateDoctor(Doctor d1) {
		// If the id the user going to update is null, it creates new doctor with that id
		if (repo.getDoctorById(d1.getId()).getId() == 0) {
			repo.create(d1);
		}
		else {
			repo.update(d1);
		}
			
		return d1;
	}
	
	// Delete a doctor
	@DELETE
	@Path("doctor/{id}")
	public Doctor deleteDoctor(@PathParam("id") int id) {
		Doctor d = repo.getDoctorById(id);
		
		if (d.getId() != 0) {
			repo.delete(id);
		}
		
		return d;
	}
}
