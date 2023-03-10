package com.webapp.demo.TaskManagementDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.webapp.demo.TaskManagement.TaskManagement;

import jakarta.transaction.Transactional;

public interface TaskManagementDao extends JpaRepository<TaskManagement, Integer> {
	
	@Modifying
	@Transactional
	@Query(value = "update task set task_status='completed' where taskid=?1",nativeQuery = true)
	void updateStatus(String id);
	

	@Modifying
	@Transactional
	@Query(value = "delete from task where taskid=?1",nativeQuery = true)
	void deleteTask(String id);
	
	@Query(value = "select * from task where task_holder_name=?1",nativeQuery = true)
	List<TaskManagement> getTaskByHolder(String name);
	
	
}