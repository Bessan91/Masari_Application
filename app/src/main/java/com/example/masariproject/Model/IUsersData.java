package com.example.masariproject.Model;

import java.util.ArrayList;

public interface IUsersData {
    public ArrayList<Users> getAllUsers();
    public ArrayList<Users> getUsersByType(String type);
    public Users SearchForUser(String email , String pass);
    public void AddNewUser(Users newUser);
    public Users SearchForUserByEmail(String email);

}
