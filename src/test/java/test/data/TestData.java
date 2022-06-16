package test.data;

import data.colors.DataColors;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    static List<String> avatars = new ArrayList<>();
    static  List<DataColors> dataColorsList = new ArrayList<>();

    public static List<String> addNotUniqueNames() {
        avatars.add("https://reqres.in/img/faces/11-image.jpg");
        avatars.add("https://reqres.in/img/faces/11-image.jpg");
        avatars.add("https://reqres.in/img/faces/11-image.jpg");
        avatars.add("https://reqres.in/img/faces/8-image.jpg");
        avatars.add("https://reqres.in/img/faces/8-image.jpg");
        return avatars;
    }

    public static List<DataColors> addNotSorted() {
        dataColorsList.add(new DataColors(1,"cerulean", 2000, "#98B2D1","15-4020"));
        dataColorsList.add(new DataColors(4,"fuchsia rose", 2008, "#98B2D1","4020"));
        dataColorsList.add(new DataColors(4,"true red", 2003, "#98BD1","400"));
        dataColorsList.add(new DataColors(4,"black", 2005, "#98dfD1","40289"));
        return dataColorsList;
    }

}
