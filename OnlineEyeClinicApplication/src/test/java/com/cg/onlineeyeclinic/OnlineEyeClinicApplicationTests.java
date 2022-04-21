package com.cg.onlineeyeclinic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlineeyecare.appointment.dto.Appointment;
import com.cg.onlineeyecare.patient.dao.IPatientRepository;
import com.cg.onlineeyecare.patient.dto.Patient;
import com.cg.onlineeyecare.patient.service.IPatientService;
import com.cg.onlineeyecare.patient.service.PatientServiceImpl;
@SpringBootTest
class OnlineEyeClinicApplicationTests {
	@Autowired
	IPatientRepository pRepo;
	@Test
	public void addPatientTest() {
		Patient p=new Patient();
		p.setPatientName("Bhavana");
		p.setPatientAge(21);
		p.setPatientMobile(9100532241L);
		p.setPatientEmail("bhavana@gmail.com");
		pRepo.saveAndFlush(p);
		Assert.assertFalse(pRepo.findAll().size()==0);
	}
	@Test
	public void viewPatientListTest() {
		Assert.assertFalse(pRepo.findAll().size()==0);
	}
	@Test
	public void viewPatientTest() {
		Patient p=pRepo.getById(1);
		Assert.assertFalse(1!=p.getPatientId());
	}
	@Test
	public void updatePatientTest() {
		Patient p=pRepo.getById(1);
		p.setPatientName("Manaswini");
		p.setPatientAge(20);
		p.setPatientMobile(9100532241L);
		p.setPatientEmail("manas@gmail.com");
		pRepo.saveAndFlush(p);
		Assert.assertFalse("Manaswini"!=pRepo.getById(1).getPatientName());
	}
	@Test
	public void bookAppointmentTest() {
		Patient p=pRepo.getById(1);
		Appointment a=new Appointment();
		a.setDateOfAppointment(LocalDate.parse("2022-04-15",DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		a.setConsultationFee(500);
		a.setTimeOfAppointment(LocalTime.parse("10:30",DateTimeFormatter.ofPattern("HH:mm")));
		p.setAppointment(a);
		pRepo.saveAndFlush(p);
		Assert.assertFalse(500!=p.getAppointment().getConsultationFee());
	}
	@Test
	public void viewAppointmentTest() {
		Patient p=pRepo.findById(1).get();
		Assert.assertFalse(500!=p.getAppointment().getConsultationFee());
	}
	@Test
	public void viewReportTest() {
		Patient p=pRepo.getById(1);
		Assert.assertFalse(p.getReport()!=null);
	}
	@Test
	public void deletePatientTest() {
		pRepo.deleteById(1);
		Assert.assertFalse(pRepo.getById(1)!=null);
	}
}
