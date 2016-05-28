package utils;

public class MenuItemNotFoundByViewParamException extends MenuItemNotFoundException {

	private static final long serialVersionUID = -4370898320623410734L;

	public MenuItemNotFoundByViewParamException(String viewParam) {
		super("Menu item for view parameter <" + viewParam + "> not found!");
	}

}
