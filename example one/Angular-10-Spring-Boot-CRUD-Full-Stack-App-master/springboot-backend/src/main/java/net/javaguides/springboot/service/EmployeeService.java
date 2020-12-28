package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
    public Employee getEmployee(long user_id){
        Optional<Employee> employee = employeeRepository.findById(user_id);
        if(!employee.isPresent())
                throw new ResourceNotFoundException("Employee not found!");
        return employee.get();
    }
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee updateEmployee(long user_id,Employee employee){
    	employee.setUser_id(user_id);
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(long user_id){
    	employeeRepository.deleteById(user_id);
    }
}
