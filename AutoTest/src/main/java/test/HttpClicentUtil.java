package test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClicentUtil {

    public static String jsonPost(String url,String params,boolean isToken) throws Exception{
        //1、创建request（请求）
        HttpPost post = new HttpPost(url);
        //2、添加请求头
        post.setHeader("", "");
       // post.setHeader(Constants.HEADER_NAME, Constants.HEADER_VALUE);
        //2.1判断是否需要鉴权
        if(isToken){
           // VariableUtils.getToken(post);
        }
        //3、添加入参
        post.setEntity(new StringEntity(params, "UTF-8"));
        //4、发送接口
        CloseableHttpClient client = HttpClients.createDefault();
        //5、接收响应结果
        CloseableHttpResponse response = client.execute(post);
        //6、格式化响应结果
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        return body;
    }

    //调用的获取鉴权函数（getToken()）
/*    public static void getToken(HttpRequest post){
        //1、从map中获取鉴权值
        String token = env.get("access_token");
        //2、判断值不为空，则传入到头参数中
        if(token != null){
            post.setHeader("access_token",token);
        }
    }*/
}
