package utils;

import org.junit.Test;

import data.CategoryData;

public class DataProviderTest {

    @Test
    public void testFindCategories() {
        for (CategoryData category : DataProvider.findCategories()) {
            String indentation = "";
            printCategory(category, indentation);
        }
    }

    private static void printCategory(CategoryData category, String indentation) {
        System.out.println(String.format("%s[%d]%s", indentation, category.getId(), category.getName()));
        if (CategoryDataUtil.hasChildren(category)) {
            indentation += "    ";
            for (CategoryData subCategory : category.getChildren()) {
                printCategory(subCategory, indentation);
            }
        }
    }

    @Test
    public void testFindCategoryById() {
        try {
            CategoryData findCategoryById = DataProvider.findCategoryById(24);
            System.out.println(findCategoryById);
        } catch (CategoryNotFoundException e) {
            e.printStackTrace();
        }
    }
}
