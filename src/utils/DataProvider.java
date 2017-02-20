package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jboss.logging.Logger;

import data.CategoryData;
import data.MenuData;
import data.ProductData;

public final class DataProvider {

    private final static Logger LOG = Logger.getLogger(DataProvider.class);

    private static final int CATEGORIES_HEAD_NODES_COUNT = 12;
    
    private static final int CATEGORIES_CHILDREN_PER_CATEGORY_COUNT = 4;
    
    private static final int CATEGORIES_MAX_NESTING = 2;
    
    private static final int PRODUCTS_PER_CATEGORY = 100;
    
    private static List<MenuData> menuItems = new ArrayList<MenuData>();

    private static List<CategoryData> categories = new ArrayList<CategoryData>();

    private static List<ProductData> products = new ArrayList<ProductData>();

    private static List<String> images = new ArrayList<String>();
    
    private static int incrementingCategoryId = 1;

    //@formatter:off
    static {
        menuItems.add(new MenuData(1,      false,      "Index" +
                                                       "IndexIndex" +
                                                       "IndexIndex",      "index",      "./index.xhtml",       null,                "You are on the Index menu"                                 ));
        menuItems.add(new MenuData(2,      true,       "Main",            "main",       "./main.xhtml",        null,                "You are on the Main menu"                                  ));
        menuItems.add(new MenuData(3,      true,       "About",           "about",      "./about.xhtml",       null,                "You are on the About menu"                                 ));
        menuItems.add(new MenuData(4,      true,       "How to bay",      "howToBay",   "./howToBay.xhtml",    null,                "You are on the 'How to bay' menu"                          ));
        menuItems.add(new MenuData(5,      true,       "Contacts",        "contacts",   "./contacts.xhtml",    null,                "You are on the Contacts menu"                              ));
        menuItems.add(new MenuData(6,      true,       "News",            "contacts",   "./contacts.xhtml",    "news",              "You are on the News menu, but within contacts.xhtml-page!" ));
        menuItems.add(new MenuData(7,      true,       "Tutors",          "contacts",   "./contacts.xhtml",    "tutors",            "In 'Tutors' menu - within the contacts.xhtml-Page!"        ));

        menuItems.add(new MenuData(8,      true,       "Impresum",        "about",      "./about.xhtml",       "impresum",          "Here we have an Impresum! :)"                              ));
        menuItems.add(new MenuData(9,      true,       "Angebote",        "howToBay",   "./howToBay.xhtml",    "angebote",          "We have nice proposals for your needs here! :)"            ));
//      menuItems.add(new MenuData(order,  rendered,   item,              action,       contentIncludeSrc,     viewParam,           paramValue                                                  ));
//                                                                        or 'outcome'  or 'xhtml_view_name'                        or 'view_content'
    }
    //@formatter:on

    static {
        List<CategoryData> categories = createAllCategories();
        DataProvider.categories.addAll(categories);
    }

    private static List<CategoryData> createAllCategories() {
        List<CategoryData> categories = new ArrayList<>();
        for (int c = 0; c < CATEGORIES_HEAD_NODES_COUNT; c++) {
            int categoryNestingLevel = 0;
            CategoryData parent = null;
            CategoryData category = createCategory(c, categoryNestingLevel, parent);
            categories.add(category);
        }
        return categories;
    }

    private static CategoryData createCategory(int c, int categoryNestingLevel, CategoryData parent) {
        String name = String.format("Category - %d", (c + 1));
        CategoryData category = new CategoryData(incrementingCategoryId, c, name, -1);
        incrementingCategoryId++;
        if (parent != null) {
            category.setName(String.format("Sub-'%s' - %d", parent.getName(), (c + 1)));
            category.setParentId(parent.getId());
        }
        if (categoryNestingLevel < CATEGORIES_MAX_NESTING) {
            Collection<CategoryData> children = createSubCategoriesForCategory(category, categoryNestingLevel);
            category.setChildren(children);
        }
        return category;
    }

    private static Collection<CategoryData> createSubCategoriesForCategory(CategoryData parent, int categoryNestingLevel) {
        categoryNestingLevel++;
        Collection<CategoryData> subCategories = new ArrayList<>();
        for (int cc = 0; cc < CATEGORIES_CHILDREN_PER_CATEGORY_COUNT; cc++) {
            CategoryData subCategory = createCategory(cc, categoryNestingLevel, parent);
            subCategories.add(subCategory);
        }
        
        return subCategories;
    }

    static {
        for (CategoryData category : categories) {
            int categoryId = category.getId();
            for (int p = 0; p < PRODUCTS_PER_CATEGORY; p++) {
                int productId = PRODUCTS_PER_CATEGORY * categoryId + p;
                String name = String.format("Product %02d", (productId + 1));
                String description = String.format("Description for %s", name);
                double price = Math.random() * 200;
                products.add(new ProductData(productId, name, description, price, categoryId));
            }
        }
    }

    static {
        images.add("http://s31.dawandastatic.com/Product2/52114/52114499/listview_l/1381490800-66.jpg");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature2.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature3.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature4.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature5.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature6.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature7.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature8.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature9.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature10.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature11.jpg.xhtml");
        images.add("http://www.primefaces.org/showcase/javax.faces.resource/demo/images/nature/nature12.jpg.xhtml");
    }

    public static List<MenuData> findMenuDatas() {
        return menuItems;
    }

    public static List<CategoryData> findCategories() {
        return categories;
    }

    public static CategoryData findCategoryById(int id) throws CategoryNotFoundException {
        LOG.info("findCategoryById(" + id + ")");
        List<CategoryData> flattenCategories = flattenAllCategories();
        LOG.info("findCategoryById: Flatten categories size: " + flattenCategories.size());
        
        for (CategoryData category : flattenCategories) {
            if (category.getId() == id) {
                return category;
            }
        }
        throw new CategoryNotFoundException(id);
    }

    private static List<CategoryData> flattenAllCategories() {
        List<CategoryData> flattenCategories = new ArrayList<>();
        for (CategoryData category : categories) {
            flattenCategories.add(category);
            if (CategoryDataUtil.hasChildren(category)) {
                Collection<CategoryData> subCategories = category.getChildren();
                flattenCategories.addAll(flattenCategories(subCategories));
            }
        }
        return flattenCategories;
    }

    private static List<CategoryData> flattenCategories(Collection<CategoryData> categories) {
        List<CategoryData> flattenCategories = new ArrayList<>();
        for (CategoryData category : categories) {
            flattenCategories.add(category);
            if (CategoryDataUtil.hasChildren(category)) {
                Collection<CategoryData> subCategories = category.getChildren();
                flattenCategories.addAll(flattenCategories(subCategories));
            }
        }
        return flattenCategories;
    }

    public static List<ProductData> findProducts() {
        return products;
    }

    public static List<String> findImages() {
        return images;
    }

    public static void addMenuData(MenuData menuItem) {
        LOG.info("addMenuData(): menuItem=" + menuItem);
        menuItems.add(menuItem);
    }

    public static int getDefaultOrderMenuItem() {
        return findMenuDatas().size() + 1;
    }

    public static void deleteMenuItem(MenuData menuItem) {
        findMenuDatas().remove(menuItem);
        LOG.info("deleteMenuItem(). Menu item removed: " + menuItem);
    }

    public static MenuData findMenuItemByViewParam(String viewParam) throws MenuItemNotFoundException {
        LOG.info("findItemByViewParam(" + viewParam + ")");
        for (MenuData menuItem : findMenuDatas()) {
            if (menuItem.getViewParam() != null && menuItem.getViewParam().equals(viewParam)) {
                return menuItem;
            }
        }
        throw new MenuItemNotFoundByViewParamException(viewParam);
    }

    public static MenuData findMenuItemByXhtmlViewNameWithoutViewParam(String xhtmlViewName) throws MenuItemNotFoundException {
        LOG.info("findMenuItemByXhtmlViewNameWithoutViewParam(" + xhtmlViewName + ")");
        for (MenuData menuItem : findMenuDatas()) {
            if (menuItem.getXhtmlViewName() != null && menuItem.getXhtmlViewName().substring(1).equals(xhtmlViewName)
                    && menuItem.getViewParam() == null) {
                return menuItem;
            }
        }
        throw new MenuItemNotFoundByXhtmlViewNameException(xhtmlViewName);
    }

    public static List<ProductData> findProductsByCategory(CategoryData category) {
        LOG.info("findProductsByCategory(" + category + ")");
        List<ProductData> products = new ArrayList<ProductData>();
        for (ProductData product : findProducts()) {
            if (product.getCategoryId() == category.getId()) {
                products.add(product);
            }
        }
        return products;
    }
    
    public static List<ProductData> findProductsByCategoryInRange(CategoryData category, int offset, int pageSize) {
        LOG.info("findProductsByCategoryInRange(" + category + ", offset=" + offset + ", pageSize=" + pageSize + ")");
        List<ProductData> productsToFilter = findProductsByCategory(category);
        List<ProductData> result = getPagedProducts(offset, pageSize, productsToFilter);
        return result;
    }
    
    public static List<ProductData> findProductsInRange(int offset, int pageSize) {
        LOG.info("findProductsInRange(offset=" + offset + ", pageSize=" + pageSize + ")");
        List<ProductData> productsToFilter = findProducts();
        List<ProductData> result = getPagedProducts(offset, pageSize, productsToFilter);
        return result;
    }

    public static ProductData findProductById(Integer id) throws ProductNotFoundException {
        LOG.info("findCategoryById(" + id + ")");
        for (ProductData product : findProducts()) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException(id);
    }

    private static List<ProductData> getPagedProducts(int offset, int pageSize, List<ProductData> productsToFilter) {
        List<ProductData> pagedProducts = new ArrayList<ProductData>();
        int productListSize = productsToFilter.size();
        for (int i = 0; i < pageSize; i++) {
            int productIndex = i + offset;
            if (productIndex < productListSize) {
                ProductData product = productsToFilter.get(productIndex);
                pagedProducts.add(product);
            } else {
                break;
            }
        }
        return pagedProducts;
    }
    
}
