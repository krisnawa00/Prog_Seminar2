package lv.venta.service;


import lv.venta.model.Student;


public interface ICRUDStudentService extends ICRUDBase <Student> {
	
	public abstract void create(String name, String surname) throws Exception;
	
	
	public abstract void updateById (int stId, String name, String surname) throws Exception;
}

