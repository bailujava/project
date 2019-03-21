package tv.buka.utils;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class HttpClientUtil {

    private String apiURL = "http://a.buka.tv/base/usercenter/user/info.do";
    private HttpClient httpClient = null;
    private HttpPost method = null;
    private int status = 0;
    private static Map<Object, Object> map = new HashMap<Object, Object>();

    public static String doHttpClient(HashMap<String, Object> map, String url) {

        String jsonString = JSONSerializer.toJSON(map).toString();

        String result = "";
        try {
            result = HttpClientUtil.doPostJson(url, jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }

    public HttpClientUtil(String url) {
        System.out.println("url" + url);
        if (url != null) {
            this.apiURL = url;
        }
        if (apiURL != null) {
            System.out.println("apiURL" + apiURL);
            httpClient = new DefaultHttpClient();
            method = new HttpPost(apiURL);
        }
    }

    //加入map并转换为json
    public static JSONObject putMap(String key, Integer model_id, Long user_id, Integer[] target_course_id_list,
                                    String[] sort, String[] sort_by, Integer page, Integer cnt
    ) {
        map.put("key", key);
        map.put("model_id", model_id);
        map.put("user_id", user_id);
        map.put("target_course_id_list", target_course_id_list);
        map.put("sort", sort);
        map.put("sort_by", sort_by);
        map.put("page", page);
        map.put("cnt", cnt);

        return JSONObject.fromObject(map);
    }


    public String post(String parameters) {
        String body = null;
        if (method != null & parameters != null && !"".equals(parameters.trim())) {
            try {

                // 建立一个NameValuePair数组，用于存储欲传送的参数
                method.addHeader("Content-type", "application/json; charset=utf-8");
                method.setHeader("Accept", "application/json");
                method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
                HttpResponse response = httpClient.execute(method);
                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode != HttpStatus.SC_OK) {
                    status = 1;
                }

                body = EntityUtils.toString(response.getEntity());

            } catch (IOException e) {
                // 网络错误
                status = 3;
            } finally {
                System.out.println(status);
            }
        }
        return body;
    }


    public HttpPost getMethod() {
        return method;
    }

    public int getStatus() {
        return status;
    }

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }


    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void setMethod(HttpPost method) {
        this.method = method;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
