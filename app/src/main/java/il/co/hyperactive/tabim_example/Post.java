package il.co.hyperactive.tabim_example;

import java.net.URI;

/**
 * Created by Tom on 26/03/2017.
 */

public class Post {
    private int profileImageid;
    private String studentName;
    private String disc;
    private int bigImageid;

    public Post(int profileImageid, String studentName,String disc,int bigImageid) {
        this.profileImageid = profileImageid;
        this.bigImageid = bigImageid;
        this.disc = disc;
        this.studentName = studentName;
    }

    public int getProfileImageid() {
        return profileImageid;
    }

    public void setProfileImageid(int profileImageid) {
        this.profileImageid = profileImageid;
    }

    public int getBigImageid() {
        return bigImageid;
    }

    public void setBigImageid(int bigImageid) {
        this.bigImageid = bigImageid;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
