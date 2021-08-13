package test;


import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test1 {

    /*
    　　这里列出一些常见用法：

　　　　（1）使用步骤：

　　　　　　1. 创建HttpClient对象。

　　　　　　2. 创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，创建HttpPost对象。

　　　　　　3. 如果需要发送请求参数，可调用HttpGet、HttpPost共同的setParams(HetpParams params)方法来添加请求参数；
                对于HttpPost对象而言，也可调用setEntity(HttpEntity entity)方法来设置请求参数。

　　　　　　4. 调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。

　　　　　　5. 调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；
                调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。

　　　　　　6. 释放连接。无论执行方法是否成功，都必须释放连接

     */

    public void jkTest() {

        CloseableHttpClient aDefault = HttpClients.createDefault();//1

        HttpPost hg = new HttpPost("");//设置请求连接
        List<NameValuePair> fromValue = new ArrayList<NameValuePair>(); //设置请求参数
        fromValue.add(new BasicNameValuePair("", ""));

        UrlEncodedFormEntity urlEncodedFormEntity;
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(fromValue, "utf-8");//设置请求头
            hg.setEntity(urlEncodedFormEntity);
            CloseableHttpResponse execute = aDefault.execute(hg);//发送请求
            Header[] allHeaders = execute.getAllHeaders();//获取请求头所有信息
            Header[] headers = execute.getHeaders("");//获取请求头
            execute.getStatusLine().getStatusCode();//响应状态
            HttpEntity entity = execute.getEntity();//获取请求相应响应信息
            entity.getContentLength();//获取请求响应内容长度
            EntityUtils.toString(entity);//获取请求响应信息。



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                aDefault.close();//关闭连接
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void getTest(){

        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpGet hg  = new HttpGet("");
        List<NameValuePair> nvp = new ArrayList<NameValuePair>();
        nvp.add(new BasicNameValuePair("",""));

        try {
            CloseableHttpResponse execute = aDefault.execute(hg);
            execute.getStatusLine().getStatusCode();
            execute.getStatusLine().getProtocolVersion();//HTTP/1.1
            execute.getStatusLine().getReasonPhrase();//行
            HttpEntity entity = execute.getEntity();
            EntityUtils.consume(entity);
            String s = EntityUtils.toString(entity);
            Document parse = Jsoup.parse(s);
            Element elementById = parse.getElementById("");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                aDefault.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    /**
     * 解析
     */
/*    public void jxTest(){
        HttpPost hp = new HttpPost("");//设置请求连接
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("loginname","ss"));
        nvps.add(new BasicNameValuePair("password", "s123"));
        hp.setEntity(new UrlEncodedFormEntity(nvps));
        HttpResponse res = Client.execute(hp);
        html = EntityUtils.toString(res.getEntity());
　　　　　　　　JSONObject obj = JSON.parseObject(html);//这里用了fastjson，把String类型的html转换成JSON对象，若有多个，可转换成数组
　　　　　　　　Iterator it = obj.keySet().iterator();
　　　　　　　　while(it.hasNext()){
　　　　　　　　　　String key = it.next().toString();
　　　　　　　　　　if(key.equals("Success")){
　　　　　　　　　　html = obj.get(key).toString();
　　　　　　　　　　}
　　　　　　　　}
    }*/


/*    public void upload() {
                 CloseableHttpClient httpclient = HttpClients.createDefault();
                 try {
                         HttpPost httppost = new HttpPost("http://localhost:8080/myDemo/Ajax/serivceFile.action");

                         FileBody bin = new FileBody(new File("F:\\image\\sendpix0.jpg"));
                        StringBody comment = new StringBody("A binary file of some kind", ContentType.TEXT_PLAIN);

                         HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("bin", bin).addPart("comment", comment).build();

                        httppost.setEntity(reqEntity);

                         System.out.println("executing request " + httppost.getRequestLine());
                        CloseableHttpResponse response = httpclient.execute(httppost);
                         try {
                                 System.out.println("----------------------------------------");
                               System.out.println(response.getStatusLine());
                                 HttpEntity resEntity = response.getEntity();
                                 if (resEntity != null) {
                                        System.out.println("Response content length: " + resEntity.getContentLength());
                                    }
                                 EntityUtils.consume(resEntity);
                             } finally {
                                 response.close();
                             }
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                         e.printStackTrace();
                    } finally {
                         try {
                                 httpclient.close();
                             } catch (IOException e) {
                                 e.printStackTrace();
                             }
                    }
             }*/
}
