package com.booknetwork.app.entity;

public class WishListRawItem
{
  private String author;
  private int imageId;
  private String interest_id;
  private String title;
  
  public WishListRawItem(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.imageId = paramInt;
    this.title = paramString1;
    this.author = paramString2;
    this.interest_id = paramString3;
  }
  
  public String getAuthor()
  {
    return this.author;
  }
  
  public int getImageId()
  {
    return this.imageId;
  }
  
  public String getInterest_id()
  {
    return this.interest_id;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setAuthor(String paramString)
  {
    this.author = paramString;
  }
  
  public void setImageId(int paramInt)
  {
    this.imageId = paramInt;
  }
  
  public void setInterest_id(String paramString)
  {
    this.interest_id = paramString;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    return this.title + "\n" + this.author;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.WishListRawItem
 * JD-Core Version:    0.7.0.1
 */