package com.suraj.spring.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suraj.spring.beans.Employee;
import com.suraj.spring.beans.Pancard;

public class AnnotationTest {

	public static void main(String[] args) {
		ApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("spring.xml");
			Employee employee = context.getBean("employee", Employee.class);
			System.out.println(employee.getEmployeeId()+"\t"+employee.getEmployeeName());
			Pancard pancard = employee.getPancard();
			if (pancard != null) {
				System.out.println(pancard.getPanHolderName()+"\t"+pancard.getPanNum());
			}
		}catch(BeansException e) {
			e.printStackTrace();
		}finally {
			((AbstractApplicationContext) context).close();
		}
	}
}
