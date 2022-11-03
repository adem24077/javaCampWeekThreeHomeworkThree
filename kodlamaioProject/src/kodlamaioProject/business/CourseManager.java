package kodlamaioProject.business;

import java.util.ArrayList;
import java.util.List;

import kodlamaioProject.core.logging.Logger;
import kodlamaioProject.dataAccess.CourseDao;
import kodlamaioProject.dataAccess.HibernateCourseDao;
import kodlamaioProject.dataAccess.JdbcCourseDao;
import kodlamaioProject.entities.Course;

public class CourseManager {
	private CourseDao courseDao;
	private Logger[] loggers;

	public CourseManager(CourseDao courseDao, Logger[] loggers) {
		this.courseDao = courseDao;
		this.loggers = loggers;
	}

	List<Course> courses = new ArrayList<Course>();

	public void add(Course course) throws Exception {
		if (course.getCoursePrice() < 0) {
			throw new Exception("Kurs fiyatı sıfırdan küçük olamaz.");
		}
		for(Course c : courses) {
			if(c.getCourseName() == course.getCourseName()) {
				throw new Exception("Var olan kursu ekleyemezsiniz.");
			}
		}
		
		courses.add(course);
		courseDao.add(course);

		for (Logger logger : loggers) {
			logger.log(course.getCourseName());
		}

	}

}