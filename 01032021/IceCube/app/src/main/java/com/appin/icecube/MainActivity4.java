package com.appin.icecube;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity4 extends Activity {
    //public static final String JSON_STRING="{\"employee\":{\"name\":\"Sachin\",\"salary\":56000}}";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        /*TextView textView1=(TextView)findViewById(R.id.textView1);

        try{
            JSONObject emp=(new JSONObject(JSON_STRING)).getJSONObject("employee");
            String empname=emp.getString("name");
            int empsalary=emp.getInt("salary");

            String str="Employee Name:"+empname+"\n"+"Employee Salary:"+empsalary;
            textView1.setText(str);

        }catch (Exception e) {e.printStackTrace();}*/
        TextView output = (TextView) findViewById(R.id.textView1);

        String strJson="{ \"Employee\" :[{\"id\":\"101\",\"name\":\"Sonoo Jaiswal\",\"salary\":\"50000\"},{\"id\":\"102\",\"name\":\"Vimal Jaiswal\",\"salary\":\"60000\"}] }";

        String data = "";
        try {
            // Create the root JSONObject from the JSON string.
            JSONObject  jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");

            //Iterate the jsonArray and print the info of JSONObjects
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n ";
            }
            output.setText(data);
        } catch (JSONException e) {e.printStackTrace();}

    }

}
