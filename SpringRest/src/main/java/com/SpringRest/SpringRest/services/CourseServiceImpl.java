package com.SpringRest.SpringRest.services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringRest.SpringRest.dao.CourseDao;
import com.SpringRest.SpringRest.entities.Course;


@Service
public class CourseServiceImpl implements CourseService {

//	List<Course> li;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		li=new ArrayList<>();
//		li.add(new Course(145,"java core course","this course contains basics of java"));
//		li.add(new Course(4343,"spring boot course","creating rest api using spring boot"));
//		li.add(new Course(434,"springp boot course","creating rest api using spring boot"));
		
		
		
	}
	
	@Override
	public List<Course> getCourses() {


		
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		
//		Course c=null;
//		for(Course course:li) {
//			if(course.getId()==courseId) {
//				c=course;
//				break;
//			}
//		}
		
		
		return courseDao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		li.add(course);
		
		courseDao.save(course);
		return course;
	}
	
	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
//		li.forEach(e -> {
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		
		courseDao.save(course);
		
		return course;
	}
	
	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
//		li=this.li.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity=courseDao.getOne(parseLong);
		courseDao.delete(entity);
	}
	
}
