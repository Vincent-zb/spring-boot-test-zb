import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class mainTest {

    public static void main(String[] args) throws Exception {
        String signUrl= ”路径“；

        try{
            List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("phone",phone));
            nameValuePairs.add(new BasicNameValuePair("xytId",String.valueOf(xytId)));
            nameValuePairs.add(new BasicNameValuePair("balance",balance));

            String result=HttpClientObject.sendPost(signUrl,nameValuePairs);
            logger.info("result: = "+result);
            JSONObject jsonObject=JSON.parseObject(result);

            Integer code=Integer.valueOf(jsonObject.getString("code"));
            if(code.equals(0)){
                code1=0L;
            }else if(code.equals(1)){
                code1=1L;
            }else if(code.equals(3)){
                code1=3L;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }





}
