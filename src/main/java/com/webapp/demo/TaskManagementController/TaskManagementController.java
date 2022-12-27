package com.webapp.demo.TaskManagementController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.demo.TaskManagementDao.TaskManagementDao;
import com.webapp.demo.TaskManagement.TaskManagement;

@RestController
public class TaskManagementController {
	
	@Autowired
	TaskManagementDao dao;
	
	@RequestMapping("/addTask")
	@ResponseBody
	public void addTask(@RequestParam String id,@RequestParam String name,@RequestParam String date,@RequestParam String taskName,@RequestParam String status,TaskManagement obj ) {
		
		obj.setTaskid(id);
		obj.setTaskHolderName(name);
		obj.setTaskDate(date);
		obj.setTaskName(taskName);
		obj.setTaskStatus(status);
		dao.save(obj);
		System.out.println("task added");
		
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public void addTask(@RequestParam String id) {
		
		dao.updateStatus(id);
		
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteTask(@RequestParam String id) {
		
		dao.deleteTask(id);
		
	}
	
	@RequestMapping("/allTask")
	@ResponseBody
	public List<TaskManagement> getAllTask(){
		
		return dao.findAll();
		
	}
	
	@RequestMapping("/getByHolder")
	@ResponseBody
	public List<TaskManagement> getTaskByHolderName(@RequestParam String name){
		
		return dao.getTaskByHolder(name);
		
	}
}