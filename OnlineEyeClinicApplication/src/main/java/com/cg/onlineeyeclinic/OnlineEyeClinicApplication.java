package com.cg.onlineeyeclinic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//@EnableJpaRepositories scans the packages for configuration and repository class for Spring Data JPA
@EnableJpaRepositories({"com.cg.onlineeyecare.patient.dao","com.cg.onlineeyecare.appointment.dao","com.cg.onlineeyecare.test.dao","com.cg.onlineeyecare.report.dao","com.cg.onlineeyecare.doctor.dao","com.cg.onlineeyecare.admin.dao"})
//@EntityScan is used when entity classes are not placed in the main application package or its sub-packages
@EntityScan({"com.cg.onlineeyecare.patient.dto","com.cg.onlineeyecare.appointment.dto","com.cg.onlineeyecare.doctor.dto","com.cg.onlineeyecare.report.dto","com.cg.onlineeyecare.spectacles.dto","com.cg.onlineeyecare.test.dto"})
//@ComponentScan tells Spring that where to look for Spring Components explicitly
@ComponentScan({"com.cg.onlineeyecare.controller","com.cg.onlineeyecare.exceptions","com.cg.onlineeyecare.patient.*","com.cg.onlineeyecare.appointment.*","com.cg.onlineeyecare.doctor.*","com.cg.onlineeyecare.report.*","com.cg.onlineeyecare.spectacles.*","com.cg.onlineeyecare.test.*"})
@SpringBootApplication
public class OnlineEyeClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineEyeClinicApplication.class, args);
	}

}
