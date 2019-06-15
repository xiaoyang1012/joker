package com.yang.joker.controller;

import com.yang.joker.entity.student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {
    @RequestMapping("/")
    public String init(Model model,HttpServletRequest request){

        System.out.println("request.getRemoteAddr()---"+request.getRemoteAddr());
        System.out.println("request.getSession().getId()---"+request.getSession().getId());

        List<String> users=new ArrayList();
        users.add("yang");
        users.add("yang1");
        users.add("yang2");

        String aboutMe="李小龙（1940年11月27日-1973年7月20日），原名李振藩，师承叶问，出生于美国加州旧金山，祖籍中国广东省佛山市顺德区均安镇，世界武道变革先驱者、武术技击家、武术哲学家、MMA之父、武术宗师、功夫片的开创者和截拳道创始人、华人武打电影演员，中国功夫首位全球推广者、好莱坞首位华人主角。他在香港的四部半电影3次打破多项记录，其中《猛龙过江》打破了亚洲电影票房记录，与好莱坞合作的《龙争虎斗》全球总票房达2.3亿美元。 [1-2] \n" +
                "1962年李小龙开办“振藩国术馆”，1967年自创截拳道，1973年7月20日，李小龙在香港逝世，年仅33岁。1979年美国洛杉矶市政府将补拍版《死亡游戏》的开映日6月8日定为“李小龙日”（7月8日为错误翻译）。1993年美国发行李小龙逝世20周年纪念钞票，好莱坞大道铺上李小龙纪念星徽；同年，获香港电影金像奖大会颁发“终身成就奖”。1998年11月，获中国武术协会颁发“武术电影巨星奖”。";
        student student=new student("yang","25",45,"男");

        model.addAttribute("users",users);
        model.addAttribute("student",student);
        model.addAttribute("aboutMe",aboutMe);

        return "hello";
    }
}
