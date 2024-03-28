package com.soul.Dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.soul.Controller.ResorceNotFoundException;
import com.soul.Repository.EmployeeRepo;
import com.soul.model.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo employeeRepo;
	
	@Override
	public List<EmployeeDto> getAllEmployees() {
	    List<EmployeeDto> employeeDtos = new ArrayList<>();
	    List<Employee> employees = employeeRepo.findAll();

	    for (Employee employee : employees) {
	        EmployeeDto dto = new EmployeeDto();
	        dto.setId(employee.getId());
	        dto.setFirstName(employee.getFirstName());
	        dto.setLastName(employee.getLastName());
	        dto.setEmail(employee.getEmail());
	        // Set other properties as needed
	        employeeDtos.add(dto);
	    }

	    return employeeDtos;
	}


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        // Set other properties as needed

        // Perform any necessary validations or business logic checks here

        Employee savedEmployee = employeeRepo.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto();
        savedEmployeeDto.setId(savedEmployee.getId());
        savedEmployeeDto.setFirstName(savedEmployee.getFirstName());
        savedEmployeeDto.setLastName(savedEmployee.getLastName());
        savedEmployeeDto.setEmail(savedEmployee.getEmail());
        // Set other properties as needed

        return savedEmployeeDto;
    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() ->
                        new ResorceNotFoundException("Employee not exist with id: " + employeeId));
        
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        // Set other properties as needed

        return employeeDto;
    }


    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResorceNotFoundException("Employee not exist with id: " + employeeId));

        // Update properties of existingEmployee with values from employeeDto
        existingEmployee.setFirstName(employeeDto.getFirstName());
        existingEmployee.setLastName(employeeDto.getLastName());
        existingEmployee.setEmail(employeeDto.getEmail());
        // Update other properties as needed

        // Save the updated employee to the repository
        Employee updatedEmployee = employeeRepo.save(existingEmployee);

        // Create a new EmployeeDto object with updated employee information
        EmployeeDto updatedEmployeeDto = new EmployeeDto();
        updatedEmployeeDto.setId(updatedEmployee.getId());
        updatedEmployeeDto.setFirstName(updatedEmployee.getFirstName());
        updatedEmployeeDto.setLastName(updatedEmployee.getLastName());
        updatedEmployeeDto.setEmail(updatedEmployee.getEmail());
        // Set other properties as needed

        return updatedEmployeeDto;
    }


    @Override
    public void deleteEmployee(Long employeeId) {
        Employee existingEmployee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new ResorceNotFoundException("Employee not exist with id: " + employeeId));

        employeeRepo.delete(existingEmployee);
    }

}
