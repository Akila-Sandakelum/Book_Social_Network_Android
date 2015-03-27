package com.google.gson;

import java.lang.reflect.Type;

public abstract interface JsonDeserializer<T>
{
  public abstract T deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
    throws JsonParseException;
}


/* Location:           C:\Users\Akilaz\Desktop\classes_dex2jar.jar
 * Qualified Name:     com.google.gson.JsonDeserializer
 * JD-Core Version:    0.7.0.1
 */