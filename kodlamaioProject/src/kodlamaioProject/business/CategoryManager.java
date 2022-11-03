package kodlamaioProject.business;

import java.util.ArrayList;
import java.util.List;

import kodlamaioProject.core.logging.Logger;
import kodlamaioProject.dataAccess.CategoryDao;
import kodlamaioProject.entities.Category;

public class CategoryManager {

	private CategoryDao CategoryDao;
	private Logger[] loggers;

	public CategoryManager(CategoryDao categoryDao, Logger[] loggers) {
		this.CategoryDao = categoryDao;
		this.loggers = loggers;
	}

	List<Category> categories = new ArrayList<Category>();

	public void addCategory(Category category) throws Exception {
		for (Category c : categories) {
			if (c.getCategoryName() == category.getCategoryName()) {
				throw new Exception("Var olan kategori türü eklenemez.");
			}
		}

		categories.add(category);
		CategoryDao.addCategory(category);

		for (Logger logger : loggers) {
			logger.log(category.getCategoryName());
		}
	}

}
