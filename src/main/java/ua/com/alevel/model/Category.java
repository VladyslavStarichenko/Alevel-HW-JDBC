package ua.com.alevel.model;

import java.util.Scanner;

public class Category {
    public Integer categoryId;
    public  String categoryName;



    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Category() {
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String typeCategoryName(String message){
         System.out.println(message);
         Scanner scanner = new Scanner(System.in);
         String name = scanner.nextLine();
         return name;
     }

    public Integer typeCategoryId(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        return id;
    }
}
