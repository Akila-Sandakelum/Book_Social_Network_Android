package com.booknetwork.app;

class BookInfo
{
  String author;
  String category;
  String interest_id;
  String isbn;
  String rating;
  String title;
  
  public String getAuthor()
  {
    return this.author;
  }
  
  public String getCategory()
  {
    return this.category;
  }
  
  public String getInterest_id()
  {
    return this.interest_id;
  }
  
  public String getIsbn()
  {
    return this.isbn;
  }
  
  public String getRating()
  {
    return this.rating;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public void setInterest_id(String paramString)
  {
    this.interest_id = paramString;
  }
  
  public String toString()
  {
    return "title : " + this.title + " category : " + this.category + " rating : " + this.rating + " isbn : " + this.isbn + " author : " + this.author + "interest_id : " + this.interest_id;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.BookInfo
 * JD-Core Version:    0.7.0.1
 */