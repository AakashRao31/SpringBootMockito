package com.csi.dao.test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @MockBean
    EmployeeRepo employeeRepoImpl;

    @Test
    public void saveDataTest()
    {
        Employee employee=new Employee(121,"Aakash","Nashik",45652.25,new Date(),"rao@gmail.com");

        employeeDaoImpl.saveData(employee);

        verify(employeeRepoImpl,times(1)).save(employee);

    }

    @Test
    public void getAllDataTest()
    {
        when(employeeRepoImpl.findAll()).thenReturn(Stream.of(new Employee(121,"Aakash","Nashik",45652.25,new Date(),"rao@gmail.com"),
                new Employee(122,"Rushi","Pune",78456.2,new Date(),"rushi@gmail.com"),
                new Employee(123,"yash","Satara",25478.25,new Date(),"yash@gmail.com")).collect(Collectors.toList()));
        assertEquals(3,employeeDaoImpl.getAllData().size());

    }

    @Test
    public void updateDataTest()
    {
        Employee employee=new Employee(121,"Aakash","Nashik",45652.25,new Date(),"rao@gmail.com");

        employeeDaoImpl.saveData(employee);

        verify(employeeRepoImpl,times(1)).save(employee);

    }

    @Test
    public void deleteAllDataTest()
    {
        Employee employee=new Employee(121,"Aakash","Nashik",45652.25,new Date(),"rao@gmail.com");

        employeeDaoImpl.saveData(employee);

        verify(employeeRepoImpl,times(1)).deleteAll();

    }
}
