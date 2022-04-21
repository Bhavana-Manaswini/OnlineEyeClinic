package com.cg.onlineeyecare.doctor.service;
import java.util.List;
import com.cg.onlineeyecare.appointment.dto.Appointment;
import com.cg.onlineeyecare.doctor.dto.Doctor;
import com.cg.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.cg.onlineeyecare.test.dto.Test;
import org.springframework.stereotype.Component;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface IDoctorService {
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException;
	Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException;
	Doctor viewDoctor(int doctorId) throws DoctorIdNotFoundException;
	List<Doctor> viewDoctorsList();
	List<Appointment> viewAppointments();
	Test createTest(int doctorId,Test test);
}
