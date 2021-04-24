package tw.com.lccnet.moragame.object;

import java.util.Random;

public class Computer extends Player {
    private OnComputerCompletedListener OnComputerCompletedListener;
    public Computer(){
        life=1;
        //建構子
    }

    public void setOnComputerCompletedListener(OnComputerCompletedListener onComputerCompletedListener) {
        this.OnComputerCompletedListener = onComputerCompletedListener;
    }

    public int getRandomMora(){
        return new Random().nextInt(PAPER+1);//nextInt(0,3)NOT including 3
    }
    public  void ai(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setMora(getRandomMora());
                OnComputerCompletedListener.complete();
            }
        }).start();

    }

    public interface OnComputerCompletedListener{
        //監聽介面實作
        void complete();

        //first step--宣告監聽介面
        //second step--產生屬性
        //third step--建構式
        //forth step--呼叫實作方法
    }
}
