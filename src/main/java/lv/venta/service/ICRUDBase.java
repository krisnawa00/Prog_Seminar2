package lv.venta.service;

import java.util.ArrayList;


public interface ICRUDBase <Ttype> {

	
	public abstract ArrayList<Ttype> retrieveAll() throws Exception;
	
	
	public abstract Ttype retrieveById(int id) throws Exception;
	
	
	public abstract void deleteById(int id) throws Exception;
	
}
