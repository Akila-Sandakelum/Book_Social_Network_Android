package com.booknetwork.app.entity;

public class SchoolBooklistRawItem
{
  private String author;
  private int imageId;
  private String title;
  
  public SchoolBooklistRawItem(int paramInt, String paramString1, String paramString2)
  {
    this.title = paramString1;
    this.author = paramString2;
    this.imageId = paramInt;
  }
  
  public String getAuthor()
  {
    return this.author;
  }
  
  public int getImageId()
  {
    return this.imageId;
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
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public String toString()
  {
    return "SchoolBooklistRawItem [title=" + this.title + ", author=" + this.author + ", imageId=" + this.imageId + "]";
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.SchoolBooklistRawItem
 * JD-Core Version:    0.7.0.1
 */