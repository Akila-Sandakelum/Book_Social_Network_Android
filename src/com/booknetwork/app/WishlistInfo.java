package com.booknetwork.app;

class WishlistInfo
{
  String author;
  String interest_id;
  String title;
  
  public void WishlistInfo() {}
  
  public String getAuthor()
  {
    return this.author;
  }
  
  public String getInterest_id()
  {
    return this.interest_id;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String toString()
  {
    return "title : " + this.title + " category : " + this.author + " interest_id :" + this.interest_id;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.WishlistInfo
 * JD-Core Version:    0.7.0.1
 */