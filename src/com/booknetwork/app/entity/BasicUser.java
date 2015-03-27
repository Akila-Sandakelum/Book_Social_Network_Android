package com.booknetwork.app.entity;

import java.util.Date;

public class BasicUser
{
  private Long basic_user_id;
  private Date date_of_birth;
  private String gender;
  private Profile profile;
  
  public Long getBasic_user_id()
  {
    return this.basic_user_id;
  }
  
  public Date getDate_of_birth()
  {
    return this.date_of_birth;
  }
  
  public String getGender()
  {
    return this.gender;
  }
  
  public Profile getProfile()
  {
    return this.profile;
  }
  
  public void setBasic_user_id(Long paramLong)
  {
    this.basic_user_id = paramLong;
  }
  
  public void setDate_of_birth(Date paramDate)
  {
    this.date_of_birth = paramDate;
  }
  
  public void setGender(String paramString)
  {
    this.gender = paramString;
  }
  
  public void setProfile(Profile paramProfile)
  {
    this.profile = paramProfile;
  }
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.booknetwork.app.entity.BasicUser
 * JD-Core Version:    0.7.0.1
 */