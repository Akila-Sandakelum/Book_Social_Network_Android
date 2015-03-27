package com.booknetwork.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Category
{
  private List<Book> books = new ArrayList(0);
  private Long category_id;
  private String name;
  
  public List<Book> getBooks()
  {
    return this.books;
  }
  
  public Long getCategory_id()
  {
    return this.category_id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setBooks(List<Book> paramList)
  {
    this.books = paramList;
  }
  
  public void setCategory_id(Long paramLong)
  {
    this.category_id = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.Category
 * JD-Core Version:    0.7.0.1
 */