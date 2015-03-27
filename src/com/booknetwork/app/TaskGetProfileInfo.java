package com.booknetwork.app;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

class TaskGetProfileInfo
  extends AsyncTask<Integer, Void, String[]>
{
  final String URL = "http://books.knnect.com/user/view";
  int output;
  String response = "";
  String[] result;
  
  protected String[] doInBackground(Integer... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        JsonObject localJsonObject1 = new JsonObject();
        localJsonObject1.addProperty("credential_id", paramVarArgs[0]);
        Log.i("output..........", localJsonObject1.toString());
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpPost localHttpPost = new HttpPost("http://books.knnect.com/user/view");
        localHttpPost.setEntity(new StringEntity(localJsonObject1.toString()));
        localHttpPost.setHeader("Accept", "application/json");
        localHttpPost.setHeader("Content-type", "application/json");
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        Log.i("output..........", localJsonObject1.toString());
        InputStream localInputStream = localHttpResponse.getEntity().getContent();
        InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream);
        BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
        str1 = localBufferedReader.readLine();
        if (str1 != null) {
          continue;
        }
        Log.i("profile server output..........", this.response);
        localInputStream.close();
        this.result = new String[5];
        JsonObject localJsonObject2 = (JsonObject)new JsonParser().parse(this.response);
        JsonElement localJsonElement1 = localJsonObject2.get("firstname");
        JsonElement localJsonElement2 = localJsonObject2.get("secondname");
        JsonElement localJsonElement3 = localJsonObject2.get("location");
        JsonElement localJsonElement4 = localJsonObject2.get("dob");
        JsonElement localJsonElement5 = localJsonObject2.get("gender");
        this.result[0] = localJsonElement1.getAsString();
        this.result[1] = localJsonElement2.getAsString();
        this.result[2] = localJsonElement3.getAsString();
        this.result[3] = localJsonElement4.getAsString();
        this.result[4] = localJsonElement5.getAsString();
        Log.i("result array", Arrays.toString(this.result));
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        String str1;
        String str2;
        StringBuilder localStringBuilder;
        localClientProtocolException.printStackTrace();
        continue;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        continue;
      }
      catch (Exception localException)
      {
        continue;
      }
      return this.result;
      str2 = this.response;
      localStringBuilder = new StringBuilder(String.valueOf(str2));
      this.response = str1;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.TaskGetProfileInfo
 * JD-Core Version:    0.7.0.1
 */