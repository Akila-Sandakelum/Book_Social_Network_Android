package com.booknetwork.app;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

class TaskGetWishlist
  extends AsyncTask<Integer, Void, ArrayList<WishlistInfo>>
{
  private final String URL = "http://books.knnect.com/user/wishlist";
  private String response = "";
  
  protected ArrayList<WishlistInfo> doInBackground(Integer... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        JsonObject localJsonObject = new JsonObject();
        localJsonObject.addProperty("credential_id", paramVarArgs[0]);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpPost localHttpPost = new HttpPost("http://books.knnect.com/user/wishlist");
        localHttpPost.setEntity(new StringEntity(localJsonObject.toString()));
        localHttpPost.setHeader("Accept", "application/json");
        localHttpPost.setHeader("Content-type", "application/json");
        InputStream localInputStream = localDefaultHttpClient.execute(localHttpPost).getEntity().getContent();
        InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream);
        BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
        str1 = localBufferedReader.readLine();
        if (str1 != null) {
          continue;
        }
        localInputStream.close();
        Log.i("server output..........", this.response);
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        String str1;
        JsonArray localJsonArray;
        String str2;
        StringBuilder localStringBuilder;
        localClientProtocolException.printStackTrace();
        continue;
      }
      catch (IOException localIOException)
      {
        Gson localGson;
        ArrayList localArrayList;
        Iterator localIterator1;
        Iterator localIterator2;
        localIOException.printStackTrace();
        continue;
        localArrayList.add((WishlistInfo)localGson.fromJson((JsonElement)localIterator1.next(), WishlistInfo.class));
        continue;
        Log.i("list", ((WishlistInfo)localIterator2.next()).toString());
        continue;
      }
      localJsonArray = ((JsonObject)new JsonParser().parse(this.response)).get("wishlist").getAsJsonArray();
      localGson = new Gson();
      localArrayList = new ArrayList();
      localIterator1 = localJsonArray.iterator();
      if (localIterator1.hasNext()) {
        continue;
      }
      localIterator2 = localArrayList.iterator();
      if (localIterator2.hasNext()) {
        continue;
      }
      return localArrayList;
      str2 = this.response;
      localStringBuilder = new StringBuilder(String.valueOf(str2));
      this.response = str1;
    }
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.TaskGetWishlist
 * JD-Core Version:    0.7.0.1
 */