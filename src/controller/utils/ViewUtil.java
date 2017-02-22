package controller.utils;

import data.CategoryData;
import utils.CategoryDataUtil;

@javax.inject.Named
@javax.enterprise.context.RequestScoped
public class ViewUtil {

    public boolean hasCategoryChildren(CategoryData category) {
        return CategoryDataUtil.hasChildren(category);
    }
    
}
