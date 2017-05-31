package com.aw.android.ratelistapp;

import junit.framework.Assert;
import com.aw.android.ratelistapp.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UnitTest{
    @Test
    public void item() throws Exception {
        item i = new item();
        i.setName("Sugar");
        Assert.assertEquals(i.getName(),"Sugar");
    }
    @Test
    public void feedback(){
        feedback f = new feedback("comment","ABC","Store");
        Assert.assertEquals(f.complaint,"comment");
    }
    @Test
    public void user(){
        user u = new user("ABC","xyz@abc.com");
        Assert.assertEquals(u.email,"xyz@abc.com");
    }
}