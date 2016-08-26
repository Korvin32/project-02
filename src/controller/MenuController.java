package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.jboss.logging.Logger;

import utils.Constants;
import utils.DataProvider;
import utils.FacesUtils;
import utils.MenuItemNotFoundException;
import utils.RequestParameterNotFoundException;
import data.MenuData;

@ManagedBean
// @SessionScoped
@ViewScoped
// @RequestScoped
public class MenuController implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Logger LOG = Logger.getLogger(MenuController.class);

    private MenuData selectedMenu;

    /**
     * Holds the value of view parameter names {@link Constants#VIEW_PARAMETER_NAME__VIEW}
     */
    private String vpView;

    public List<MenuData> getMenuItems() {
        log("getMenuItems()");
        return DataProvider.findMenuDatas();
    }

    /**
     * Issue #1: the value of {@link AppController#vpView} is not reset while requesting link without parameter.
     * Solutions: 1. Evaluate request map. 2. Make responsible bean as RequestScoped!
     *
     */
    public void initHeaderMenu() {
        log("initHeaderMenu(): current vpView=" + vpView);

        /**
         * Do not need it any more, as we are using ViewScoped managed bean.
         */
        // Reset category selection
        // selectedCategory = null;

        // if (FacesUtils.isRequestMethodGet()) {
        // handleGetRequestWithoutParameter(Constants.VIEW_PARAMETER_NAME__VIEW, vpView);
        // }
        try {
            if (vpView != null) {
                selectedMenu = DataProvider.findMenuItemByViewParam(vpView);
            } else {
                String currentView = FacesUtils.getCurrentViewId();
                selectedMenu = DataProvider.findMenuItemByXhtmlViewNameWithoutViewParam(currentView);
            }
            log("initHeaderMenu(): selectedMenu=" + selectedMenu);
        } catch (MenuItemNotFoundException e) {
            LOG.error("initHeaderMenu(). Details: " + e.getMessage(), e);
            FacesUtils.addErrorFacesMessage(e.getMessage());
        }
    }

    public MenuData getSelectedMenu() {
        log("getSelectedMenu(): selectedMenu=" + selectedMenu);
        return selectedMenu;
    }

    public void setSelectedMenu(MenuData selectedMenu) {
        log("setSelectedMenu(): " + selectedMenu);
        this.selectedMenu = selectedMenu;
    }

    public void menuItemActionListener(ActionEvent ae) {
        log("menuItemActionListener()");
        selectedMenu = (MenuData) ae.getComponent().getAttributes().get(Constants.ATTRIBUTE_SELECTED_ITEM);
        log("menuItemActionListener() : attributesMap = " + selectedMenu);
    }

    public String getVpView() {
        log("getVpView(): vpView=" + vpView);
        return vpView;
    }

    public void setVpView(String vpView) {
        log("setVpView(): " + vpView);
        this.vpView = vpView;

    }

    public String getStyleForHeaderMenu(MenuData item) {
        if (selectedMenu == item) {
            return Constants.UI_STYLE_HEADER_MENU_SELECTED;
        }
        return Constants.UI_STYLE_HEADER_MENU;
    }

    private void handleGetRequestWithoutParameter(String viewParameterName, String viewParameterValueToCheck) {
        try {
            String viewParameterValuefromRequestQuery = FacesUtils.extractParameterValueFromRequestMap(viewParameterName);
        } catch (RequestParameterNotFoundException e) {
            LOG.info(e.getMessage());
            viewParameterValueToCheck = null;
        }
    }

    private void log(String txt) {
        LOG.info(txt);
    }

}
