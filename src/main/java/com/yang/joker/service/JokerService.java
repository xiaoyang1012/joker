package com.yang.joker.service;

import org.springframework.stereotype.Service;

@Service
public class JokerService {

    public String talk(String value){
       if(value.contains("你好")){
           return "你好你好，我是yxl机器人，你呢？？";
       } else if(value.contains("吃饭")){
           return "又吃饭，你是饭桶吗？";
        }else if(value.contains("讲个笑话吧")||value.contains("笑话")){
           return "笑话？你就是最大的笑话  hiahia";
       }else if(value.contains("你是")){
           return "我是你爸爸~~哈哈";
       }else if(value.contains("美女")||value.contains("黄色")||value.contains("女")){
           return "我怀疑你在开车，但是我没有证据~~~~~";
       }else{
           return "我有点不理解你讲的话哦，，，";
       }
    }
}
