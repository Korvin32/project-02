package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.jboss.logging.Logger;

import utils.Constants;
import utils.DataProvider;
import utils.FacesUtils;
import utils.MenuItemNotFoundException;
import utils.RquestParameterNotFoundException;
import data.MenuData;

@ManagedBean
// @SessionScoped
@ViewScoped
// @RequestScoped
public class AppController implements Serializable {

    private static final long serialVersionUID = -4423857768540561118L;

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
