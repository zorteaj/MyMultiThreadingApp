package com.jzap.mymultithreadingapp;

/**
 * Created by Justin on 10/18/2014.
 */
public class TheManager {

    private static TheManager sInstance;

    static {
        sInstance = new TheManager();
    }
}
