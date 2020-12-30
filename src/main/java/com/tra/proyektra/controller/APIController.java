/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tra.proyektra.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asus
 */
@Controller
public class APIController {

//    @RequestMapping(value = "/cobaapi")
//    public String cobaapi() {
//        return "api";
//    }

    @RequestMapping(value = "/restapi", method = RequestMethod.GET)
//    @ResponseBody
    public String api(Model model) {

//        public JSONObject readApi(String url)
        JSONObject jObj = null;
        List employees = new ArrayList<>();
//        String pwd = null, mail = null, id = null;
        try {
            OkHttpClient okHttpUtil = new OkHttpClient();
//            okHttpUtil.init(true);

//            Request request = new Request.Builder().url(url).get().addHeader("Authorization", parametersRepo.findApiById(3).getValue()).build();
            Request request = new Request.Builder()
                    .header("Authorization", "sakura eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYWt1cmEiLCJpYXQiOjE1ODAxOTYxMzJ9.zYvu8-qr48lmTx7_3tZMmVmIBuGPVXmgHbFOwSdTAdYZO9FFQWa7rUeKodtfOMkzfnnjVQSl6f_t54_qvlo7cA")
                    .url("http://116.254.101.228:8080/APISAKURAJWT/masterEmployee/gabriel.timur@mii.co.id")
                    .build();
            Response response = okHttpUtil.newCall(request).execute();
            JSONObject jsonobj = new JSONObject(response.body().string());
            JSONArray data = jsonobj.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                jObj = data.getJSONObject(i);
            }
            
            Iterator<String> key = jObj.keys();
            
            while (key.hasNext()) {                
                String key1 = key.next();
                System.out.println(key + "" +jObj.get(key1));
                employees.add(jObj.get(key1));
                
            }
            
        } catch (Exception e) {
            System.out.println("Erorr is = " + e);
        }
        
        Map data = new HashMap();
        data.put("nama", jObj.getString("Name"));
        data.put("email", jObj.getString("Email"));
        data.put("tanggallahir", jObj.getString("Date of Birth"));
        data.put("tempatlahir", jObj.getString("Place of Birth"));
        data.put("alamat", jObj.getString("Address City"));
        data.put("posisi", jObj.getString("Position"));
        
        
        model.addAttribute("datas", data);
        model.addAttribute("employees", employees);
        model.addAttribute("nyoba", jObj.toString());
        
        return "api";
//        return jObj;
    }

}
