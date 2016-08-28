package galleries;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.jboss.logging.Logger;

import controller.CategoryController;
import data.CategoryData;
import data.ProductData;
import utils.Constants;
import utils.DataListingSupport;
import utils.DataProvider;
import utils.FacesUtils;

@ManagedBean
@ViewScoped
public class ProductsGallery extends DataListingSupport<ProductData> {

    private static final long serialVersionUID = -1060917730823569754L;
    
    public static final Logger LOG = Logger.getLogger(ProductsGallery.class);
    
    /**
     * Holds the value of view parameter names {@link Constants#VIEW_PARAMETER_NAME__PAGE}
     */
    private int vpPage;
    
    public void initProductsGallery() {
        LOG.info("--> initProductsGallery().");
    	if (vpPage > 0) {
    		LOG.info("--- initProductsGallery(): vpPage=" + vpPage);
            setPage(vpPage);
        }
    	// Call refresh here to handle GET request properly.
    	refresh();
    	LOG.info("<-- initProductsGallery().");
    }

    @Override
    protected void populateCountAndData() {
        LOG.info("--> populateCountAndData().");
    	Integer pageSize = getRowsPerPage();
        Integer page = getPage();
        Integer offset = (page - 1) * pageSize;
        CategoryData selectedCategory = getSelectedCategoryData();
        LOG.info(String.format("--- populateCountAndData(): selectedCategory=%s, offset=%s, pageSize=%s.", selectedCategory, offset, pageSize));
        
        Integer recordCount;
        List<ProductData> productsToShow;
        boolean categorySelected = (selectedCategory != null);
        if (categorySelected ) {
            recordCount = DataProvider.findProductsByCategory(selectedCategory).size();
            productsToShow = DataProvider.findProductsByCategoryInRange(selectedCategory, offset, pageSize);
        } else {
            recordCount = DataProvider.findProducts().size();
            productsToShow = DataProvider.findProductsInRange(offset, pageSize);
        }
        setRecordCount(recordCount);
        setData(productsToShow);
        LOG.info("<-- populateCountAndData().");
    }
    
    public int getVpPage() {
    	LOG.info("--> getVpPage(): vpPage = " + vpPage);
		return vpPage;
	}

	public void setVpPage(int vpPage) {
        LOG.info("--> setVpPage(): " + vpPage);
		this.vpPage = vpPage;
	}

	private CategoryData getSelectedCategoryData() {
    	CategoryController categoryController = FacesUtils.getManagedBean("categoryController", CategoryController.class);
    	CategoryData selectedCategory = categoryController.getSelectedCategory();
    	return selectedCategory;
    }

}
