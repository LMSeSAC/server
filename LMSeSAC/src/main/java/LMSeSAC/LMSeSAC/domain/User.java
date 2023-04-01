package LMSeSAC.LMSeSAC.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import LMSeSAC.LMSeSAC.enums.UserRoleEnum;
import LMSeSAC.LMSeSAC.enums.UserTypeEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String userid;
	@Column(length = 255, nullable = false)
	private String password;
	@Column(length = 20, nullable = false)
	private String name;
	@Column(length = 100, nullable = false)
	private String email;
	@Column(length = 13, nullable = false)
	private String phone;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserRoleEnum role;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private UserTypeEnum type;
	@CreationTimestamp
	private Timestamp createAt;
	@Column(length = 1)
	@ColumnDefault("'F'")
	private String isAdmin;

	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonManagedReference
	private List<CourseUser> courseUsers;
}