package org.java.enterprise.http_crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取需要重试的订单
 *
 * @author jinyang
 * @date 2019/2/28 0028.
 */
public class GetNeedRetryOrderList {

    public static void main(String[] args) {
        getNeedRetryOrderList();
    }

    private static void getNeedRetryOrderList() {

        // 获取所有需要重试的订单
        String resp = getAllNeedRetryOrders();

        Document html = Jsoup.parse(resp);
        Elements tableEles = html.getElementsByClass("ui-record-table");
        Element table = tableEles.first();
        Elements trs = table.select("tr");

        for (Element tr : trs) {
            // 获取一个tr
            // 获取该行的所有td节点
            Elements tds = tr.select("td");
            if (tds.size() == 0) {
                continue;
            }
            Element bizTradeNoElement = tds.first();
            String bizTradeNo = bizTradeNoElement.text();
            if (bizTradeNo.startsWith("2") || bizTradeNo.startsWith("5")) {
                String tradeCode = tds.get(6).text();
                if ("ACC3030007".equals(tradeCode) && bizTradeNo.length() < 22) {
                    // 代付重试
                    String retryResult = retry(bizTradeNo);
                    System.out.println(bizTradeNo + ":" + retryResult);
                }
            }
        }


    }

    private static String getAllNeedRetryOrders() {
        try {
            // 请求地址URL
            String url = "http://jie-baitiao.jdfmgt.com/wallet/defray/fail/list";
            // 请求头
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            headers.put("Accept-Encoding", "gzip, deflate, sdch");
            headers.put("Accept-Language", "zh-CN,zh;q=0.8");
            headers.put("Connection", "keep-alive");
            headers.put("Cookie", "sso.jd.com=759b089feb634bbda006099381079513; ticket_crpl_console=dba8983f3f81cf26f0e02315f6ef6ee466c313d77e9eabffb053f7f07d393dab061cec70110f4f085a7e7ea57a238db5535ddefd3ef5ce7bbe3c2804b6c4a143; JSESSIONID=CF61A4422F045C0C4ED88A3FFCA8109A");
            headers.put("Host", "jie-baitiao.jdfmgt.com");
            headers.put("Referer", "http://jie-baitiao.jdfmgt.com/");
            headers.put("Upgrade-Insecure-Requests", "1");
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 SE 2.X MetaSr 1.0");
            // 提交表单参数
            Map<String, String> params = new HashMap<String, String>();
            params.put("pageNum", "1");
            params.put("pageSize", "4000");//todo
            // 网络参数
            Integer connectTimeout = 10000;
            Integer readTimeOut = 1000 * 60 * 60 * 24;

            // 发POST请求
            return HttpClientUtil.postForm(url, params, headers, connectTimeout, readTimeOut);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static String retry(String biztradeNo) {
        try {
            // 请求地址URL
            String url = "http://jie-baitiao.jdfmgt.com/wallet/defray/fail/retry?bizTradeNo=" + biztradeNo;
            // 请求头
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Accept", "*/*");
            headers.put("Accept-Encoding", "gzip, deflate");
            headers.put("Accept-Language", "zh-CN,zh;q=0.8");
            headers.put("Connection", "keep-alive");
//            headers.put("Content-Length", "0");
            headers.put("Cookie", "ticket_crpl_console=dba8983f3f81cf26f0e02315f6ef6ee466c313d77e9eabffb053f7f07d393dab061cec70110f4f085a7e7ea57a238db5535ddefd3ef5ce7bbe3c2804b6c4a143; JSESSIONID=CF61A4422F045C0C4ED88A3FFCA8109A; sso.jd.com=82667395a72748d6a307c52b0a3c87cb");
            headers.put("Host", "jie-baitiao.jdfmgt.com");
            headers.put("Origin", "http://jie-baitiao.jdfmgt.com");
            headers.put("Referer", "http://jie-baitiao.jdfmgt.com/wallet/defray/fail/list");
            headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 SE 2.X MetaSr 1.0");
            headers.put("X-Requested-With", "XMLHttpRequest");
            // 提交表单参数
//            Map<String, String> params = new HashMap<String, String>();
//            params.put("bizTradeNo", biztradeNo);
            // 网络参数
            Integer connectTimeout = 10000;
            Integer readTimeOut = 1000 * 60 * 60 * 24;

            // 发POST请求
            return HttpClientUtil.postForm(url, null, headers, connectTimeout, readTimeOut);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
