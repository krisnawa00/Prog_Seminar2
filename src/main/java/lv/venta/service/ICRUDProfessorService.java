package lv.venta.service;

import lv.venta.model.Professor;
import lv.venta.model.enums.Degree;

public interface ICRUDProfessorService extends ICRUDBase <Professor> {
	
	public abstract void create(String name, String surname, Degree degree) throws Exception;
	
	
	public abstract void updateById (int id, String name, String surname, Degree degree) throws Exception;
}
