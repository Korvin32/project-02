package data;

/**
 * @author zagorod
 *
 */
public class CategoryData {

	private int id;
	private int order;
	private String name;
	private int parentId;
	
	public CategoryData(int id, int order, String name) {
		createBaseCaetgory(id, order, name);
	}

	public CategoryData(int id, int order, String name, int parentId) {
	    createBaseCaetgory(id, order, name);
	    this.setParentId(parentId);
	}
	
    private void createBaseCaetgory(int id, int order, String name) {
        this.id = id;
		this.order = order;
		this.name = name;
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

    @Override
	public String toString() {
		return "CategoryData [id=" + id + ", order=" + order + ", name=" + name + ", parentId=" + getParentId() + "]";
	}
	
}
