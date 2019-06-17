package com.yang.joker.controller;

import com.yang.joker.utils.ClientIpUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;

@RestController
public class JokerController {
    @RequestMapping("/talk")
    public String chat(@RequestParam(value = "content", defaultValue = "你好")String content,
                        HttpServletRequest request) throws IOException {
        //request.setCharacterEncoding("utf-8");

        String APIKEY = "7d14fa4bc295404a9fced576c37453e5"; //图灵机器人的apikey
        String getURL = "http://www.tuling123.com/openapi/api?key=" + APIKEY + "&info=" + content;
        URL getUrl = new URL(getURL);
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        connection.connect();
        // 取得输入流，并使用Reader读取
        BufferedReader reader = new BufferedReader(new InputStreamReader( connection.getInputStream(), "utf-8"));
        StringBuffer sb = new StringBuffer();
        String line = "";
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        // 断开连接
        connection.disconnect();
       // PrintWriter out = response.getWriter();
        System.out.println("获取："+content);
        System.out.println("返回："+sb.toString());
       // out.println(sb.toString());
       // out.close();
        String res=sb.toString();
        String str=res.substring(res.indexOf("\"text\":\"")+"\"text\":\"".length(),res.indexOf("\"}"));
        return str;
    }

}
