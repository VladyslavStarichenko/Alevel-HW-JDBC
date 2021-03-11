package ua.com.alevel.model;

public class User {
    Integer user_id;
    String name;
    String last_name;
    String address;
    Integer post_code;
    String email;

    public Integer getUser_id() {
        return user_id;
    }


    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", post_code=" + post_code +
                ", email='" + email + '\'' +
                '}';
    }


    public User(Integer user_id, String name, String last_name, String address, Integer post_code, String email) {
        this.user_id = user_id;
        this.name = name;
        this.last_name = last_name;
        this.address = address;
        this.post_code = post_code;
        this.email = email;
    }
}
