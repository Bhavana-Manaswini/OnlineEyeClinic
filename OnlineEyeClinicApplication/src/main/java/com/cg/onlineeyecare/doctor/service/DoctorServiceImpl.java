package com.cg.onlineeyecare.doctor.service;
import org.springframework.stereotype.Service;
import com.cg.onlineeyecare.appointment.dto.Appointment;
import com.cg.onlineeyecare.doctor.dao.IDoctorRepository;
import com.cg.onlineeyecare.doctor.dto.Doctor;
import com.cg.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.cg.onlineeyecare.test.dto.Test;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
@Service//@Service annotates classes that perform service tasks
public class DoctorServiceImpl implements IDoctorService{
	@Autowired//@Autowired automatically injects the dependent beans into the associated references of a POJO class
	private IDoctorRepository DocRepo;
	//Constructor
	public DoctorServiceImpl() {
		super();
	}	
	//Parameterized constructor
	public DoctorServiceImpl(IDoctorRepository docRepo) {
		super();
		DocRepo = docRepo;
	}
	//implementing unimplemented methods
	@Override
	public Doctor addDoctor(Doctor doctor) {
		return DocRepo.saveAndFlush(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor)  throws DoctorIdNotFoundException{
		Doctor d =DocRepo.findById(doctor.getDoctorId()).orElseThrow(()->new DoctorIdNotFoundException("Invalid Doctor for the Id: "+ doctor.getDoctorId()));
		d.setDoctorName(doctor.getDoctorName());
		d.setDoctorMobile(doctor.getDoctorMobile());
		d.setDoctorEmail(doctor.getDoctorEmail());
		d.setDoctorConsultationTime(doctor.getDoctorConsultationTime());
		d.setDoctorUsername(doctor.getDoctorUsername());
		d.setDoctorPassword(doctor.getDoctorPassword());
		d.setDoctorAddress(doctor.getDoctorAddress());
		d.setTest(doctor.getTest());
		return DocRepo.saveAndFlush(d);
	}

	@Override
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException{
		Doctor d =DocRepo.findById(doctorId).orElseThrow(()->new DoctorIdNotFoundException("Invalid Doctor for the Id: "+ doctorId));
		DocRepo.deleteById(doctorId);
		return d;
	}

	@Override
	public Doctor viewDoctor(int doctorId)  throws DoctorIdNotFoundException{
		Doctor d =DocRepo.findById(doctorId).orElseThrow(()->new DoctorIdNotFoundException("Invalid Doctor for the Id: "+ doctorId));
		return d;
	}

	@Override
	public List<Doctor> viewDoctorsList() {
		return DocRepo.findAll();
	}

	@Override
	public List<Appointment> viewAppointments() {
		List<Doctor> listDoc=DocRepo.findAll();
		List<Appointment> list=new ArrayList<Appointment>();
		for(Doctor d:listDoc) {
			if(d.getAppointment()!=null) {
				list.add(d.getAppointment());
			}
		}
		return list;
	}

	@Override
	public Test createTest(Test test) {
		List<Doctor> listDoc=DocRepo.findAll();
		for(Doctor d:listDoc) {
			if(d.getTest()==null) {
				d.setTest(test);
				DocRepo.saveAndFlush(d);
				break;
			}
		}
		return test;
	}

}
