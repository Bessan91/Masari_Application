package com.example.masariproject.Model;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class Users  implements Serializable {
    //type: Admin , client , guide
    private String fullName;
    private String email;
    private String password;
    private String type;
    private String Address;
    private String phoneNumber;
    String imgString = "defult_img";



    private int id , img ;

    public static ArrayList<tours> toursListFavorite = new ArrayList<>();
    public static ArrayList<tours> toursBooking = new ArrayList<>();



    static final String Admin = "Admin" ;
    static final String Guide = "Guide" ;
    static final  String Client = "Client";

    public Users(){
        id=-1;
    }

    public Users(int id){
        this.id=id;
    }

    public Users(String email , String pass){
        this.email=email;
        password=pass;
    }

    public Users(String name , String email , String pass){
        this.fullName =name;
        this.email=email;
        this.password=pass;
    }



    public Users(String email){
        this.email=email;
    }


    public Users(String fullName, String email, String password, String type,
                 String address, String phoneNumber, int id) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.type = type;
        Address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }


    public static final Users[] users = {

            new Users("noor","1234"),
            //Admin:
            new Users("Noor","noor@gmial.com","1234",Admin,
                    "Rammalah","0599387232",1),
            new Users("Bessan","Bessan@gmial.com","1234",Admin,
                    "Rammalah","0599387232",2),
            new Users("Doaa","Doaa@gmial.com","1234",Admin,
                    "Rammalah","0599387232",3),


            //Guide
            new Users("Yara","Yara@gmial.com","1234",Guide,
                    "Rammalah","0599387232",4),

            //Client :
            new Users("Ahed","Ahed@gmial.com","1234",Client,
                    "Rammalah","0599387232",5),
            new Users("Muzoon","Muzoon@gmial.com","1234",Client,
                    "Rammalah","0599387232",6),
            new Users("Israa","Israa@gmial.com","1234",Client,
                    "Rammalah","0599387232",7),
            new Users("Ekram","Ekram@gmial.com","1234",Client,
                    "Rammalah","0599387232",8),
    };


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public ArrayList<tours> getToursListFavorite() {
        return toursListFavorite;
    }


    public static ArrayList<tours> getToursBooking() {
        return toursBooking;
    }
    public static void setToursBooking(ArrayList<tours> toursBooking) {
        Users.toursBooking = toursBooking;
    }

    public String getImgString() {
        return imgString;
    }

    public void setImgString(String imgString) {
        this.imgString = imgString;
    }

    @Override
    public String toString() {
        return "Users{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void AddToListFavorate(tours t ){
        toursListFavorite.add(t);
    }

    public void AddToListBooking(tours t ){
        toursBooking.add(t);
    }

    public void deleteFromListBooking(tours t){
        toursBooking.remove(t);
    }

    public void deleteFromListFavorit(tours t){
        toursListFavorite.remove(t);
    }



}
