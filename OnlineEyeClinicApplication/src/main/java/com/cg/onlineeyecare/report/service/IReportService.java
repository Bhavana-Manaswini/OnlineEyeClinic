package com.cg.onlineeyecare.report.service;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;
import com.cg.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.cg.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.cg.onlineeyecare.report.dto.Report;
import com.cg.onlineeyecare.spectacles.dto.Spectacles;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface IReportService {
	Report addReport(Report report);
	Report updateReport(Report report) throws ReportIdNotFoundException;
	Report removeReport(int reportId) throws ReportIdNotFoundException;
	Report viewReport(int reportId, int patientId) throws ReportIdNotFoundException,PatientIdFoundNotException;
	List<Report> viewAllReport(LocalDate date);
	List<Spectacles> viewSpetacles();
}
