package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lv.venta.model.Professor;
import lv.venta.model.enums.Degree;
import lv.venta.repo.IProfessorRepo;
import lv.venta.service.ICRUDProfessorService;

@Service
public class CRUDProfessorServiceImpl implements ICRUDProfessorService{

	@Autowired
	private IProfessorRepo profRepo;
	
	@Override
	public ArrayList<Professor> retrieveAll() throws Exception {
		if(profRepo.count() == 0)
		{
			throw new Exception("Nav neviena profesora DB");
		}
		
		return (ArrayList<Professor>) profRepo.findAll();
	}

	@Override
	public Professor retrieveById(int id) throws Exception {
		if(id < 0)
		{
			throw new Exception("Id nevar būt negatīvs");
		}
		
		if(!profRepo.existsById(id))
		{
			throw new Exception("Professors ar tādu id neeksistē");
		}
		
		Professor retrievedProduct = profRepo.findById(id).get();
		return retrievedProduct;
	}

	@Override
	public void deleteById(int id) throws Exception {
		Professor professorForDelete = retrieveById(id);
		profRepo.delete(professorForDelete);
	
	}

	@Override
	public void create(String name, String surname, Degree degree) throws Exception {
		
		if(name == null || surname == null || degree == null) {
			throw new Exception ("Error");
		}
		
		if(profRepo.existsByNameAndSurnameAndDegree(name, surname, degree)) 
		{
			throw new Exception ("Jau eksiste");
		}
		else
		{
			Professor newProfessor = new Professor(name, surname, degree);
			profRepo.save(newProfessor);
		}
	}
	

	@Override
	public void updateById(int id, String name, String surname, Degree degree) throws Exception {
		if(name == null || surname == null || degree == null) {
			throw new Exception ("Error");
		}
		
		Professor retrievedProd = retrieveById(id);
		retrievedProd.setName(name);
		retrievedProd.setSurname(surname);
		retrievedProd.setDegree(degree);
		
	}

}