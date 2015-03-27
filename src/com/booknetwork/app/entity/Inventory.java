package com.booknetwork.app.entity;

import java.util.ArrayList;
import java.util.List;

public class Inventory
{
  private List<Book> book = new ArrayList(0);
  private BookList book_list;
  private Bookshop bookshop;
  private Long inventory_id;
  private Integer quantity;
  
  public List<Book> getBook()
  {
    return this.book;
  }
  
  public BookList getBook_list()
  {
    return this.book_list;
  }
  
  public Bookshop getBookshop()
  {
    return this.bookshop;
  }
  
  public Long getInventory_id()
  {
    return this.inventory_id;
  }
  
  public Integer getQuantity()
  {
    return this.quantity;
  }
  
  public void setBook(List<Book> paramList)
  {
    this.book = paramList;
  }
  
  public void setBook_list(BookList paramBookList)
  {
    this.book_list = paramBookList;
  }
  
  public void setBookshop(Bookshop paramBookshop)
  {
    this.bookshop = paramBookshop;
  }
  
  public void setInventory_id(Long paramLong)
  {
    this.inventory_id = paramLong;
  }
  
  public void setQuantity(Integer paramInteger)
  {
    this.quantity = paramInteger;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.Inventory
 * JD-Core Version:    0.7.0.1
 */