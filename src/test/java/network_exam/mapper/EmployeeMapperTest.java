package network_exam.mapper;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import network_exam.config.ContextRoot;
import network_exam.dto.Department;
import network_exam.dto.Employee;
import network_exam.dto.Title;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeMapperTest {

	private static final Log log = LogFactory.getLog(EmployeeMapperTest.class);

	
	@Autowired
	private EmployeeMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Employee> list = mapper.getLists();
		
		
		Assert.assertNotNull(list);
		
	}

	@Test
	public void test02SelectByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Employee employee = mapper.getEmployee(1003);
		Assert.assertNotNull(employee);
				}

	@Test
	public void test03InsertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Employee newEmp =	new Employee(2001, "김상건", new Title(5), new Employee(2106), 2000000, new Department(3));
		int res =mapper.registerEmployee(newEmp);
		Assert.assertEquals(1, res);
		
	}

	@Test
	public void test04UpdateEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee newEmp =	new Employee(2001, "김상건2", new Title(4), new Employee(3427), 3000000, new Department(3));
		
		int res = mapper.modifyEmployee(newEmp);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05DeleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee employee = new Employee(2001);
		int res = mapper.removeEmployee(employee);
		
		Assert.assertEquals(1, res);
	}

}
