package kr.co.mash_up.debate;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Writing_reply extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_reply);





        Button write_reply_btn = (Button)findViewById(R.id.write_reply_btn);
        write_reply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Writing_reply.this,Searching_reply.class);
/*
                Bundle bundle = new Bundle();
                bundle.putString("title", content.getText().toString());
                bundle.putString("content",content.getText().toString());
                intent.putExtras(bundle);
                */
                startActivity(intent);
            }
        });
    }
}
