package kr.co.mash_up.debate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Writing extends AppCompatActivity {

    EditText title;
    EditText content;
    Button recommand_Btn;
    Button register_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing);

        //toolbar name 바꾸기


         title = (EditText)findViewById(R.id.writing_title);
         content = (EditText)findViewById(R.id.writing_content);
         recommand_Btn = (Button)findViewById(R.id.recommand_title_btn);
         register_Btn = (Button)findViewById(R.id.register_btn);

        register_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Writing.this,MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("title", content.getText().toString());
                bundle.putString("content",content.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
