package kr.co.mash_up.debate;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by SoHyun on 2016-07-25.
 */
public class Reply_VH extends RecyclerView.ViewHolder {
    TextView writer_id;
    TextView write_date;
    TextView content;
    TextView agree_no;
    TextView degree_no;
    TextView reply_no;


    public Reply_VH(View itemView) {
        super(itemView);



            writer_id= (TextView)itemView.findViewById(R.id.writer_id);
            write_date= (TextView)itemView.findViewById(R.id.write_date);
            content= (TextView)itemView.findViewById(R.id.content);
            agree_no= (TextView)itemView.findViewById(R.id.agree_no);
            degree_no= (TextView)itemView.findViewById(R.id.degree_no);
            reply_no= (TextView)itemView.findViewById(R.id.reply_no);

    }
}
