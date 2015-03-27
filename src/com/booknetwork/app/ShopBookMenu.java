package com.booknetwork.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ShopBookMenu
  extends Activity
  implements View.OnClickListener
{
  int user_id;
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131361991: 
      Intent localIntent3 = new Intent(paramView.getContext(), Profile.class);
      localIntent3.putExtra("credential_id", this.user_id);
      localIntent3.putExtra("source", "Menu");
      startActivityForResult(localIntent3, 0);
      return;
    case 2131361990: 
      Intent localIntent2 = new Intent(paramView.getContext(), MyLibrary.class);
      localIntent2.putExtra("credential_id", this.user_id);
      localIntent2.putExtra("source", "Menu");
      startActivityForResult(localIntent2, 0);
      return;
    }
    Intent localIntent1 = new Intent(paramView.getContext(), Wishlist.class);
    localIntent1.putExtra("credential_id", this.user_id);
    localIntent1.putExtra("source", "Menu");
    startActivityForResult(localIntent1, 0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903068);
    Bundle localBundle = getIntent().getExtras();
    if (localBundle.containsKey("credential_id")) {
      this.user_id = Integer.parseInt(localBundle.getString("credential_id"));
    }
    Button localButton1 = (Button)findViewById(2131361991);
    Button localButton2 = (Button)findViewById(2131361990);
    Button localButton3 = (Button)findViewById(2131361989);
    localButton1.setOnClickListener(this);
    localButton2.setOnClickListener(this);
    localButton3.setOnClickListener(this);
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.ShopBookMenu
 * JD-Core Version:    0.7.0.1
 */