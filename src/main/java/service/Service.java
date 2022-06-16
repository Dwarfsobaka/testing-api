package service;

import com.google.common.collect.Ordering;
import data.colors.DataColors;
import data.users.DataUser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.restassured.RestAssured.given;


public class Service {

    public static List<String> getListOfNameFile (List<DataUser> dataUserList){
        List<String> avatars = new ArrayList<>();
        for (int i =0; i < dataUserList.size(); i++){
            avatars.add(dataUserList.get(i).getAvatar());
        }
        return avatars;
    }

    public static boolean isUnique (List<String> avatars){
        List<String> nameOfFiles = new ArrayList<>();
        for (int i =0; i < avatars.size(); i++){
            Pattern r = Pattern.compile("([^/]+\\.[a-z]{3})");
            Matcher m = r.matcher(avatars.get(i));
            if (m.find( )) {
              nameOfFiles.add(m.group());
            }
        }
        Set<String> unik = new HashSet<>();
        unik.addAll(nameOfFiles);
        if (avatars.size() > unik.size()){
            return false;
        }
        else return true;
    }

    public static List<Integer> getListOfYears (List<DataColors> dataColorsList){
        List<Integer> years = new ArrayList<>();
        for (int i =0; i < dataColorsList.size(); i++){
            years.add(dataColorsList.get(i).getYear());
        }
        return years;
    }




}
