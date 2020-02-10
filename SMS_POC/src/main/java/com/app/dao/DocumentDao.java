package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.EmployeeDocument;

public interface DocumentDao  {

	String saveDocument(EmployeeDocument document);
	List<EmployeeDocument> documentList();
	/*List<EmployeeDocument> findDocumentListById(int id);*/
	String deleteDocument(int docId);
	String deleteDocumentList(List<EmployeeDocument> doclist);
	
	EmployeeDocument findDocumentById(int id);
}
