package lv.venta.service;

import lv.venta.model.Course;
import lv.venta.model.Professor;


public interface ICRUDCourseService extends ICRUDBase <Course> {
	
	public abstract void create(String title, int creditpoints, Professor professor) throws Exception;
	
	
	public abstract void updateById (int id, String title, int creditpoints, Professor professor) throws Exception;
}
