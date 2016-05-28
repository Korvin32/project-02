package utils;

public class MenuItemNotFoundByViewParamException extends MenuItemNotFoundException {

	private static final long serialVersionUID = 1L;

	public MenuItemNotFoundByViewParamException(String viewParam) {
		super("Menu item for view parameter <" + viewParam + "> not found!");
	}

}
