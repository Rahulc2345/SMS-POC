package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.DocumentDao;
import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;
import com.app.pojos.EmployeeDocument;
import com.app.pojos.FileBucket;

@Service("documentservice")
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentDao documentDao;
	@Autowired
	EmployeeDao dao;

	@Override
	public String saveDocument(FileBucket bucket, Employee employee) {
		
		EmployeeDocument document=new EmployeeDocument();
		MultipartFile multipartFile = bucket.getFile();
		
		document.setName(multipartFile.getOriginalFilename());
		document.setDescription(bucket.getDescriptor());
		document.setType(multipartFile.getContentType());
		document.setEmployee(employee);
		try {
			document.setContent(multipartFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//employee.addFile(document);
		return documentDao.saveDocument(document);
	}

	@Override
	public List<EmployeeDocument> documentList() {
		return documentDao.documentList();
	}

	/*@Override
	public List<EmployeeDocument> findDocumentListById(int id) {
		// TODO Auto-generated method stub
		//return documentDao.findDocumentListById(id);
		Employee e= dao.searchById(3);
		
		return e.getDocuments();
	}*/

	@Override
	public String deleteDocument(int docId) {	
		return documentDao.deleteDocument(docId);
	}

	@Override
	public EmployeeDocument findDocumentById(int id) {
		return documentDao.findDocumentById(id);
	}

	@Override
	public String deleteDocumentList(List<EmployeeDocument> doclist) {
		return documentDao.deleteDocumentList(doclist);
	}

	
	

}
