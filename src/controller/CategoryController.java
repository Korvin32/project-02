package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.logging.Logger;

import utils.CategoryNotFoundException;
import utils.Constants;
import utils.DataProvider;
import utils.FacesUtils;
import data.CategoryData;
import data.ProductData;

@ManagedBean
// @SessionScoped
@ViewScoped
// @RequestScoped
public class CategoryController implements Serializable {

    private static final long serialVersionUID = 2354059049000471596L;

    public static final Logger LOG = Logger.getLogger(CategoryController.class);

    private CategoryData selectedCategory;

    /**
     * Holds the value of view parameter names {@link Constants#VIEW_PARAMETER_NAME__CATEGORY}
     */
    private String vpCategory;

    public List<CategoryData> getCategories() {
        log("getCategories()");
        return DataProvider.findCategories();
    }

    public void initCategory() {
        log("initCategory()");

        /**
         * Do not need it any more, as we are using ViewScoped managed bean.
         */
        // Reset menu item selection
        // selectedMenu = null;

        if (vpCategory != null) {
            try {
                selectedCategory = DataProvider.findCategoryById(Integer.valueOf(vpCategory));
                log("initCategory(): selectedCategory=" + selectedCategory);
            } catch (NumberFormatException | CategoryNotFoundException e) {
                LOG.error("initCategory(). Details: " + e.getMessage(), e);
                FacesUtils.addErrorFacesMessage(e.getMessage());
            }
        } else {
            String message = "Category not specified! Please use navigation menu!";
            LOG.error("initCategory(). Details: " + message);
            FacesUtils.addErrorFacesMessage(message);
        }
    }

    public CategoryData getSelectedCategory() {
        log("getSelectedCategory(): selectedCategory=" + selectedCategory);
        return selectedCategory;
    }

    public void setSelectedCategory(CategoryData selectedCategory) {
        log("setSelectedCategory(): " + selectedCategory);
        this.selectedCategory = selectedCategory;
    }

    public String getVpCategory() {
        log("getVpCategory(): vpCategory = " + vpCategory);
        return vpCategory;
    }

    public void setVpCategory(String vpCategory) {
        log("setVpCategory(): " + vpCategory);
        this.vpCategory = vpCategory;
    }

    public String getStyleClassForCategory(CategoryData category) {
        if (selectedCategory == category) {
            return Constants.UI_CLASS_CATEGORY_SELECTED;
        }
        return Constants.UI_CLASS_CATEGORY;
    }

    private void log(String txt) {
        LOG.info(txt);
    }

    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    /*
     * /* Here starts the handling of products gallery in a category (if selected) or a whole list of available products
     * (if no specific category selected)
     */
    /*-------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    public List<ProductData> getProducts() {
        log("getProducts()");
        if (selectedCategory != null) {
            return DataProvider.findProductsByCategory(selectedCategory);
        }
        return DataProvider.findProducts();
    }
}
