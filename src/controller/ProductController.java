package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.logging.Logger;

import utils.Constants;
import utils.DataProvider;
import utils.FacesUtils;
import utils.ProductNotFoundException;
import data.ProductData;

@ManagedBean
// @SessionScoped
@ViewScoped
// @RequestScoped
public class ProductController implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Logger LOG = Logger.getLogger(ProductController.class);

    private ProductData selectedProduct;

    /**
     * Holds the value of view parameter names {@link Constants#VIEW_PARAMETER_NAME__PRODUCT_ID}
     */
    private String vpProduct;

    public void initProduct() {
        LOG.info("initProduct()");
        if (vpProduct != null) {
            try {
                selectedProduct = DataProvider.findProductById(Integer.valueOf(vpProduct));
                LOG.info("initProduct(): selectedCategory=" + selectedProduct);
            } catch (NumberFormatException | ProductNotFoundException e) {
                LOG.error("initProduct(). Details: " + e.getMessage(), e);
                FacesUtils.addErrorFacesMessage(e.getMessage());
            }
        } else {
            String message = "Product not specified! Please use navigation menu!";
            LOG.error("initProduct(). Details: " + message);
            FacesUtils.addErrorFacesMessage(message);
        }
    }

    public ProductData getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(ProductData selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getVpProduct() {
        return vpProduct;
    }

    public void setVpProduct(String vpProduct) {
        this.vpProduct = vpProduct;
    }

}
