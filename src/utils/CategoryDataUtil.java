package utils;

import data.CategoryData;

public final class CategoryDataUtil {

    public static boolean hasChildren(CategoryData category) {
        return !category.getChildren().isEmpty();
    }

    public static boolean hasParent(CategoryData category) {
        return category.getParentId() > 0;
    }

    public static boolean isHeadNode(CategoryData category) {
        return category.getParentId() < 0;
    }
    
}
