package kr.co.mash_up.debate;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by SoHyun on 2016-06-24.
 */
public class Home_VH extends RecyclerView.ViewHolder{


    TextView content;
    TextView agree_no;
    TextView degree_no;


    public Home_VH(View itemView) {
        super(itemView);

        content= (TextView)itemView.findViewById(R.id.content);
        agree_no= (TextView)itemView.findViewById(R.id.agree_no);
        degree_no= (TextView)itemView.findViewById(R.id.degree_no);
    }
}
