package com.example.angel.questiongame;
import android.app.Activity;

/**
 * Created on 02/04/2017.
 */

public class Question extends Activity {
    private int ID;
    private String QUESTION;
    private String type; // 0: Science, 1: Math, 2: Cristian Living, 3: Free Run
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String ANSWER;
    public Question() {
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        ANSWER = "";
    }
    public Question(String qUESTION, String oPTA, String oPTB, String oPTC,
                    String aNSWER, String mType) {
        QUESTION = qUESTION;
        OPTA = oPTA;
        OPTB = oPTB;
        OPTC = oPTC;
        ANSWER = aNSWER;
        type = mType;
    }
    public int getID() {
        return ID;
    }
    public String getQUESTION() {
        return QUESTION;
    }
    public String getOPTA() {
        return OPTA;
    }
    public String getOPTB() {
        return OPTB;
    }
    public String getOPTC() {
        return OPTC;
    }
    public String getANSWER() {
        return ANSWER;
    }
    public void setID(int id) {
        ID = id;
    }
    public void setQUESTION(String qUESTION) {
        QUESTION = qUESTION;
    }
    public void setOPTA(String oPTA) {
        OPTA = oPTA;
    }
    public void setOPTB(String oPTB) {
        OPTB = oPTB;
    }
    public void setOPTC(String oPTC) {
        OPTC = oPTC;
    }
    public void setANSWER(String aNSWER) {
        ANSWER = aNSWER;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}