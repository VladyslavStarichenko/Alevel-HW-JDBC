package ua.com.alevel.helpers;

import ua.com.alevel.connection.DBConnector;
import ua.com.alevel.dao.ProductDao;
import ua.com.alevel.model.Product;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static ua.com.alevel.helpers.HelperCategory.methodsCategory;

public class HelperProduct {

    public static void methodsProduct(String method, Connection connection) {
        if (method.equals("Read")) {
            ShowProduct(ProductDao.getAllProducts(connection));
            methodsProduct(suggestProductMethod(), connection);
        } else if (method.equals("Update")) {
            Integer prodId = createProductId();
            String name = createProductName();
            Integer price = createProductPrice();
            Integer categoryId = createProductCategoryId();
            ProductDao.updateProduct(connection, name, price, categoryId, prodId);
            methodsProduct(suggestProductMethod(), connection);
        } else if (method.equals("Create")) {
            String categoryName = createProductName();
            Integer price = createProductPrice();
            Integer catID = createProductCategoryId();
            ProductDao.createProduct(connection, categoryName, price, catID);
            methodsProduct(suggestProductMethod(), connection);
        } else if (method.equals("Delete")) {
            Integer product_id = getProductId();
            ProductDao.deleteProduct(connection, product_id);
            methodsProduct(suggestProductMethod(), connection);
        }else if(method.equals("Back")){
            HelperApp.methodsApp(HelperApp.appSuggestion(),connection);
        }


    }

    private static void ShowProduct(List<Product> allProducts) {
        for(Product product : allProducts){
            System.out.println(product+ "\n");
        }
    }

    public static String suggestProductMethod () {
        System.out.println("Here you can Create, Read, Update and Delete Products or press Finish to Exit the App");
        System.out.println("Enter the method you wanna do.");

        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }
    private static Integer getProductId() {
        System.out.println("Enter product id to delete");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        return id;
    }

    public  static  String createProductName(){
        System.out.println("Enter the product name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    public  static  Integer createProductId(){
        System.out.println("Enter the product id");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        return id;
    }

    public  static  Integer createProductPrice(){
        System.out.println("Enter the product price");
        Scanner scanner = new Scanner(System.in);
        Integer price = scanner.nextInt();
        return price;
    }

    public  static  Integer createProductCategoryId(){

        System.out.println("Enter the product--> category_id");
        Scanner scanner = new Scanner(System.in);
        Integer categoryId = scanner.nextInt();
        return categoryId;
    }
}
