package mx.edu.ittepic.tpdm_u4_practica1_juanmejia;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText rondas,p1res,p2res,p3res;
    ImageView p1d1,p1d2,p2d1,p2d2,p3d1,p3d2;
    TextView p1t,p2t,p3t;
    Button inicio;
    int d1=0,d2=0,r1 = 0,r2 = 0,r3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rondas = findViewById(R.id.rondas);
        p1res = findViewById(R.id.p1res);
        p2res = findViewById(R.id.p2res);
        p3res = findViewById(R.id.p3res);
        p1d1 = findViewById(R.id.p1d1);
        p1d2 = findViewById(R.id.p1d2);
        p2d1 = findViewById(R.id.p2d1);
        p2d2 = findViewById(R.id.p2d2);
        p3d1 = findViewById(R.id.p3d1);
        p3d2 = findViewById(R.id.p3d2);
        p1t = findViewById(R.id.p1t);
        p2t = findViewById(R.id.p2t);
        p3t = findViewById(R.id.p3t);
        inicio = findViewById(R.id.inicio);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread thread = new Thread() {
                    public void run() {
                        int cont = 0;
                        final int[] p1 = {0};
                        final int[] p2 = {0};
                        final int[] p3 = {0};
                        while (cont < 4) {
                            final int rnds = cont;

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    d1 = (int) (Math.random() * 6) + 1;
                                    d2 = (int) (Math.random() * 6) + 1;
                                    cambiaimg(d1, p1d1);
                                    cambiaimg(d2, p1d2);
                                    r1 = d1 + d2;
                                    p1[0] += r1;

                                    d1 = (int) (Math.random() * 6) + 1;
                                    d2 = (int) (Math.random() * 6) + 1;
                                    cambiaimg(d1, p2d1);
                                    cambiaimg(d2, p2d2);
                                    r2 = d1 + d2;
                                    p2[0] += r2;

                                    d1 = (int) (Math.random() * 6) + 1;
                                    d2 = (int) (Math.random() * 6) + 1;
                                    cambiaimg(d1, p3d1);
                                    cambiaimg(d2, p3d2);
                                    r3 = d1 + d2;
                                    p3[0] += r3;

                                    rondas.setText((rnds + 1) + "");
                                    p1t.setText("tiro " + (rnds + 1));
                                    p2t.setText("tiro " + (rnds + 1));
                                    p3t.setText("tiro " + (rnds + 1));

                                    p1res.setText(r1 + "");
                                    p2res.setText(r2 + "");
                                    p3res.setText(r3 + "");

                                    if (rnds == 3) {
                                        if (p1[0] > p2[0] ) {
                                            if (p1[0] > p3[0]){
                                                //Toast.makeText(this,"gano el jugador1: "+p1[0]+"Jugador2: "+p2[0]+"Jugador3: "+p3[0],Toast.LENGTH_LONG).show();/*
                                                  gplayer1(p1,p2,p3);
                                            }
                                        }

                                        if (p2[0] > p1[0]) {
                                            if( p2[0] > p3[0]){
                                                gplayer2(p1,p2,p3);
                                            }
                                        }

                                        if (p3[0] > p2[0]) {
                                            if(p3[0] > p1[0]){
                                                gplayer3(p1,p2,p3);
                                            }
                                        }
                                    }//if de la ronda
                                }//run2
                            });//runOnUi
                            cont++;
                            try {
                                sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }//run
                };//Thread
                thread.start();
            }//onClick
        });//setOnClick
    }//onCreate

    public  void gplayer1(int[] player1,int[] player2,int[] player3){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Gano el jugador 1: " + player1[0]).setMessage("\njugador 2: " + player2[0] +
                "\njugador 3: " + player3[0])
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }

    public  void gplayer2(int[] player1,int[] player2,int[] player3){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Gano el jugador 2: " + player1[0]).setMessage("\njugador 1: " + player2[0] +
                "\njugador 3: " + player3[0])
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }

    public  void gplayer3(int[] player1,int[] player2,int[] player3){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Gano el jugador 3: " + player3[0]).setMessage("\njugador 1: " + player1[0] +
                "\njugador 2: " + player2[0])
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }

    public void cambiaimg ( int val, ImageView img){
        switch(val){
            case 1:
                img.setImageResource(R.drawable.dado1);
                break;
            case 2:
                img.setImageResource(R.drawable.dado2);
                break;
            case 3:
                img.setImageResource(R.drawable.dado3);
                break;
            case 4:
                img.setImageResource(R.drawable.dado4);
                break;
            case 5:
                img.setImageResource(R.drawable.dado5);
                break;
            case 6:
                img.setImageResource(R.drawable.dado6);
                break;
        }
    }//cambiarimagen
}//class
