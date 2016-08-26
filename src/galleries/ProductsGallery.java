package galleries;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import data.CategoryData;
import data.ProductData;
import utils.DataListingSupport;
import utils.DataProvider;

@ManagedBean
@ViewScoped
public class ProductsGallery extends DataListingSupport<ProductData> {

    private static final long serialVersionUID = -1060917730823569754L;
    
    //TODO: can be initiated through view parameter too in the corresponding init methods
    private CategoryData selectedCategory;
    
    @Override
    protected void populateCountAndData() {
        int pageSize = getRowsPerPage();
        Integer page = getPage();
        int offset = (page - 1) * pageSize;
        
        int recordCount;
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
    }

}
