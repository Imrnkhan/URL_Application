package com.example.url_application.service;

import lombok.var;
import org.springframework.stereotype.Service;

@Service
public class BaseConversion {
    public BaseConversion() {
    }

    private static  final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
private  char[] allowedCharacter = allowedString.toCharArray();
private int base = allowedCharacter.length;


public  String encode(long input){
    var encodedString = new StringBuilder();


    if(input==0){
        return String.valueOf(allowedCharacter[0]);
    }
    while (input>0){
        encodedString.append(allowedCharacter[(int) (input%base)]);
        input = input/base;
    }
    return encodedString.reverse().toString();
}
public long decode(String input){
    var character = input.toCharArray();
    var length = character.length;
    var decoded = 0;

    var counter =1;
    for(int i =0;i<length;i++){
        decoded+=allowedString.indexOf(character[i])*Math.pow(base,length-counter);
counter++;

    }
    return decoded;
}
}
