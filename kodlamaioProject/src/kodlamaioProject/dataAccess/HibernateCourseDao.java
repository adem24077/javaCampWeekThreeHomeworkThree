package kodlamaioProject.dataAccess;

import kodlamaioProject.entities.Category;
import kodlamaioProject.entities.Course;

public class HibernateCourseDao implements CourseDao, CategoryDao {

	public void add(Course course) {
		System.out.println(course.getCourseName() + " kursu Hibernate ile veritabanına eklendi.");
	}

	public void addCategory(Category category) {
		System.out.println(category.getCategoryName() + " kategorisi Hibernate ile veri tabanına eklendi.");

	}

}
