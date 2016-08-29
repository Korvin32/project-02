package controller;

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
        log("CONSTRUCTED AppController()!");
    }

    public List<String> getImages() {
        log("getImages()");
        return DataProvider.findImages();
    }

    public void preRenderComponent() {
        log("5. <f:event>-LISTENER: preRenderComponent");
    }

    public void postAddToView() {
        log("3. <f:event>-LISTENER: postAddToView");
    }

    public void preValidate() {
        log("1. <f:event>-LISTENER: preValidate");
    }

    public void postValidate() {
        log("2. <f:event>-LISTENER: postValidate");
    }

    private void log(String txt) {
        LOG.info(txt);
    }

}
