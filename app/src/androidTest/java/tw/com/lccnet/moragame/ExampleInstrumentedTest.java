package tw.com.lccnet.moragame;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import tw.com.lccnet.moragame.object.Computer;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("tw.com.lccnet.moragame", appContext.getPackageName());
    }
    @Test
    public void test(){

        //test func要加test修飾詞
        Computer computer=new Computer();
        final String TAG = "ExampleUnitTest";
        for(int i = 0; i<10; i++){
            //System.out.println(String.valueOf(computer.getRandomMora()));
            Log.d(TAG,String.valueOf(computer.getRandomMora()));

        }

    }
}