package kr.co.mash_up.debate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by SoHyun on 2016-06-26.
 */
public class Home_View extends LinearLayout{

    TextView content;
    TextView agree_no;
    TextView degree_no;



    public Home_View(Context context) {
        this(context,null);
    }

    public Home_View(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Home_View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.viewholder_home, this, true);

        content= (TextView)view.findViewById(R.id.content);
        agree_no= (TextView)view.findViewById(R.id.agree_no);
        degree_no= (TextView)view.findViewById(R.id.degree_no);

    }

    public void setData(Home_RV_Item data){

        content.setText(data.getContent());
        agree_no.setText(data.getAgree_no());
        degree_no.setText(data.getDegree_no());
    }

}
