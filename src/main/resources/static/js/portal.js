//--------------------------------------------------前台首页的js文件-----------------------------------------------------
$(function(){//机器人回复功能js
    $("#tijiao").click(function(){
        var content=document.getElementById("content").value;
        var httpRequest = new XMLHttpRequest();//第一步：建立所需的对象
        httpRequest.open('GET', '/talk?content='+content, true);//第二步：打开连接  将请求参数写在url中
        httpRequest.send();//第三步：发送请求  将请求参数写在URL中
        /**
         * 获取数据后的处理程序
         */
        httpRequest.onreadystatechange = function () {
            //alert("httpRequest.readyState="+httpRequest.readyState+"-httpRequest.status == "+httpRequest.status);
            if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                var json = httpRequest.responseText;//获取到json字符串，还需解析
                $("#response").html(json);
            }
        };
    });
});