package com.persons.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.persons.model.Department;
import com.persons.model.Files;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.common.bean.FileUpload;
import com.common.bean.PagerModel;
import com.googlecode.jsonplugin.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.persons.model.Rasmessage;
import com.persons.service.DepartmentService;
import com.persons.service.FileService;
import com.persons.service.RasmessageService;
import com.security.model.User;
import com.security.service.UserService;

@Controller
@Scope("prototype")
public class FileAction extends ActionSupport{
	private Logger logger=LoggerFactory.getLogger(RasmessageAction.class);
	private RasmessageService RasmessageService;
	private FileService fileService;
	private Rasmessage rasmessage=null;
	private Files files=null;
	private PagerModel pm;
	private Integer userId;
	private Integer fileId;
	private String paname; 
	private UserService userService;
	private User user=null;
	private User rperString;//当前用户
	
	private File uploadFile;
	private String uploadFileFileName;
	private String uploadFileContentType;
	private String  meString;
	
	private List<Department> departmentList;
	private DepartmentService departmentService;
	
	private String filesContent;
	
	
	public String getFilesContent() {
		return filesContent;
	}
	public void setFilesContent(String filesContent) {
		this.filesContent = filesContent;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	@Resource
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public List<Department> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	//@JSON(serialize=false)
	public Integer getFileId() {
		return fileId;
	}

	//@JSON(serialize=false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	@JSON(serialize=false)
	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@JSON(serialize=false)
	public RasmessageService getRasmessageService() {
		return RasmessageService;
	}

	@Resource
	public void setRasmessageService(RasmessageService rasmessageService) {
		RasmessageService = rasmessageService;
	}
	
	@JSON(serialize=false)
	public FileService getFileService() {
		return fileService;
	}

	@Resource
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}	
	
	
	@JSON(serialize=false)
	public UserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Rasmessage getRasmessage() {
		return rasmessage;
	}

	public void setRasmessage(Rasmessage rasmessage) {
		this.rasmessage = rasmessage;
	}


	public PagerModel getPm() {
		return pm;
	}

	public void setPm(PagerModel pm) {
		this.pm = pm;
	}
	
	
	

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public String getPaname() {
		return paname;
	}

	public void setPaname(String paname) {
		this.paname = paname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getRperString() {
		return rperString;
	}

	public void setRperString(User rperString) {
		this.rperString = rperString;
	}
	
	//@JSON(serialize=false)
	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}

	
	public String getMeString() {
		return meString;
	}

	public void setMeString(String meString) {
		this.meString = meString;
	}

	/**
	 * 获取当前用户
	 * @return
	 */
	private User users(){
		rperString=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return rperString;
	}

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list()  {
		

		//pm=RasmessageService.getPagerDesc(Rasmessage.class,"where o.rper.id="+this.users().getId()+" and o.fla3='0' ");
		pm=fileService.getPagerDesc(Files.class);
		//RasmessageService.getp
		departmentList = departmentService.findByHql("from Department ");
		return "list";
	}

	/**
	 * 模糊查询（对收信人 ，标题）
	 * @return
	 */
	public String search()
	{
		Map<String,String> like=new HashMap<String,String>();

//		if(null==(rasmessage.getTitle())&&null!=(rasmessage.getSper().getUsername())){
//		   like.put("sper.name", rasmessage.getSper().getUsername());
//		   like.put("rper.name", this.users().getName());
//		   like.put("fla3", "0");
//		}
//		else if(null!=(rasmessage.getTitle())&&null==(rasmessage.getSper().getUsername())){
//		   like.put("title",  rasmessage.getTitle());
//		   like.put("rper.name", this.users().getName());
//		   like.put("fla3", "0");
//		}else {
			
			like.put("sper.employee.empName", files.getSper().getEmployee().getEmpName());
			like.put("title",  files.getTitle());
			like.put("sper.employee.department.dptName", files.getSper().getEmployee().getDepartment().getDptName());
			//like.put("rper.employee.empName", this.users().getEmployee().getEmpName());
			//like.put("fla3", "0");
		//}
				
		pm=fileService.fuzzyQuery(Files.class,like);
		departmentList = departmentService.findByHql("from Department ");
		return "list";
		
	}
	
	
	
	public String show()
	{

		rasmessage=RasmessageService.findById(Rasmessage.class, fileId);
		rasmessage.setRasstatus("1");
		RasmessageService.update(rasmessage);
	    return "show";
	}
	
	/**
	 * 删除
	 * @return
	 */
	
	public String del()
	{
		//files=fileService.findById(Files.class, fileId);
//		rasmessage.setFla3("1");
		//fileService.update(files);
		//RasmessageService.deleteById(Rasmessage.class, rasmessageId);
		fileService.deleteById(Files.class, fileId);
		logger.warn("del empId="+fileId);
		return "pub_del_success";
	}
	/**
	 * 添加
	 * @return
	 */
	public String add()
	{  
	if(uploadFile!=null){
	
			try {
			//rasmessage.setRper(userService.findById(User.class,userId));
			files.setSper(this.users());
			files.setFileType(uploadFileContentType);
			if(FileUpload.upload(uploadFile, uploadFileFileName, uploadFileContentType)==null){
				files.setTitle("0"); 
			}else{
				System.out.println("上传成功");
				files.setAccessories(FileUpload.upload(uploadFile, uploadFileFileName, uploadFileContentType));
				files.setTitle(uploadFileFileName); 
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
//		rasmessage.setRastime(new Date());
//		rasmessage.setRasstatus("0");
//		rasmessage.setFla2("0");
//		rasmessage.setFla3("0");
//		RasmessageService.saveAndRefresh(rasmessage);
		files.setRastime(new Date());
		fileService.saveAndRefresh(files);
		User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.warn("user id="+currentUser.getId()+" add id="+files.getId());//日志记录
		
		
	}
		return "pub_add_success";
	}

	
	
	
	
	
/*===================================input============================================================*/
	
	public String addInput(){
		return "addInput";
	}
	public String replay()
	{
      
		user=userService.findById(User.class,userId);
		//user=this.users();
		return "replay";
	}
	public String selectInput(){
		
		pm=userService.getPagerDesc(User.class);
		return "selectInput";
	}


	/**
	 * 删除
	 * @return
	 */
	
	public String sendedDel()
	{
		files= fileService.findById(Files.class, fileId);
//		rasmessage.setFla2("1");
		fileService.update(files);
		User currentUser =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.warn("user id="+currentUser.getId()+" del id="+files.getId());//日志记录
		
		return "pub_del_success";
	}	
	/**
	 * 模糊查询（对收信人 ，标题）
	 * @return
	 */
	public String sendedSearch()
	{
		Map<String,String> like=new HashMap<String,String>();


			like.put("rper.employee.empName", rasmessage.getRper().getEmployee().getEmpName());
			like.put("title",  rasmessage.getTitle());
			like.put("sper.employee.empName", this.users().getEmployee().getEmpName());
			like.put("fla2", "0");
		
				
		pm=RasmessageService.fuzzyQuery(Rasmessage.class,like);
		
		return "sList";
		
	}	

public  String editInput() throws UnsupportedEncodingException{
	//System.out.println("test"+fileId);
	
	files=fileService.findById(Files.class, fileId);	
	filesContent=FileUpload.readTxtFile(ServletActionContext.getServletContext().getRealPath(
			files.getAccessories()));
	

	return "editInput";
}
	
public String update() throws IOException{	
	String content=files.getContent();
	files=fileService.findById(Files.class, fileId);
	files.setContent(content);
	
	FileUpload.writeTxtFile(filesContent,ServletActionContext.getServletContext().getRealPath(
			files.getAccessories()));
	fileService.update(files);
	//System.out.println(filesContent);
	return "pub_update_success";
}
	
public String isCkeck(){
	return "check";

}


public String checkFanhui(){

	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	meString=RasmessageService.getMessg(user.getId());
	
	return SUCCESS;
	
}
}
