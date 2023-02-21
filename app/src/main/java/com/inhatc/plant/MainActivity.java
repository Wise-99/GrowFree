package com.inhatc.plant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    final String TAG = "TAG+MainActivity";

    public InputStream dataInputStream;
    public OutputStream dataOutputStream;
    private Socket socket;
    private String ip = "10.40.45.55"; // 서버의 ip주소
    private int port = 12345;          // 서버의 포트번호
    String tmp;

    Thread thread;
    private ImageView image_plant;

    // 송신하는 함수
    public void turnOn() throws IOException{
        byte[] inst = "On".getBytes(); // 메세지 저장(On)
        dataOutputStream.write(inst);  // 서버에 메세지 출력
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 메인화면 이미지 삽입(식물 사진)
        image_plant = (ImageView) findViewById(R.id.imageView);
        image_plant.setImageResource(R.drawable.plants);

        // 수신하는 쓰레드
        thread = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    socket = new Socket(ip, port);
                    dataInputStream = socket.getInputStream();
                    dataOutputStream = socket.getOutputStream();
                } catch (IOException e){
                    e.printStackTrace();
                }
                byte[] buffer = new byte[1024];
                int bytes;
                Log.d(TAG, "수신시작");
                    try{
                        Log.d(TAG, "수신 대기");
                        bytes = dataInputStream.read(buffer);
                        Log.d(TAG, "byte = " + bytes);
                        tmp = new String(buffer, 0, bytes);

                        socket.close();
                    } catch (IOException e){
                        e.printStackTrace();
                    }

            }
        });
        thread.start();

        // 물주기 버튼 클릭 시
        Button water_btn = findViewById(R.id.btn_water);
        water_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            turnOn(); // 송신 함수 실행
                            // 물주기 성공 시
                            //Toast.makeText(getApplicationContext(),tmp,Toast.LENGTH_SHORT).show();
                        } catch (IOException e){
                            // 물주기 실패 시
                            //Toast.makeText(getApplicationContext(),"물 주기 실패, 다시 시도해 주세요.",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });

        // 주기 확인 버튼 클릭 시
        Button cycle_btn = findViewById(R.id.btn_water_cycle);
        cycle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WaterCycleActivity.class);
                startActivity(intent);
            }
        });
    }
}