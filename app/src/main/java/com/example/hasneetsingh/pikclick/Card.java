package com.example.hasneetsingh.pikclick;

/**
 * Created by AVJEET on 07-02-2017.
 */

public class Card {
    private String mName;
    private String mCompanyName;

    Card(String name, String cName) {
        mName = name;
        mCompanyName = cName;
    }

    public String getName() {
        return mName;
    }

    public String getCompanyName() {
        return mCompanyName;
    }

    public String getFirstChar() {
        char letter=mName.charAt(0);
        return Character.toString(letter);

    }
}
