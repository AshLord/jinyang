package org.java.enterprise.http_crawler;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberUtil {


    /**
     * 访问url
     *
     * @param url 访问url
     * @return url
     */
    private static String getUrl(String url) {
        return url;
    }

    /**
     * 查询参数
     * @param text
     * @return
     */
    private static Map<String, String> getParams(String text) {
        // 查询参数
        Map<String, String> params = new HashMap<String, String>();
        params.put("preText", text);
        params.put("type", "DECRYPT");
        return params;
    }

    /**
     * 请求头参数配置
     *
     * @return
     */
    private static Map<String, String> getHeaders(String cookie) {
        // 请求头参数
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Accept", "application/json, text/javascript, */*; q=0.01");
        headers.put("Accept-Encoding", "gzip, deflate");
        headers.put("Accept-Language", "zh-CN,zh;q=0.9");
        headers.put("Connection", "keep-alive");
//        headers.put("Content-Length", "149"); 请求头中有默认长度，加上会报错
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Cookie", cookie);
        headers.put("Host", "jie-baitiao.jdfmgt.com");
        headers.put("Origin", "http://jie-baitiao.jdfmgt.com");
        headers.put("Referer", "http://jie-baitiao.jdfmgt.com/encryption/index");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
        headers.put("X-Requested-With", "XMLHttpRequest");
        return headers;
    }

    private static String queryData(String url, Map<String, String> params, Map<String, String> headers) {
        if (StringUtils.isBlank(url) || params == null || headers == null) {
            System.out.println("queryData| 丢失参数");
            return null;
        }
        // 返回结果
        try {
//            logger.info("queryData| 方法开始执行: url = " + url + " 表单参数 = " + JSONObject.toJSONString(params) + " 请求头参数 = " + JSONObject.toJSONString(headers));
            String ret = HttpClientUtil.postForm(url, params, headers, 10000, 1000 * 60 * 60 * 24);
            JSONObject jsonRet = JSONObject.parseObject(ret);
            if ("00000".equals(jsonRet.getString("code"))) {
                return jsonRet.getString("data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("系统异常");
        return null;
    }

    private static void readTxt() {
        String pathUrl = "D:/123123.txt";
        FileReader reader = null;
        BufferedReader br = null;
        try {
             reader = new FileReader(pathUrl);
             br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                System.out.println(queryData(getUrl("http://jie-baitiao.jdfmgt.com/encryption/encryption"), getParams(line), getHeaders("sso.jd.com=4daf4f6fdd0141e4968b562f1ce98a2a; ST-MEM=e14d4ab6ec434837b5ac922b1bdba049; JSESSIONID=C6E016315567AE7C5CE13498D8E7EE48")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PhoneNumberUtil.readTxt();
//        System.out.println(queryData(getUrl("http://jie-baitiao.jdfmgt.com/encryption/encryption"), getParams("T1lKigU+Yx9C8hEM06kdUA=="), getHeaders("sso.jd.com=fb72284494cb4435863d816c46047f73; ST-MEM=36c765094e0940a8bfb3f7b9d38ef579; JSESSIONID=71006117C74B059E64200501E11872FD")));
    }
}
