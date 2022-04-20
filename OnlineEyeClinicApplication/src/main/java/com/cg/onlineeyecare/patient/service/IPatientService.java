package com.cg.onlineeyecare.patient.service;
import com.cg.onlineeyecare.appointment.dto.Appointment;
import com.cg.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.cg.onlineeyecare.exceptions.PatientIdFoundNotException;
import java.util.List;
import com.cg.onlineeyecare.patient.dto.Patient;
import com.cg.onlineeyecare.report.dto.Report;
import org.springframework.stereotype.Component;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface IPatientService {
	Patient addPatient(Patient patient);
	Patient updatePatient(Patient patient);
	Patient deletePatient(int patientId) throws PatientIdFoundNotException;
	List<Patient> viewPatientList();
	Patient viewPatient(int patientId) throws PatientIdFoundNotException;
	Appointment bookAppointment(Appointment appointment);
	Appointment viewAppointmentDetails(int appointmentid)throws AppointmentIdNotFoundException;
	Report viewReport(int patientId)throws PatientIdFoundNotException;
}