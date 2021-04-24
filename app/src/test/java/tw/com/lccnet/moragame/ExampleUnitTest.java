package tw.com.lccnet.moragame;

import android.util.Log;

import org.junit.Test;
import org.testng.annotations.AfterTest;

import tw.com.lccnet.moragame.object.Computer;
import tw.com.lccnet.moragame.object.Player;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {

        Player player;
        Computer computer;
        final String TAG = "ExampleUnitTest";


//        player=new Player();
//        computer=new Computer();
//        for(int i = 0; i<10; i++){
//            Log.d(TAG,String.valueOf(computer.getRandomMora()));
//
//        }

        assertEquals(4, 2 + 2);

    }
    @Test
    public void test(){

        //test func要加test修飾詞
        Computer computer=new Computer();
        final String TAG = "ExampleUnitTest";
        for(int i = 0; i<10; i++){
            System.out.println(String.valueOf(computer.getRandomMora()));
            //Log.d(TAG,String.valueOf(computer.getRandomMora()));
            //log 是 android類 要到androidTest才能跑

        }

    }
}