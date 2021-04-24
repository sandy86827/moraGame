package tw.com.lccnet.moragame.object;

public class Player {
    public static final int READY=-1;//常數命名用大寫區分 用final 表示constant
    public static final int SCISSOR=0;//在物件間共享值的時候用static
    public static final int ROCK=1;
    public static final int PAPER=2;

    private int mora;
    protected int life;

    public Player(){
        mora=READY;
        life=3;

    }

    public int getMora() {
        return mora;
    }

    public void setMora(int mora) {
        this.mora = mora;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }



}


