package com.app.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*import com.app.json.EmployeeDeserializer;*/
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mysql.jdbc.Blob;

@Entity
@Table(name="Employee")
//@JsonDeserialize(using = EmployeeDeserializer.class)
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6234118805286025894L;
	private Integer id;
	private String name;
	private String task;
	private String assignedBy;
	private String status;
	private byte[] image;
	//@ColumnDefault(value="N/A")
	@JsonIgnore
	private List<EmployeeDocument> documents=new ArrayList<>();
	
	public Employee() {
		System.out.println("in emp def");
		String msg="No image";
		this.image=msg.getBytes();
	}
	
	public Employee(Integer id, String name, String task, String assignedBy, String status) {
		super();
		this.id = id;
		this.name = name;
		this.task = task;
		this.assignedBy = assignedBy;
		this.status = status;
		
	}
	
	public Employee(Integer id, String name, String task, String assignedBy, String status, List<EmployeeDocument> documents) {
		super();
		this.id = id;
		this.name = name;
		this.task = task;
		this.assignedBy = assignedBy;
		this.status = status;
		this.documents = documents;
	}

	
	

	public Employee(Integer id, String name, String task, String assignedBy, String status,
			byte[] image, List<EmployeeDocument> documents) {
		super();
		this.id = id;
		this.name = name;
		this.task = task;
		this.assignedBy = assignedBy;
		this.status = status;
		this.image = image;
		this.documents = documents;
	}

	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_seq")
	//@SequenceGenerator(name="id_seq",sequenceName="seq_gen", initialValue=1)
	/*@GeneratedValue(strategy= GenerationType.AUTO,generator="seq_id")
	@GenericGenerator(name = "seq_id",strategy = "native")*/
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@NotBlank
	@NotNull
	@Size(min=3, max=30) 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotBlank
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	@NotBlank
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	@NotBlank
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL)
	public List<EmployeeDocument> getDocuments() {
		return documents;
	}

	@Lob
	@Column(name="image")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public void setDocuments(List<EmployeeDocument> documents) {
		this.documents = documents;
	}

	/*--------------------------------------------------------------------------------------------------*/
	
	public void addFile(EmployeeDocument document){
		this.getDocuments().add(document);
		document.setEmployee(this);
	}
	

	public void removeFile(EmployeeDocument document){
		this.getDocuments().remove(document);
		document.setEmployee(null);
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", task=" + task + ", assignedBy=" + assignedBy + ", status="
				+ status + ", image=" + image + ", documents=" + documents + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignedBy == null) ? 0 : assignedBy.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((task == null) ? 0 : task.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (assignedBy == null) {
			if (other.assignedBy != null)
				return false;
		} else if (!assignedBy.equals(other.assignedBy))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}	
	
	
	
}
