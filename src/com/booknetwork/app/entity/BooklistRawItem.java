package com.booknetwork.app.entity;

public class BooklistRawItem
{
  private int imageId;
  private String quantity;
  private String title;
  
  public BooklistRawItem(int paramInt, String paramString1, String paramString2)
  {
    this.title = paramString1;
    this.quantity = paramString2;
    this.imageId = paramInt;
  }
  
  public int getImageId()
  {
    return this.imageId;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getquantity()
  {
    return this.quantity;
  }
  
  public void setImageId(int paramInt)
  {
    this.imageId = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setquantity(String paramString)
  {
    this.quantity = paramString;
  }
  
  public String toString()
  {
    return "BooklistRawItem [title=" + this.title + ", quantity=" + this.quantity + "]";
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.BooklistRawItem
 * JD-Core Version:    0.7.0.1
 */