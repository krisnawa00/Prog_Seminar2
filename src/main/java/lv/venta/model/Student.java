package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name= "StudentTable")
@Entity
public class Student {
@Setter(value = AccessLevel.NONE)
@Id
@Column(name = "StId")
@GeneratedValue(strategy = GenerationType.AUTO)
		private int stId;
		
		@NotNull
		@Pattern(regexp = "[A-Z]{1}[a-z]{1,20}")
		private String name;
		
		@NotNull
		@Pattern(regexp = "[A-Z]{1}[a-z]{1,20}")
		private String surname;
		
	public Student(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
}
