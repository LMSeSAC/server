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
@Table(name = "institution")
public class Institution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String location;
	@Column(length = 20, nullable = false)
	private String code;

	@OneToMany(mappedBy = "institution", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonManagedReference
	private List<Course> courses;
}