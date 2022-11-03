package kodlamaioProject.dataAccess;

import kodlamaioProject.entities.Category;
import kodlamaioProject.entities.Course;

public class JdbcCourseDao implements CourseDao, CategoryDao {

	public void add(Course course) {
		System.out.println(course.getCourseName() + "kursu JDBC ile veritabanına eklendi.");
	}

	@Override
	public void addCategory(Category category) {
		System.out.println(category.getCategoryName() + "kursu JDBC ile veritabanına eklendi ");

	}

}
