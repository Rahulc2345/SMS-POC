package com.app.service;

import java.util.List;

import com.app.pojos.Employee;
import com.app.pojos.EmployeeDocument;
import com.app.pojos.FileBucket;

public interface DocumentService {

	String saveDocument(FileBucket bucket, Employee employee);
	
	List<EmployeeDocument> documentList();
	
	/*List<EmployeeDocument> findDocumentListById(int id);*/
	
	String deleteDocument(int docId);
	String deleteDocumentList(List<EmployeeDocument> doclist);
	EmployeeDocument findDocumentById(int id);
	
	
	
}
