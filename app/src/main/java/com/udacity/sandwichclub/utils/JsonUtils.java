package com.udacity.sandwichclub.utils;

import android.util.Base64;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {


      //  List<Sandwich> Sandwiches ;
        Sandwich sandwich;

        String mainName;
        List<String> alsoKnownAs=null;
        String placeOfOrigin;
        String description;
        String image;
        List<String> ingredients = null;






        JSONObject jsonObject=new JSONObject(json);



            JSONObject name=jsonObject.getJSONObject("name");
           mainName=name.getString("mainName");

             placeOfOrigin=jsonObject.getString("String placeOfOrigin");
           description=jsonObject.getString("description");
             image=jsonObject.getString("image");


             JSONArray alsoKnownAsArry=name.getJSONArray("alsoKnownAs");
            alsoKnownAs=new ArrayList<>();

            if(alsoKnownAsArry.length() !=0){

                for(int j=0;j<alsoKnownAsArry.length();j++){

                    alsoKnownAs.add(alsoKnownAsArry.getString(j));
                   // alsoKnownAsArry.getString(j);

                }
            }
            JSONArray ingredientsArry=jsonObject.getJSONArray("ingredients");
             ingredients=new ArrayList<>();

            if(ingredientsArry.length() !=0){

                for(int j=0;j<ingredientsArry.length();j++){
                    ingredients.add(ingredientsArry.getString(j));


                }
            }



             sandwich =new Sandwich(mainName, alsoKnownAs,placeOfOrigin,description,image,ingredients);





          return sandwich;
    }



   // }
}
