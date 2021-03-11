package ua.com.alevel.helpers;

import ua.com.alevel.connection.DBConnector;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.model.User;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;



public class HelperUser {

    public static void methodsUser(String method, Connection connection) {
        if (method.equals("Read")) {
            ShowList(UserDao.getAllUsers(connection));
            methodsUser(suggestUserMethod(), connection);
        } else if (method.equals("Update")) {
            Integer user_id = createUserId();
            String name = createName();
            String last_name = createLastName();
            String adress = createAdress();
            Integer post_code = createPostCode();
            String email = createEmail();
            UserDao.updateUser(connection, name, last_name, adress, post_code,email,user_id);
            methodsUser(suggestUserMethod(), connection);
        } else if (method.equals("Create")) {
            String name = createName();
            String last_name = createLastName();
            String adress = createAdress();
            Integer post_code = createPostCode();
            String email = createEmail();
            UserDao.createUser(connection, name,last_name,adress,post_code,email);
            methodsUser(suggestUserMethod(), connection);
        } else if (method.equals("Delete")) {
            Integer user_id = createUserId();
            UserDao.deleteUser(connection, user_id);
            methodsUser(suggestUserMethod(), connection);
        }else if(method.equals("Back")){
            HelperApp.methodsApp(HelperApp.appSuggestion(),connection);
        }
    }

    private static void ShowList(List<User> list) {
        for(User user : list){
            System.out.println(user + "\n");
        }
    }

    private static String createEmail() {
        System.out.println("Enter User mail");
        Scanner scanner = new Scanner(System.in);
        String mail = scanner.nextLine();
        return mail;
    }

    private static Integer createPostCode() {
        System.out.println("Enter user post code");
        Scanner scanner = new Scanner(System.in);
        Integer post = scanner.nextInt();
        return post;
    }

    private static String createAdress() {
        System.out.println("Enter User address");
        Scanner scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        return address;
    }

    private static String createLastName() {
        System.out.println("Enter User last name");
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();
        return lastName;
    }

    private static Integer createUserId() {
        System.out.println("Enter user id");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        return id;
    }

    private static String createName() {
        System.out.println("Enter User name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    public static String suggestUserMethod () {
        System.out.println("Here you can Create, Read, Update and Delete Users or press Finish to Exit the App");
        System.out.println("Enter the method you wanna do.");

        Scanner scanner = new Scanner(System.in);
        String method = scanner.nextLine();
        return method;
    }
}
