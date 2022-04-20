package com.cg.onlineeyecare.appointment.service;
import java.time.LocalDate;
import java.util.List;
import com.cg.onlineeyecare.appointment.dto.Appointment;
import com.cg.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.cg.onlineeyecare.exceptions.InvalidAppointmentException;
import org.springframework.stereotype.Component;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface IAppointmentService{
	Appointment bookAppointment(Appointment appointment);
	Appointment updateAppointment(Appointment appointment)throws InvalidAppointmentException;
	Appointment cancelAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	Appointment viewAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	List<Appointment> viewAllAppointments();
	List<Appointment> viewAppointments(LocalDate date);
}