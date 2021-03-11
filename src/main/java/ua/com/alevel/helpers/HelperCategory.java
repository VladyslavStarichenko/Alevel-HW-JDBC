package ua.com.alevel.helpers;

import ua.com.alevel.connection.DBConnector;
import ua.com.alevel.dao.CategoryDao;
import ua.com.alevel.model.Category;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;



public class HelperCategory {

    public static void insertCategory(Connection connection, String categoryName) {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.createCategory(connection, categoryName);
    }

    public static void methodsCategory(String method, Connection connection){
        String message1;
        String message2;
        if(method.equals("Read")){
            getCategories(connection);
            methodsCategory(suggestCategoryMethod(),connection);
        }else if(method.equals("Update")){
            message1 = "Enter the id to update Category.";
            message2 = "Enter a new name of the Category.";
            Integer categoryId = getCategoryId(message1);
            String categoryName = getCategoryName(message2);
            CategoryDao.updateCategory(connection, categoryId, categoryName);
            methodsCategory(suggestCategoryMethod(),connection);
        }else if(method.equals("Create")){
            message1 = "Enter category name to create a new Category.";
            String categoryName = getCategoryName(message1);
            insertCategory(connection, categoryName);
            methodsCategory(suggestCategoryMethod(),connection);
        }else if(method.equals("Delete")){
            message1 = "Enter the id to delete Category.";
            Integer categoryId = getCategoryId(message1);
            CategoryDao.deleteCategory(connection,categoryId);
            methodsCategory(suggestCategoryMethod(),connection);
        }else if(method.equals("Back")){
         HelperApp.methodsApp(HelperApp.appSuggestion(),connection);
        }
    }

    public static void getCategories(Connection connection) {
        List<Category> categories = CategoryDao.getAllCategories(connection);
        showCategories(categories);
    }

    private static void showCategories(List<Category> categories) {
        for(Category category : categories){
            System.out.println(category + "\n");
        }
    }

    public static String suggestCategoryMethod() {
        System.out.println("Here you can Create, Read, Update and Delete Categories or press Finish to Exit the App");
        System.out.println("Enter the method you wanna do.");


        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }
    public static String getCategoryName(String message2) {
        Category category = new Category();
        String categoryName = category.typeCategoryName(message2);
        return categoryName;
    }
    public static Integer getCategoryId(String message) {
        Category category = new Category();
        Integer categoryId = category.typeCategoryId(message);
        return categoryId;
    }

}
