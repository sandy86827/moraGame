package tw.com.lccnet.moragame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import tw.com.lccnet.moragame.object.Computer;
import tw.com.lccnet.moragame.object.Player;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Computer.OnComputerCompletedListener {



    private Button start_btn,quit_btn;
    private ImageButton scissors_btn,rock_btn,paper_btn;
    private ImageView computer_img;
    private ImageView player_img;
    private static final String TAG = "MainActivity";//logt
    private Player player;
    private Computer computer;
    private boolean isPlayRound;
    private static final int EVEN =0 ;
    private static final int PLAYER_WIN =1 ;
    private static final int COMPUTER_WIN =2 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();

        computer_img.setImageResource(R.drawable.scissors);
        player_img.setVisibility(View.INVISIBLE);
    }

    private void findID(){

        rock_btn=findViewById(R.id.rock_btn);
        paper_btn=findViewById(R.id.paper_btn);
        scissors_btn=findViewById(R.id.scissors_btn);
        start_btn=findViewById(R.id.start_btn);
        quit_btn=findViewById(R.id.quit_btn);
        computer_img=findViewById(R.id.computer_img);
        player_img=findViewById(R.id.player_img);



        View[] views={rock_btn,paper_btn,scissors_btn,start_btn,quit_btn};
        for(View v:views){
            v.setOnClickListener(this);
        }

//        scissors_btn.setOnClickListener(this);
//        start_btn.setOnClickListener(this);
//        rock_btn.setOnClickListener(this);
//        paper_btn.setOnClickListener(this);
//        quit_btn.setOnClickListener(this);

        player=new Player();
        computer=new Computer();
        computer.setOnComputerCompletedListener(this);
        computer.ai();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.scissors_btn:
                if (isPlayRound){
                    isPlayRound=false;
                    Log.d(TAG,getResources().getString(R.string.scissors));
                    player.setMora(player.SCISSOR);
                    player_img.setImageResource(R.drawable.scissors);
                    player_img.setVisibility(View.VISIBLE);
                    checkGameState();
                }

                break;

                case R.id.paper_btn:
                    if(isPlayRound){
                        isPlayRound=false;
                        Log.d(TAG,getResources().getString(R.string.paper));
                        player.setMora(player.PAPER);
                        player_img.setImageResource(R.drawable.paper);
                        player_img.setVisibility(View.VISIBLE);
                        checkGameState();

                    }
                    break;

            case R.id.rock_btn:
                        if(isPlayRound){
                            isPlayRound=false;
                            Log.d(TAG,getResources().getString(R.string.rock));
                            player.setMora(player.ROCK);
                            player_img.setImageResource(R.drawable.rock);
                            player_img.setVisibility(View.VISIBLE);
                            checkGameState();

                        }

                        break;


            case R.id.start_btn:
                initGame();
                Log.d(TAG,getResources().getString(R.string.start));
                break;

            case R.id.quit_btn:
                Log.d(TAG,getResources().getString(R.string.quit));
                break;


        }
    }

    private void initGame() {
        isPlayRound=false;
        computer.ai();

    }
    public  int getWinState(int playerMora,int computerMora){
        if(playerMora==Player.PAPER&& computerMora==Player.SCISSOR){
            return COMPUTER_WIN;
        }
        if(playerMora==Player.SCISSOR&& computerMora==Player.PAPER){
            return PLAYER_WIN;
        }
        if(playerMora>computerMora){
            return PLAYER_WIN;
        }
        return  COMPUTER_WIN;
    }
    private  void checkGameState(){
        int state=getWinState(player.getMora(),computer.getMora());
        if(state==EVEN){
            Log.d(TAG, "平手");
        }else if(state==COMPUTER_WIN){
            Log.d(TAG, "電腦贏");
        }else if(state==PLAYER_WIN){
            Log.d(TAG, "玩家贏");
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                initGame();
                Log.d(TAG, "init");
            }
        }).start();

    }


    @Override
    public void complete() {

        int mora=computer.getMora();
        handler.sendEmptyMessage(mora);
        Log.d(TAG,String.valueOf(mora));
    }

    private Handler handler=new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    computer_img.setImageResource(R.drawable.scissors);
                    isPlayRound=true;
                    break;
                case 1:
                    computer_img.setImageResource(R.drawable.rock);
                    isPlayRound=true;
                    break;
                case 2:
                    computer_img.setImageResource(R.drawable.paper);
                    isPlayRound=true;
                    break;

            }
        }
    };

}