package controller;

import java.io.Serializable;
import java.util.List;

import org.jboss.logging.Logger;

import data.CategoryData;
import utils.CategoryNotFoundException;
import utils.Constants;
import utils.DataProvider;
import utils.FacesUtils;

//@javax.faces.bean.ManagedBean
//@javax.faces.bean.ViewScoped
@javax.inject.Named
@javax.faces.view.ViewScoped
public class CategoryController implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Logger LOG = Logger.getLogger(CategoryController.class);

    private CategoryData selectedCategory;

    /**
     * Holds the value of view parameter names {@link Constants#VIEW_PARAMETER_NAME__CATEGORY}
     */
    private String vpCategory;

    public CategoryController() {
        LOG.info("CREATION of CategoryController!");
	}
    
    public List<CategoryData> getCategories() {
        LOG.info("getCategories()");
        return DataProvider.findCategories();
    }

    public void initCategory() {
        LOG.info("--> initCategory()");
        if (vpCategory != null) {
            try {
                selectedCategory = DataProvider.findCategoryById(Integer.valueOf(vpCategory));
                LOG.info("--- initCategory(): selectedCategory=" + selectedCategory);
            } catch (NumberFormatException | CategoryNotFoundException e) {
                LOG.error("--- initCategory(). Details: " + e.getMessage(), e);
                FacesUtils.addErrorFacesMessage(e.getMessage());
            }
        } else {
            String message = "Category not specified! Please use navigation menu!";
            LOG.error("--- initCategory(). Details: " + message);
            FacesUtils.addErrorFacesMessage(message);
        }
        LOG.info("<-- initCategory()");
    }

    public CategoryData getSelectedCategory() {
        LOG.info("getSelectedCategory(): selectedCategory=" + selectedCategory);
        return selectedCategory;
    }

    public void setSelectedCategory(CategoryData selectedCategory) {
        LOG.info("setSelectedCategory(): " + selectedCategory);
        this.selectedCategory = selectedCategory;
    }

    public String getVpCategory() {
        LOG.info("getVpCategory(): vpCategory = " + vpCategory);
        return vpCategory;
    }

    public void setVpCategory(String vpCategory) {
        LOG.info("setVpCategory(): " + vpCategory);
        this.vpCategory = vpCategory;
    }

    public String getStyleClassForCategory(CategoryData category) {
        if (selectedCategory == category) {
            return Constants.UI_CLASS_CATEGORY_SELECTED;
        }
        return Constants.UI_CLASS_CATEGORY;
    }
}
