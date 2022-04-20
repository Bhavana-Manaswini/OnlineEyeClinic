package com.cg.onlineeyecare.test.service;
import java.util.List;
import com.cg.onlineeyecare.exceptions.TestIdNotFoundException;
import com.cg.onlineeyecare.test.dto.Test;
import org.springframework.stereotype.Component;
@Component//@Component  allows Spring to automatically detect our custom beans
public interface ITestService {
	Test addTest(Test test);
	Test updateTest(Test test) throws TestIdNotFoundException;
	Test removeTest(int testId) throws TestIdNotFoundException;
	Test viewTest(int testId) throws TestIdNotFoundException;
	List<Test> viewAllTests();
}
