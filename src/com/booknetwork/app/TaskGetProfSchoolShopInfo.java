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

class TaskGetProfSchoolShopInfo
  extends AsyncTask<String, Void, Integer>
{
  final String URL_SCHOOL = "http://books.knnect.com/school/update";
  final String URL_SHOP = "http://books.knnect.com/bookshop/update";
  String response = "";
  int result;
  String url;
  
  protected Integer doInBackground(String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        JsonObject localJsonObject = new JsonObject();
        localJsonObject.addProperty("username", paramVarArgs[0]);
        localJsonObject.addProperty("password", paramVarArgs[1]);
        localJsonObject.addProperty("name", paramVarArgs[2]);
        localJsonObject.addProperty("location", paramVarArgs[3]);
        localJsonObject.addProperty("credential_id", paramVarArgs[4]);
        Log.i("output..........", localJsonObject.toString());
        Log.i("output@@@@@@@@@@@..........", paramVarArgs[5]);
        if (!paramVarArgs[5].equals("School")) {
          continue;
        }
        this.url = "http://books.knnect.com/school/update";
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpPost localHttpPost = new HttpPost(this.url);
        localHttpPost.setEntity(new StringEntity(localJsonObject.toString()));
        localHttpPost.setHeader("Accept", "application/json");
        localHttpPost.setHeader("Content-type", "application/json");
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        Log.i("output..........", localJsonObject.toString());
        localInputStream = localHttpResponse.getEntity().getContent();
        localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        InputStream localInputStream;
        BufferedReader localBufferedReader;
        String str;
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
      this.result = ((JsonObject)new JsonParser().parse(this.response)).get("credential_id").getAsInt();
      return Integer.valueOf(this.result);
      this.url = "http://books.knnect.com/bookshop/update";
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.TaskGetProfSchoolShopInfo
 * JD-Core Version:    0.7.0.1
 */