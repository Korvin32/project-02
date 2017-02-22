package data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zagorod
 *
 */
public class CategoryData {

	private int id;
	private int order;
	private String name;
	private int parentId;
	private Collection<CategoryData> children = new ArrayList<>();
	
	public CategoryData(int id, int order, String name, int parentId) {
	    this.id = id;
        this.order = order;
        this.name = name;
	    this.parentId = parentId;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Collection<CategoryData> getChildren() {
        return children;
    }

    public void setChildren(Collection<CategoryData> children) {
        this.children = children;
    }

    @Override
	public String toString() {
		return "CategoryData [id=" + id + ", order=" + order + ", name=" + name + ", parentId=" + getParentId() + "]";
	}
	
}
