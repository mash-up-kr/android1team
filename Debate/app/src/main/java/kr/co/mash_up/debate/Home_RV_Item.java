package kr.co.mash_up.debate;

/**
 * Created by SoHyun on 2016-06-24.
 */
public class Home_RV_Item {
    String content;
    String agree_no;
    String degree_no;

    public Home_RV_Item(String content, String agree_no, String degree_no) {
        this.content = content;
        this.agree_no = agree_no;
        this.degree_no = degree_no;
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

    public String getDegree_no() {
        return degree_no;
    }

    public void setDegree_no(String degree_no) {
        this.degree_no = degree_no;
    }
}
