package utils;

public class MenuItemNotFoundByXhtmlViewNameException extends MenuItemNotFoundException {

	private static final long serialVersionUID = 1L;

	public MenuItemNotFoundByXhtmlViewNameException(String xhtmlViewName) {
		super("Menu item with XHTML name <" + xhtmlViewName + "> and without view parameter (view parameter = null) not found!");
	}
	
}
