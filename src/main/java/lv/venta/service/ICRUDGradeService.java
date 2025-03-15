package lv.venta.service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Student;

public interface ICRUDGradeService extends ICRUDBase <Grade> {
	
	public abstract void create(int grvalue, Student student, Course course) throws Exception;
	
	
	public abstract void updateById (int gId, int grvalue, Student student, Course course) throws Exception;
}
