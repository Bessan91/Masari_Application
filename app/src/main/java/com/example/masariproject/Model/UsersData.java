package com.example.masariproject.Model;


import java.util.ArrayList;

    public class UsersData implements IUsersData {
        private ArrayList<Users> AllUsers ;

        @Override
        public ArrayList<Users> getAllUsers(){
            for(int i=0 ; i<Users.users.length;i++)
                AllUsers.add(Users.users[i]);
            return AllUsers;
        }

        @Override
        public ArrayList<Users> getUsersByType(String type){
            ArrayList<Users> u = new ArrayList<>() ;
            for(int i=0 ; i<Users.users.length;i++)
                if(Users.users[i].equals(type))
                    u.add(Users.users[i]);
            return u;
        };

        @Override
        public Users SearchForUser(String email , String pass){
            for(int i=0 ;i<Users.users.length;i++)
                if(Users.users[i].getEmail().equals(email) &&
                        Users.users[i].getPassword().equals(pass))
                    return  Users.users[i];
            return new Users(-1);
        }

        @Override
        public void AddNewUser(Users newUser){
            AllUsers.add(newUser);
        }
        @Override
        public Users SearchForUserByEmail(String email){
            for(int i=0 ;i<Users.users.length;i++)
                if(Users.users[i].getEmail().equals(email))
                    return  Users.users[i];
            return new Users(-1);
        }
    }
