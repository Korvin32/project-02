package data;

public class ProductData {

	private int id;
	private String name;
	private String description;
	private double price;
	private String image;
	private int categoryId;

	public ProductData(int id, String name, String description, double price,
			int categoryId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = createImageUrl();
		this.categoryId = categoryId;
	}

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
	public String toString() {
		return "ProductData [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", categoryId=" + categoryId + "]";
	}

    private String createImageUrl() {
        return String.format("http://dummyimage.com/300x300&text=%s", this.getName());
    }

}
