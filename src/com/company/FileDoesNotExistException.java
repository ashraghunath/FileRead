package com.company;

public class FileDoesNotExistException extends RuntimeException
{
    public FileDoesNotExistException(String s)
    {
        super(s);
    }
}
