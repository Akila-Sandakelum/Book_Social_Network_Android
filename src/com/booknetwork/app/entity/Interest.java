package com.booknetwork.app.entity;

public class Interest
{
  private BasicUser basic_user;
  private Long interest_id;
  private Short rating;
  private String status;
  
  public BasicUser getBasic_user()
  {
    return this.basic_user;
  }
  
  public Long getInterest_id()
  {
    return this.interest_id;
  }
  
  public Short getRating()
  {
    return this.rating;
  }
  
  public String getStatus()
  {
    return this.status;
  }
  
  public void setBasic_user(BasicUser paramBasicUser)
  {
    this.basic_user = paramBasicUser;
  }
  
  public void setInterest_id(Long paramLong)
  {
    this.interest_id = paramLong;
  }
  
  public void setRating(Short paramShort)
  {
    this.rating = paramShort;
  }
  
  public void setStatus(String paramString)
  {
    this.status = paramString;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.Interest
 * JD-Core Version:    0.7.0.1
 */