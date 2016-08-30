package controller;

import static utils.Constants.APPLICATION_COMPOSITION_VIEW_TEMPLATE_PATH;

import java.io.Serializable;
import java.util.List;

import org.jboss.logging.Logger;

import utils.DataProvider;

//@javax.faces.bean.ManagedBean
//@javax.faces.bean.ViewScoped
@javax.inject.Named
@javax.faces.view.ViewScoped
public class AppController implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Logger LOG = Logger.getLogger(AppController.class);

    public AppController() {
        LOG.info("CONSTRUCTED AppController()!");
    }

    public List<String> getImages() {
        LOG.info("getImages()");
        return DataProvider.findImages();
    }

    public String getTemplate() {
    	return APPLICATION_COMPOSITION_VIEW_TEMPLATE_PATH;
    }
    
    public void preRenderComponent() {
        LOG.info("5. <f:event>-LISTENER: preRenderComponent");
    }

    public void postAddToView() {
        LOG.info("3. <f:event>-LISTENER: postAddToView");
    }

    public void preValidate() {
        LOG.info("1. <f:event>-LISTENER: preValidate");
    }

    public void postValidate() {
        LOG.info("2. <f:event>-LISTENER: postValidate");
    }

}
