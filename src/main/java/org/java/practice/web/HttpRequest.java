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
        headers.add(HttpHeaders.PRAGMA,"no-cache");//设置不访问缓存，直接访问服务器
        headers.add(HttpHeaders.CACHE_CONTROL,"no-cache");//设置不访问缓存，直接访问服务器
        headers.add(HttpHeaders.EXPIRES,"Sat,25 Feb 2012 12:22:17 GMT");//缓存失效时间
        headers.add(HttpHeaders.LAST_MODIFIED,"Sat,25 Feb 2012 12:22:17 GMT");//服务器上资源的最后修改时间
        headers.add(HttpHeaders.IF_MODIFIED_SINCE,"Sat,25 Feb 2012 12:22:17 GMT");//询问当前缓存的页面是否是最新的，若果是最新的就返回304，告诉浏览器是最新的，服务器也不会传输新的数据
        headers.add(HttpHeaders.ETAG,"74912734665134780929884");//和IF_MODIFIED_SINCE差不多，只不过是唯一编号


        //常见Http响应头
        headers.add(HttpHeaders.SERVER,"Apache/1.3.6(Unix)");
        headers.add(HttpHeaders.CONTENT_TYPE,"application/json; charset=UTF-8");//用来指明发送给接受者的实体
        headers.add(HttpHeaders.ACCEPT_ENCODING,"gzip.deflate");//用于指定可接受的内容编码
        headers.add(HttpHeaders.ACCEPT_LANGUAGE,"zh-cn");//用于指定一种自然语言
        headers.add(HttpHeaders.CONTENT_LENGTH,"2048");//指明实体正文的长度，用以字节方式存储的十进制数字来表示

        /**
         * 1xx：指示信息--表示请求已接收，继续处理。
         2xx：成功--表示请求已被成功接收、理解、接受。
         3xx：重定向--要完成请求必须进行更进一步的操作。
         4xx：客户端错误--请求有语法错误或请求无法实现。
         5xx：服务器端错误--服务器未能实现合法的请求。
         */
        return headers;
    }
}
