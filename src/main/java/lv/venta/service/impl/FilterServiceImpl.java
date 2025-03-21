package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IFilterService;

@Service
public class FilterServiceImpl implements IFilterService {

	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo grRepo;
	
	@Autowired
	private ICourseRepo courRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentId(int id) throws Exception {
		if(id < 0 ) {
			
			throw new Exception ("ID NAV");
			
		}
		
		if(!studRepo.existsById(id)){
			throw new Exception ("Students ar id:" + id + "neeksiste");
		}
		
		ArrayList<Grade> result = grRepo.findByStudentStId(id); 
		
		if(result.isEmpty()) {
			throw new Exception("Students ar id:" + id + "nav piesaista ne viena atzime");
		}
		
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception {
		if(id < 0 ) {
			
			throw new Exception ("ID NAV");
			
		}
		
		if(!courRepo.existsById(id)){
			throw new Exception ("Students ar id:" + id + "neeksiste");
		}
		
		ArrayList<Course> result = courRepo.findByGradesStudentStID(id);
		
		if(result.isEmpty()) {
			throw new Exception("Students ar id:" + id + "nav piesaista ne viens kurss");
		}
		return result;
		
	}

	@Override
	public ArrayList<Course> selectGradesByProfessorId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateAVGGradeInCourseId(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
