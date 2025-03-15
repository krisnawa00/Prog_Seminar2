package lv.venta;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.model.enums.Degree;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;



@SpringBootApplication
public class Seminar2Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner testModelLayer(IStudentRepo studRepo,
			IProfessorRepo profRepo, IGradeRepo grRep, ICourseRepo courseRepo)
	{
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
			Student st1 = new Student ("Pauls", "Staigataijs");
			Student st2 = new Student ("Vins", "Dizelis");
			Student st3 = new Student ("Janis", "Cena");
			studRepo.save(st1);
			studRepo.save(st2);
			studRepo.save(st3);
			
			Professor p1 = new Professor("Karina", "Skirmate", Degree.magistra);
			Professor p2 = new Professor("Karlis", "Immers", Degree.magistra);
			Professor p3 = new Professor("Vija","Vagale",Degree.doktora);
			
		    profRepo.save(p1);
		    profRepo.save(p2);
		    profRepo.save(p3);
			
		    
		    Course c1 = new Course("Programmaturas Inzenierija I",6,p1);
		    Course c2 = new Course("Datus Bazes II",3,p3);
		    Course c3 = new Course("Web tehnologijas",6,p2);
		    
		    courseRepo.saveAll(Arrays.asList(c1,c2,c3));
		    
			Grade g1 = new Grade(6, st1, c1);	
			Grade g2 = new Grade(3, st2, c2);
			Grade g3 = new Grade(8, st3, c3);
			Grade g4 = new Grade(4, st1, c1);
			Grade g5 = new Grade(7, st1, c2);
			Grade g6 = new Grade(10, st1, c3);
			Grade g7 = new Grade(1, st3, c1);
			
			grRep.saveAll(Arrays.asList(g1,g2,g3,g4,g5,g6,g7));
			}
		};
	}

}
