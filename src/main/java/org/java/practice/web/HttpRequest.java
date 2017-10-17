package org.java.practice.web;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang.jin on 17/10/2017.
 */
@Component
public class HttpRequest {

    @Autowired
    private RestTemplate restTemplate;

    private static final String SECRETKEY = "sahdkglalhglsahfoawfepajfdsjfdsjfajfdlfsjjf";

    private static final String URL = "http://vopen.msxf.com";

    private void sendHttpRequest() {
        Object req = new Object();
        String response = restTemplate.postForObject(URL, getFormEntity(req), String.class);
    }

    private HttpEntity<String> getFormEntity(Object params) {
        HttpHeaders headers = getHttpHeaders();
        // 签名处理
        String timestamp = new Long(System.currentTimeMillis()).toString();
        String appid = "vms";
        String data = appid + timestamp + SECRETKEY;
        headers.add("timestamp", timestamp);
        headers.add("appid", appid);
        headers.add("sign", DigestUtils.md5DigestAsHex(data.getBytes()));

        HttpEntity<String> formEntity = new HttpEntity<String>(JSON.toJSONString(params), headers);
        return formEntity;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        List<MediaType> acceptableMediaTypes = new ArrayList<>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);

        headers.setAccept(acceptableMediaTypes);
        headers.setContentType(type);

        //常见Http请求头
        headers.add(HttpHeaders.ACCEPT_CHARSET,"UTF-8");//用于指定客户端接受的字符集
        headers.add(HttpHeaders.ACCEPT_ENCODING,"gzip.deflate");//用于指定可接受的内容编码
        headers.add(HttpHeaders.ACCEPT_LANGUAGE,"zh-cn");//用于指定一种自然语言
        headers.add(HttpHeaders.HOST,"www.baidu.com");//用于指定被请求资源的Internet主机和端口号
        headers.add(HttpHeaders.USER_AGENT,"WIN7;Chrome;Other Atrribute");//客户端将它的操作系统、浏览器和其他属性告诉服务器
        headers.add(HttpHeaders.CONNECTION,"Keep-Alive");//当前连接是否保持

        //常见Http响应头
        headers.add(HttpHeaders.CONTENT_TYPE,"application/json; charset=UTF-8");//用来指明发送给接受者的实体
        headers.add(HttpHeaders.SERVER,"Apache/1.3.6(Unix)");
        headers.add();

        return headers;
    }
}
