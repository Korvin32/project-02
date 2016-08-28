package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import org.jboss.logging.Logger;

import data.MenuData;
import utils.Constants;
import utils.DataProvider;
import utils.FacesUtils;
import utils.MenuItemNotFoundException;

@ManagedBean
@ViewScoped
public class MenuController implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final Logger LOG = Logger.getLogger(MenuController.class);

    private MenuData selectedMenu;

    /**
     * Holds the value of view parameter names {@link Constants#VIEW_PARAMETER_NAME__VIEW}
     */
    private String vpView;

    public List<MenuData> getMenuItems() {
        LOG.info("getMenuItems()");
        return DataProvider.findMenuDatas();
    }

    /**
     * Issue #1: the value of {@link AppController#vpView} is not reset while requesting link without parameter.
     * Solutions: 1. Evaluate request map. 2. Make responsible bean as RequestScoped!
     *
     */
    public void initHeaderMenu() {
        LOG.info("initHeaderMenu(): current vpView=" + vpView);

        try {
            if (vpView != null) {
                selectedMenu = DataProvider.findMenuItemByViewParam(vpView);
            } else {
                String currentView = FacesUtils.getCurrentViewId();
                selectedMenu = DataProvider.findMenuItemByXhtmlViewNameWithoutViewParam(currentView);
            }
            LOG.info("initHeaderMenu(): selectedMenu=" + selectedMenu);
        } catch (MenuItemNotFoundException e) {
            LOG.error("initHeaderMenu(). Details: " + e.getMessage(), e);
            FacesUtils.addErrorFacesMessage(e.getMessage());
        }
    }

    public MenuData getSelectedMenu() {
        LOG.info("getSelectedMenu(): selectedMenu=" + selectedMenu);
        return selectedMenu;
    }

    public void setSelectedMenu(MenuData selectedMenu) {
        LOG.info("setSelectedMenu(): " + selectedMenu);
        this.selectedMenu = selectedMenu;
    }

    public void menuItemActionListener(ActionEvent ae) {
        LOG.info("menuItemActionListener()");
        selectedMenu = (MenuData) ae.getComponent().getAttributes().get(Constants.ATTRIBUTE_SELECTED_ITEM);
        LOG.info("menuItemActionListener() : attributesMap = " + selectedMenu);
    }

    public String getVpView() {
        LOG.info("getVpView(): vpView=" + vpView);
        return vpView;
    }

    public void setVpView(String vpView) {
        LOG.info("setVpView(): " + vpView);
        this.vpView = vpView;

    }

    public String getStyleForHeaderMenu(MenuData item) {
        if (selectedMenu == item) {
            return Constants.UI_STYLE_HEADER_MENU_SELECTED;
        }
        return Constants.UI_STYLE_HEADER_MENU;
    }

}
