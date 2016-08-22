package kr.co.mash_up.debate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Square_content extends AppCompatActivity {

    TextView title;
    TextView square_content;

    Button agree_btn;
    Button degree_btn;
    Button search_btn;
    Button writing_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square_content);

        agree_btn = (Button)findViewById(R.id.agree_btn);
        degree_btn = (Button)findViewById(R.id.degree_btn);
        search_btn = (Button)findViewById(R.id.search_btn);
        writing_btn = (Button)findViewById(R.id.writing_btn);
        title = (TextView)findViewById(R.id.title);
        square_content = (TextView)findViewById(R.id.content);


        //앞에서 내용 클릭하면 putExtra로 넘겨받은거 써주기
        title.setText("대태러방지법, 당신은 찬성? 반대?");
        square_content.setText("최근 정부의 사생활 침해가 아니냐는 논란이 일고 있는 대태러방지법에 대한 여러분의 입장이 궁금합니다." +
                "대태러방지법이 정말로 테러 방지를 위한 것인지에 대해서 중심적으로 이야기를 나눠보고 싶습니다.");

        agree_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Searching_reply.class);

                intent.putExtra("tabposition",1);

                startActivity(intent);

            }
        });

        degree_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Searching_reply.class);

                intent.putExtra("tabposition",2);

                startActivity(intent);

            }
        });

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Searching_reply.class);

                intent.putExtra("tabposition",0);

                startActivity(intent);

            }
        });

        writing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), Writing_reply.class);


                startActivity(intent);

            }
        });


    }
}
