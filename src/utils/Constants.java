package utils;


public abstract class Constants {

	/**
	 * Name of the view parameter.
	 */
	public static final String VIEW_PARAMETER_NAME__VIEW = "view";
	
	/**
	 * Name of the view parameter.
	 */
	public static final String VIEW_PARAMETER_NAME__CATEGORY = "category";
	
	/**
	 * Name of the view parameter.
	 */
	public static final String VIEW_PARAMETER_NAME__PAGE = "page";
	
	/**
	 * Name of the view parameter.
	 */
	public static final String VIEW_PARAMETER_NAME__PRODUCT_ID = "id";
	
	public static final String ATTRIBUTE_SELECTED_ITEM = "selectedItem";
	
	public static final String UI_STYLE_HEADER_MENU_SELECTED = "color:darkorange;font-weight:bold;";
	
	public static final String UI_STYLE_HEADER_MENU = "color:darkgrey;font-weight:lighter";
	
	public static final String UI_CLASS_CATEGORY_SELECTED = "category_item_selected";
	
	public static final String UI_CLASS_CATEGORY = "category_item";
	
	/**
	 * If the page will be called without parameter 'viewId' (vpView=null), then the default value for the parameter will be used
	 */
	@Deprecated
	public static final String DEFAULT_VIEW_PARAM_VALUE__VIEW_FORMAT = "{0}View";
	
}
