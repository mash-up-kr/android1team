package kr.co.mash_up.debate;

import android.widget.TextView;

/**
 * Created by SoHyun on 2016-07-25.
 */
public class Reply_RV_Item {

    String writer_id;
    String write_date;
    String content;
    String agree_no;
    String degree_no;
    String reply_no;

    public Reply_RV_Item(String writer_id, String write_date, String content, String agree_no, String degree_no, String reply_no) {
        this.writer_id = writer_id;
        this.write_date = write_date;
        this.content = content;
        this.agree_no = agree_no;
        this.degree_no = degree_no;
        this.reply_no = reply_no;
    }

    public String getWriter_id() {
        return writer_id;
    }

    public void setWriter_id(String writer_id) {
        this.writer_id = writer_id;
    }

    public String getWrite_date() {
        return write_date;
    }

    public void setWrite_date(String write_date) {
        this.write_date = write_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAgree_no() {
        return agree_no;
    }

    public void setAgree_no(String agree_no) {
        this.agree_no = agree_no;
    }

    public String getReply_no() {
        return reply_no;
    }

    public void setReply_no(String reply_no) {
        this.reply_no = reply_no;
    }

    public String getDegree_no() {
        return degree_no;
    }

    public void setDegree_no(String degree_no) {
        this.degree_no = degree_no;
    }
}
