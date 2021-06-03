package network_exam.service.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import network_exam.dto.Employee;
import network_exam.exception.DuplicateEmployeeException;
import network_exam.mapper.EmployeeMapper;
import network_exam.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	static final Log log = LogFactory.getLog(EmployeeServiceImpl.class);
	
	@Autowired 
	private EmployeeMapper mapper;
	@Override
	public List<Employee> getLists() {
		//리스트 사이즈 알기위해서 이렇게 선언 원래는 그냥 리턴만해도됨
		List<Employee> list = mapper.getLists();
		log.debug("service - getLists() >>" + list.size());
		return mapper.getLists();
	}

	@Override
	public Employee getEmployee(int empNo) {
		log.debug("service - getEmp() >>" + empNo);
		return mapper.getEmployee(empNo);
	}

	@Override
	public int registerEmployee(Employee employee) {
		log.debug("service - registerEmp() > " + employee);
		Employee search = mapper.getEmployee(employee.getEmpNo());
		if(search != null) {
			throw new DuplicateEmployeeException("dup employee" + employee.getEmpNo());
		}
		return mapper.registerEmployee(employee);
	}

	@Override
	public int modifyEmployee(Employee employee) {
		log.debug("service - modifyEmp() > " + employee);
		return mapper.modifyEmployee(employee);
	}

	@Override
	public int removeEmployee(Employee employee) {
		log.debug("service - removeMemberByEpno() > " + employee);
		return mapper.removeEmployee(employee);
		
	}

}
