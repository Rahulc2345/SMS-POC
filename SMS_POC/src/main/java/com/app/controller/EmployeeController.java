package com.app.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.exception.EmployeeNotFoundException;
import com.app.json.ObjectMapperTest;
import com.app.pojos.Employee;
import com.app.pojos.EmployeeDocument;
import com.app.pojos.FileBucket;
import com.app.pojos.Image;
import com.app.service.DocumentService;
import com.app.service.EmployeeService;
import com.app.validator.FileValidator;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private DocumentService documentService;
	 
	@Autowired 
	 FileValidator fileValidator;
	     
	    @InitBinder("fileBucket")
	    protected void initBinder(WebDataBinder binder) {
	       binder.setValidator(fileValidator);
	    }

	ObjectMapperTest test=new ObjectMapperTest();
	
	@GetMapping("/search")
	public String getEmp(){
		System.out.println("in search");
		return "/employeeView/home";
	}
	
	@PostMapping("/search")
	public String getEmployeeById(@RequestParam("id") int id, Model map, HttpSession hs, HttpServletRequest req) 
							throws EmployeeNotFoundException, UnsupportedEncodingException{
		
	/*	String uri =req.getRequestURI();
		System.out.println(uri);
		hs.setAttribute("searchURI", uri);
		*/
		String s=" Invalid Employee Id";
		boolean show=false;
		Employee e=null;
		e=service.searchById(id);
		System.out.println(e);
		if(e==null){
			System.out.println("before empnotfound");
			throw new EmployeeNotFoundException(id);
			//throw new NullPointerException();
		}
		
		/*try {																	// Adding single employee in json file
			test.putEmployeeInfo(e);
		} catch (Exception e1) {
			e1.printStackTrace();
		}*/
		
		/*e=service.searchById(id);
		if(e==null){
			map.addAttribute("emp", false);
		}
		else{
			map.addAttribute("emp", true);
		}*/
		
		byte[] arr=Base64.encodeBase64(e.getImage());
		String img=new String(arr, "UTF-8");

		map.addAttribute("employee", e);
		map.addAttribute("image", img);
		map.addAttribute("show", true);
		//map.addAttribute("condition", true);
		System.out.println(e);
		return "/employeeView/home";
	}
	
	/*
	 * @ExceptionHandler(EmployeeNotFoundException.class)                   // working
	public ModelAndView handleEmployeeNotFoundException(Exception ex, HttpServletRequest req){
		ModelAndView model=new ModelAndView();
		
		model.addObject("exception", ex);
		model.addObject("url", req.getRequestURL());
		model.setViewName("employeeView/error");
		return model;	
	}*/
	
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam("id") String id, Model map, RedirectAttributes flashMap){
		String status="Select an Employee first";
		//System.out.println(id);
		if(id==""){
			flashMap.addFlashAttribute("status", status);
			return "redirect:/employee/search";
		}
		
		int sid=Integer.parseInt(id);	
		Employee e=service.searchById(sid);
		map.addAttribute("employee_update", e);
		return "/employeeView/update";
	}
	
	@PostMapping("/update")
	public String processUpdateForm(Employee e, RedirectAttributes flashMap){
		System.out.println("in process update");
		flashMap.addFlashAttribute("status", service.editEmployee(e));
		return "redirect:/employee/search";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam String id, RedirectAttributes flashMap){
		//System.out.println("in process update");
		String status="Select an Employee first";
		
		if(id==""){
			flashMap.addFlashAttribute("status", status);
			return "redirect:/employee/search";
		}
		
		int sid=Integer.parseInt(id);	
		flashMap.addFlashAttribute("status", service.deleteEmployee(sid));
		return "redirect:/employee/search";
	}
	
	
	@GetMapping("/add")
	public String showEmployee(Employee e, Model model){
		model.addAttribute("employee", e);
		return "/employeeView/register";
	}
	
	@PostMapping("/add")
	public String processEmployee(Employee e, RedirectAttributes flashMap ,@Valid Employee employee, BindingResult result/*, @RequestParam("image") MultipartFile muFile*/) throws IOException{
		System.out.println("in post add()");
		String s=" Name or Task or Assigned By cannot be written as Null";
	//	System.out.println(e.getImage());
		 
		if(result.hasErrors()){
			return "/employeeView/register";
		}
		
		if(e.getName().replaceAll("[^a-zA-Z0-9]", "").trim().equalsIgnoreCase("null") ||
					e.getTask().replaceAll("[^a-zA-Z0-9]", "").trim().equalsIgnoreCase("null") || 
						e.getAssignedBy().replaceAll("[^a-zA-Z0-9]", "").trim().equalsIgnoreCase("null")){
			
			flashMap.addFlashAttribute("message", s);
			return "redirect:/employee/add";
		}
		//e.setImage(muFile.getBytes());
		
		Employee emp= service.addEmployee(e);
		System.out.println("here");
		String status="Employee with Id "+ emp.getId() + " is registered";
		flashMap.addFlashAttribute("status", status);
		
		
		List<Employee> employeelist=service.employeeList();
		try {                                                 // write employee into file in json format
			test.appendEmployeeInFile(employeelist);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//test.readJsonArray();                                      // read employee by converting from json to a java object
		
			
		return "redirect:/employee/search";
	}
	/*------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	@GetMapping("/about")
	public String about(){	
		return "/employeeView/about";
	}
	
	@GetMapping("/contact")
	public String contact(){
		return "/employeeView/contact";
	}
	
	
	@GetMapping("/viewlist")
	public String getEmployeeList(Model map, RedirectAttributes flashMap) throws UnsupportedEncodingException{
		List<Employee> emplist= service.employeeList();
		List<String> imageList=new ArrayList<>();
		
		for(Employee e:emplist){
			byte[] img=Base64.encodeBase64(e.getImage());
			imageList.add(new String(img, "UTF-8"));
			//flashMap.addFlashAttribute("imageId", arg1)
			map.addAttribute("image", imageList);
		}
		
		map.addAttribute("list", emplist);
		return "/employeeView/list";
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	
	
	
	@GetMapping("/upload")
	public String getUploadDocument(@RequestParam("id") String id, RedirectAttributes flashMap, Model model){
	
		//System.out.println("getUploadDocument()");
		if(id==""){
			String status="Please select an Employee first";
			flashMap.addFlashAttribute("status", status);
			return "redirect:/employee/search";
		}
		
		int eid=Integer.parseInt(id);
		
		FileBucket fileBucket=new FileBucket();
		model.addAttribute("fileBucket", fileBucket);
		
		Employee e=service.searchById(eid);
		model.addAttribute("employee", e);
		
		System.out.println(e.getDocuments());
		model.addAttribute("documents", e.getDocuments());
	
		
		return "/employeeView/upload";
	}
	
	@PostMapping("/upload")
	public String processUploadDocument(FileBucket fileBucket, @RequestParam("id") String id, Model model, RedirectAttributes flashMap){
		//System.out.println("putUploadDocument()");
		int eid=Integer.parseInt(id);
		Employee employee=service.searchById(eid);
		model.addAttribute("status", documentService.saveDocument(fileBucket, employee));
		return "redirect:/employee/upload?id="+eid;
	}
	
	@GetMapping("/download/{id}/{documentId}")
	public String downloadDocument(@PathVariable("id") int id, @PathVariable("documentId") int documentId, HttpServletResponse resp, Model model, RedirectAttributes fmap) throws IOException{
			//System.out.println("here");
			EmployeeDocument document=documentService.findDocumentById(documentId);
			
			/*System.out.println(document);
			System.out.println("here 2");
			System.out.println(document.getName());
			System.out.println("here 3");*/
			
			resp.setContentType(document.getType());
	        resp.setContentLength(document.getContent().length);
	        resp.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
	        try {
				FileCopyUtils.copy(document.getContent(), resp.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
	       
	        String status="File downloaded successfully";
	        fmap.addFlashAttribute("status", status);
	        
	        return "redirect:/employee/upload?id="+id;
	}
	
	@GetMapping("/delete/{id}/{documentId}")
	public String deleteDocument(@PathVariable("id") int id, @PathVariable("documentId") int documentId, RedirectAttributes fmap){
		//System.out.println("delete()");
		EmployeeDocument document=documentService.findDocumentById(documentId);
		Employee e=service.searchById(id);
		
		fmap.addAttribute("status", documentService.deleteDocument(documentId));
		return "redirect:/employee/upload?id="+id;
	}
	
	@GetMapping("/deleteAll/{id}")
	public String deleteAllDocument(@PathVariable("id") int id, RedirectAttributes fmap){
		//System.out.println("deleteAll()");
		Employee e=service.searchById(id);
		fmap.addAttribute("status", documentService.deleteDocumentList(e.getDocuments()));
		return "redirect:/employee/upload?id="+id;
	}
	
	@GetMapping("/image")
	public String insertImage(@RequestParam("id") String id, Model model, RedirectAttributes flashMap,  HttpServletRequest req){
		String uri=req.getRequestURI();
		System.out.println(uri);
		
		if(id==""){
			String status="Please select an Employee first";
			flashMap.addFlashAttribute("status", status);
			return "redirect:/employee/search";
		}
		
		Image img=new Image();
		model.addAttribute("image", img);
		return "/employeeView/imageFile";
	}
	
	@PostMapping("/image")
	public String processImage(@RequestParam("id") String id, Image image, RedirectAttributes fMap,  HttpServletRequest req, Model map, HttpSession hs) throws IOException{
		int eid=Integer.parseInt(id);
		MultipartFile multipartFile=image.getiFile();
		
		Employee e=service.searchById(eid);
		e.setImage(multipartFile.getBytes());
		service.addEmployee(e);
		
		Employee emp=service.searchById(eid);
		fMap.addFlashAttribute("uploadStatus", "Image Uploaded Successfully");
		List<Employee> employeelist=service.employeeList();
		
		try {                                                 // write employee into file in json format
			test.appendEmployeeInFile(employeelist);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return "redirect:/employee/image?id="+eid;
		
	}
	
}
