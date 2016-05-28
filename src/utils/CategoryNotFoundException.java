package utils;

public class CategoryNotFoundException extends Exception {

	private static final long serialVersionUID = -2538820766821509690L;

	public CategoryNotFoundException(int id) {
		super("Category with ID <" + id + "> not found!");
	}

}
