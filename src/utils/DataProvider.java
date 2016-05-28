package utils;

import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import data.CategoryData;
import data.MenuData;
import data.ProductData;

public final class DataProvider {

    private final static Logger LOG = Logger.getLogger(DataProvider.class);

    private static List<MenuData> menuItems = new ArrayList<MenuData>();

    private static List<CategoryData> categories = new ArrayList<CategoryData>();

    private static List<ProductData> products = new ArrayList<ProductData>();

    private static List<String> images = new ArrayList<String>();

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
        categories.add(new CategoryData(0, 0, "Category - 1"));
        categories.add(new CategoryData(1, 1, "Category - 2"));
        categories.add(new CategoryData(2, 2, "Category - 3"));
        categories.add(new CategoryData(3, 3, "Category - 4"));
        categories.add(new CategoryData(4, 4, "Category - 5"));
        categories.add(new CategoryData(5, 5, "Category - 6"));
        categories.add(new CategoryData(6, 6, "Category - 7"));
        categories.add(new CategoryData(7, 7, "Category - 8"));
        categories.add(new CategoryData(8, 8, "Category - 9"));
        categories.add(new CategoryData(9, 9, "Category - 10"));
        categories.add(new CategoryData(10, 10, "Category - 11"));
        categories.add(new CategoryData(11, 11, "Category - 12"));
    }

    static {
        products.add(new ProductData(0, "Product 01", "description", 20.0, 0));
        products.add(new ProductData(1, "Product 02", "description", 25.0, 0));
        products.add(new ProductData(2, "Product 03", "description", 40.0, 0));
        products.add(new ProductData(3, "Product 04", "description", 35.0, 1));
        products.add(new ProductData(4, "Product 05", "description", 30.0, 1));
        products.add(new ProductData(5, "Product 06", "description", 50.0, 1));
        products.add(new ProductData(6, "Product 07", "description", 45.0, 2));
        products.add(new ProductData(7, "Product 08", "description", 60.0, 2));
        products.add(new ProductData(8, "Product 09", "description", 75.0, 2));
        products.add(new ProductData(9, "Product 10", "description", 115.0, 3));
        products.add(new ProductData(10, "Product 11", "description", 39.0, 3));
        products.add(new ProductData(10, "Product 12", "description", 85.0, 3));
        products.add(new ProductData(10, "Product 13", "description", 135.0, 3));
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
        for (CategoryData categoryData : categories) {
            if (categoryData.getId() == id) {
                return categoryData;
            }
        }
        throw new CategoryNotFoundException(id);
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

    public static ProductData findProductById(Integer id) throws ProductNotFoundException {
        LOG.info("findCategoryById(" + id + ")");
        for (ProductData product : findProducts()) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException(id);
    }

}
