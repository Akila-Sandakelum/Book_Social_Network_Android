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
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

class TaskGetSchool_Shop_Profinfo
  extends AsyncTask<String, Void, String[]>
{
  final String URL_SCHOOL = "http://books.knnect.com/school/view";
  final String URL_SHOP = "http://books.knnect.com/bookshop/view";
  String response = "";
  String[] result;
  String url;
  
  protected String[] doInBackground(String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        JsonObject localJsonObject1 = new JsonObject();
        localJsonObject1.addProperty("credential_id", paramVarArgs[0]);
        Log.i("output..........", localJsonObject1.toString());
        if (!paramVarArgs[1].equals("School")) {
          continue;
        }
        this.url = "http://books.knnect.com/school/view";
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpPost localHttpPost = new HttpPost(this.url);
        localHttpPost.setEntity(new StringEntity(localJsonObject1.toString()));
        localHttpPost.setHeader("Accept", "application/json");
        localHttpPost.setHeader("Content-type", "application/json");
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        Log.i("output..........", localJsonObject1.toString());
        localInputStream = localHttpResponse.getEntity().getContent();
        localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        InputStream localInputStream;
        BufferedReader localBufferedReader;
        String str;
        JsonObject localJsonObject2;
        JsonElement localJsonElement1;
        JsonElement localJsonElement2;
        localClientProtocolException.printStackTrace();
        continue;
        this.response += str;
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
      str = localBufferedReader.readLine();
      if (str != null) {
        continue;
      }
      Log.i("profile server output..........", this.response);
      localInputStream.close();
      this.result = new String[2];
      localJsonObject2 = (JsonObject)new JsonParser().parse(this.response);
      localJsonElement1 = localJsonObject2.get("name");
      localJsonElement2 = localJsonObject2.get("location");
      this.result[0] = localJsonElement1.getAsString();
      this.result[1] = localJsonElement2.getAsString();
      return this.result;
      this.url = "http://books.knnect.com/bookshop/view";
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.TaskGetSchool_Shop_Profinfo
 * JD-Core Version:    0.7.0.1
 */