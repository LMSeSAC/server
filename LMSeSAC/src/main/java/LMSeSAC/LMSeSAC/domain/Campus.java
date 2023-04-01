package LMSeSAC.LMSeSAC.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "campus")
public class Campus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 20, nullable = false)
	private String campus;
	@Column(length = 100, nullable = false)
	private String location;

	@OneToMany(mappedBy = "campus", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonManagedReference
	private List<Course> courses;
}