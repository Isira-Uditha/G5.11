package com.example.eventplanner;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    GuestHome guestHome;

    @Before
    public void setup(){
        guestHome = new GuestHome();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testNotInvitedCount(){

        int results = guestHome.GuestNotInvited(4,2);
        assertEquals(2,results);

    }


}