package controller.utils;

import data.CategoryData;
import utils.CategoryDataUtil;

/**
 * Utility class to use utility functionality in JSF views.
 * It is exposed as a named been in order to be accessible from view's EL and delegate utility functionality.
 * 
 * @author korvin32@yahoo.com
 * 
 * @since 22.02.2017
 *
 */
@javax.inject.Named
@javax.enterprise.context.RequestScoped
public class ViewUtil {

    public boolean hasCategoryChildren(CategoryData category) {
        return CategoryDataUtil.hasChildren(category);
    }

}
