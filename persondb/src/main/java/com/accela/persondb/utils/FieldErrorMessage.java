package com.accela.persondb.utils;

public class FieldErrorMessage
{
    private String field;
    private String Message;

    public FieldErrorMessage(String field, String message)
    {
        this.field = field;
        Message = message;
    }

    public String getField()
    {
        return field;
    }

    public void setField(String field)
    {
        this.field = field;
    }

    public String getMessage()
    {
        return Message;
    }

    public void setMessage(String message)
    {
        Message = message;
    }
}
