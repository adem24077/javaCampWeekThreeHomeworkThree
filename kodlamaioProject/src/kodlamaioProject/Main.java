package kodlamaioProject;

import kodlamaioProject.business.CategoryManager;
import kodlamaioProject.business.CourseManager;
import kodlamaioProject.core.logging.DatabaseLogger;
import kodlamaioProject.core.logging.FileLogger;
import kodlamaioProject.core.logging.Logger;
import kodlamaioProject.core.logging.MailLogger;
import kodlamaioProject.dataAccess.HibernateCourseDao;
import kodlamaioProject.dataAccess.JdbcCourseDao;
import kodlamaioProject.entities.Category;
import kodlamaioProject.entities.Course;

public class Main {

	public static void main(String[] args) throws Exception {

		Course course1 = new Course(1, "Java Yazılım Geliştirme Kampı", 200);

		Course course2 = new Course(2, "C# Yazılım Geliştirme Kampı", 350);

		Course course3 = new Course(3, "Javascript Kampı", 270);

		Logger[] loggers = { new DatabaseLogger(), new FileLogger(), new MailLogger() };

		CourseManager courseManager = new CourseManager(new HibernateCourseDao(), loggers);

		courseManager.add(course1);
		courseManager.add(course2);
		courseManager.add(course3);

		Category category1 = new Category(1, "Full Stack");
		Category category2 = new Category(2, "Frontend");
		
		CategoryManager categoryManager = new CategoryManager(new JdbcCourseDao(), loggers);
		
		categoryManager.addCategory(category1);
		categoryManager.addCategory(category2);
	}

}
