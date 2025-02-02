package org.isetn.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classe {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codClass;
	private String nomClass;
	private int nbreEtud;

	
	
	@JsonIgnore
	@OneToMany(mappedBy="classe" , cascade = CascadeType.ALL)
	private List<Etudiant> etudiants; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "classe")
	private List<ClasseMatiere> classeMatieres;
	

}
