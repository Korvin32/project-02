package admin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.model.SelectItem;

import data.MenuData;
import utils.DataProvider;

//@javax.faces.bean.ManagedBean
//@javax.faces.bean.SessionScoped
@javax.inject.Named
@javax.enterprise.context.SessionScoped
public class AdminBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** The order of the Item of Menu */
	private int order;
	
	/** Indicates if the Item of Menu will be rendered */
	private boolean rendered = true;
	
	/** Describes the name of Menu*/
	private String item;
	
	/** JSF-Action of the Item of Menu*/
	private String action;
	
	/** The Content-Value of the selected Item of Menu */
	private String viewContent;
	
	private MenuData selectedItem;
	
	private int itemsPerLine = 3;
	
	public AdminBean() {
		order = DataProvider.getDefaultOrderMenuItem();
	}

	public List<MenuData> getMenuDataList() {
		return DataProvider.findMenuDatas();
	}

	public void addMenuItem() {
		String xhtmlViewName = "./" + action + ".xhtml";
		String viewParam = item.toLowerCase();
		MenuData menuItem = new MenuData(order, rendered, item, action, xhtmlViewName, viewParam, viewContent);
		DataProvider.addMenuData(menuItem);
		order = DataProvider.getDefaultOrderMenuItem();
		item = null;
		action = null;
		viewContent = null;
	}
	
	public List<SelectItem> getActions() {
		List<SelectItem> actions = new ArrayList<SelectItem>();
		Set<String> actionsSet = new HashSet<String>();
		for (MenuData menuItem : DataProvider.findMenuDatas()) {
			actionsSet.add(menuItem.getAction());
		}
		for (String action : actionsSet) {
			actions.add(new SelectItem(action));
		}
		return actions;
	}
	
	public void removeMenuItem() {
		DataProvider.deleteMenuItem(selectedItem);
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getViewContent() {
		return viewContent;
	}

	public void setViewContent(String viewContent) {
		this.viewContent = viewContent;
	}
	
	public MenuData getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(MenuData selectedItem) {
		this.selectedItem = selectedItem;
	}

	public int getItemsPerLine() {
		return itemsPerLine;
	}

	public void setItemsPerLine(int itemsPerLine) {
		this.itemsPerLine = itemsPerLine;
	}

}
