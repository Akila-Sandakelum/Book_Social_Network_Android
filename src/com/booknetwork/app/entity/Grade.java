package com.booknetwork.app.entity;

import java.util.Date;

public class Grade
{
  private String authoriser;
  private BookList bookList;
  private Date date_added;
  private Long grade_id;
  private String name;
  private School school;
  
  public String getAuthoriser()
  {
    return this.authoriser;
  }
  
  public BookList getBookLists()
  {
    return this.bookList;
  }
  
  public Date getDate_added()
  {
    return this.date_added;
  }
  
  public Long getGrade_id()
  {
    return this.grade_id;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public School getSchool()
  {
    return this.school;
  }
  
  public void setAuthoriser(String paramString)
  {
    this.authoriser = paramString;
  }
  
  public void setBookLists(BookList paramBookList)
  {
    this.bookList = paramBookList;
  }
  
  public void setDate_added(Date paramDate)
  {
    this.date_added = paramDate;
  }
  
  public void setGrade_id(Long paramLong)
  {
    this.grade_id = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSchool(School paramSchool)
  {
    this.school = paramSchool;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.Grade
 * JD-Core Version:    0.7.0.1
 */