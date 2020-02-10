package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.EmployeeDocument;

@Repository
public class DocumentDaoImpl  implements DocumentDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public String saveDocument(EmployeeDocument document) {
		 sf.getCurrentSession().save(document);
		 return "Document with Id " + document.getDocumentId()+ " is saved";
	}

	@Override
	public List<EmployeeDocument> documentList() {
		System.out.println("in documentList()");
		return sf.getCurrentSession().createCriteria(EmployeeDocument.class, "select d from EmployeeDocument d").list();
	}

	/*@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeDocument> findDocumentListById(int id) {
		System.out.println("in findDocumentListById()");
		return null;
	}*/


	@Override
	public EmployeeDocument findDocumentById(int id) {
		EmployeeDocument document=(EmployeeDocument) sf.getCurrentSession().get(EmployeeDocument.class, id);
		return document;
	}

	
	@Override
	public String deleteDocument(int docId) {
		EmployeeDocument document=findDocumentById(docId);
		sf.getCurrentSession().delete(document);
		return "Document deleted";
	}

	@Override
	public String deleteDocumentList(List<EmployeeDocument> doclist) {
		
		for(EmployeeDocument doc:doclist){
			//doc.setEmployee(null);
			deleteDocument(doc.getDocumentId());
		}
		return "All your documents have been deleted";
	}
	
	
	
}
