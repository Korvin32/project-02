package data;

/**
 * @author zagorod
 *
 */
public class CategoryData {

	private int id;
	private int order;
	private String name;
	
	public CategoryData(int id, int order, String name) {
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

	@Override
	public String toString() {
		return "CategoryData [id=" + id + ", order=" + order + ", name=" + name + "]";
	}
	
}
