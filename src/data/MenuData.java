package data;

public class MenuData {
	
	/** The order of the Item of Menu */
	private int order;
	
	/** Indicates if the Item of Menu will be rendered */
	private boolean rendered;
	
	/** Describes the name of Menu*/
	private String item;
	
	/** JSF-Action of the Item of Menu*/
	private String action;
	
	/** Real File-Name (Source) of the view to be shown for the selected Item of Menu*/
	private String xhtmlViewName;
	
	/** Request parameter (JSF viewParam) of the Item of Menu */
	private String viewParam;
	
	/** The Content-Value of the selected Item of Menu */
	private String viewContent;
	
	public MenuData(int order, boolean rendered, String item, String action, String xhtmlViewName, String viewParam, String viewContent) {
		this.order = order;
		this.rendered = rendered;
		this.item = item;
		this.action = action;
		this.xhtmlViewName = xhtmlViewName;
		this.viewParam = viewParam;
		this.viewContent = viewContent;
	}

	/** Returns the order of the Item of Menu */
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	/** Indicates if the Item of Menu will be rendered */
	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	/** Returns the name of Menu*/
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String action() {
		return action + "?faces-redirect=true";
	}

	/** Returns JSF-Action of the Item of Menu*/
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	/** Returns real .xhtml File-Name (Source) of the view to be shown for the selected Item of Menu*/
	public String getXhtmlViewName() {
		return xhtmlViewName;
	}

	public void setXhtmlViewName(String xhtmlViewName) {
		this.xhtmlViewName = xhtmlViewName;
	}

	/** Returns the Content-Value of the selected Item of Menu */
	public String getViewContent() {
		return viewContent;
	}

	public void setViewContent(String viewContent) {
		this.viewContent = viewContent;
	}

	/** Returns Request-Parameter from Browser's Command Line (JSF viewParam) of the Item of Menu */
	public String getViewParam() {
		return viewParam;
	}

	public void setViewParam(String viewParam) {
		this.viewParam = viewParam;
	}

	public boolean isHasViewParameter() {
		return viewParam == null ? false : true;
	}
	
	@Override
	public String toString() {
		return "'#" + order + ".[Item=" + item + "|action=" + action + "|xhtmlViewName=" + xhtmlViewName + "|viewParam=" + viewParam + "]'";
	}

	
}
