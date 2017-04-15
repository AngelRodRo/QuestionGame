package com.example.angel.questiongame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;
/**
 * Created on 02/04/2017.
 */


public class QuizHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mathsone";
    private static final String TABLE_QUEST = "quest";

    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_OPTA = "opta";
    private static final String KEY_OPTB = "optb";
    private static final String KEY_OPTC = "optc";
    private static final String KEY_TYPE = "type";
    private SQLiteDatabase dbase;
    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_TYPE + " TEXT, "  + KEY_OPTC + " TEXT)" ;
        db.execSQL(sql);
        addQuestion();

    } /*
    private void addQuestion() {
        Question q1 = new Question("5+2 = ?", "7", "8", "6", "7");
        this.addQuestion(q1);
        Question q2 = new Question("2+18 = ?", "18", "19", "20", "20");
        this.addQuestion(q2);
        Question q3 = new Question("10-3 = ?", "6", "7", "8", "7");
        this.addQuestion(q3);
        Question q4 = new Question("5+7 = ?", "12", "13", "14", "12");
        this.addQuestion(q4);
        Question q5 = new Question("3-1 = ?", "1", "3", "2", "2");
        this.addQuestion(q5);
        Question q6 = new Question("0+1 = ?", "1", "0", "10", "1");
        this.addQuestion(q6);
        Question q7 = new Question("9-9 = ?", "0", "9", "1", "0");
        this.addQuestion(q7);
        Question q8 = new Question("3+6 = ?", "8", "7", "9", "9");
        this.addQuestion(q8);
        Question q9 = new Question("1+5 = ?", "6", "7", "5", "6");
        this.addQuestion(q9);
        Question q10 = new Question("7-5 = ?", "3", "2", "6", "2");
        this.addQuestion(q10);
        Question q11 = new Question("7-2 = ?", "7", "6", "5", "5");
        this.addQuestion(q11);
        Question q12 = new Question("3+5 = ?", "8", "7", "5", "8");
        this.addQuestion(q12);
        Question q13 = new Question("0+6 = ?", "7", "6", "5", "6");
        this.addQuestion(q13);
        Question q14 = new Question("12-10 = ?", "1", "2", "3", "2");
        this.addQuestion(q14);
        Question q15 = new Question("12+2 = ?", "14", "15", "16", "14");
        this.addQuestion(q15);
        Question q16 = new Question("2-1 = ?", "2", "1", "0", "1");
        this.addQuestion(q16);
        Question q17 = new Question("6-6 = ?", "6", "12", "0", "0");
        this.addQuestion(q17);
        Question q18 = new Question("5-1 = ?", "4", "3", "2", "4");
        this.addQuestion(q18);
        Question q19 = new Question("4+2 = ?", "6", "7", "5", "6");
        this.addQuestion(q19);
        Question q20 = new Question("5+1 = ?", "6", "7", "5", "6");
        this.addQuestion(q20);
        Question q21 = new Question("5-4 = ?", "5", "4", "1", "1");
        this.addQuestion(q21);
    } */

   /* private void addQuestionScience(String astronomy) {
        Question q1 = new Question("The study of universe beyond the Earth's atmosphere.", "Astronomy", "Chemisty","Meteorology", "Astronomy");
        addQuestion("Astronomy");
        Question q2 = new Question("Are immense systems containing billion of stars?", "Galaxies","Milky Way","Solar System","Galaxies");
        this.addQuestion(q2);
        Question q3 = new Question("Are fragments of comets,planets, moons, or asteroids that have broken off.", "Meteors","Asteroids","Supernova","Meteors");
        this.addQuestion(q3);
        Question q4 = new Question("Is the physical science that deals with composition, structure and properties of substances.", "Chemistry","Biology","General Science","Chemistry");
        this.addQuestion(q4);
        Question q5 = new Question("A measure with both magnitude but no direction", "Scalar","Vector","Net Force","Scalar");
        this.addQuestion(q5);
        Question q6 = new Question("Basic forms of energy", "Electricity","Current","Electric Charge","Electricity");
        this.addQuestion(q6);
        Question q7 = new Question("Is the description of motion without regard to what causes the motion.", "Kinetics","Velocity","Dynamics",Kinetics");
        this.addQuestion(q7);
        Question q8 = new Question("Is a form of energy visible to the human eye that is radiated by moving charged particles.", "Light","Absorption","Sunlight","Light");
        this.addQuestion(q8);
        Question q9 = new Question("Is the bending of light when it passes from one kind of material into another.", "Refraction","Reflection","Wavelength","Refraction");
        this.addQuestion(q9);
        Question q10 = new Question("Base unit of thermodynamic temperature measurement in the International System (SI) of measurement.", "Kelvin","Celsius","Fahrenheit","Kelvin");
        this.addQuestion(q10);
        Question q11 = new Question("Parts of Human brain that is responsible for intelligence and reasoning.", "Cerebrum","Medulla","Cerebellum","Cerebrum");
        this.addQuestion(q11);
        Question q12 = new Question("Animal encompassing phyla Cnidaria and Ctenophora.", "Phylum Coelenterata","Nematoda","Anthropoda","Phylum Coelenterata");
        this.addQuestion(q12);
        Question q13 = new Question("Diverse animals found in water and on land.", "Mollusca","Echinodermata","Platyhelminthes","Mollusca");
        this.addQuestion(q13);
        Question q14 = new Question("Green coloring pigment", "Chlorophyll","Chloroplasts","Leucoplasts","Chlorophyll");
        this.addQuestion(q14);
        Question q15 = new Question("What is the periodic symbol of Potassium?", "K","Fe","P","K");
        this.addQuestion(q15);
        Question q16 = new Question("Scientific name for Strawberry", "Fragaria × ananassa","Citrus Lanatus","Ananas comosus","Fragaria × ananassa");
        this.addQuestion(q16);
        Question q17 = new Question("Scientific name of Dog", "Canis lupus familiaris","Aves","Felis catus","Canis lupus familiaris");
        this.addQuestion(q17);
        Question q18 = new Question("Scientific name of Wolf", "Canis lupus","Loxodonta","Pavo cristatus","Canis lupus");
        this.addQuestion(q18);
        Question q19 = new Question("Scientific name of Grapes", "Vitis vinifera","Cyanococcus","Oxycoccus","Vitis vinifera");
        this.addQuestion(q19);
        Question q20 = new Question("What is the deadliest mushroom", "Death Cap","Destroying Angels","Autumn Skullcap","Death Cap");
        this.addQuestion(q20);
        Question q21 = new Question("What is the universal solvent", "Water", "Hydrogen", "Heliocentric Acid","Water");
        this.addQuestion(q21);
    }
*/

    private void addQuestion() {
        Question q1 = new Question("Who is the father of Isaac?","Abraham","Moses","David","Abraham","2");
        this.addQuestion(q1);
        Question q2 = new Question("What is the age of methuselah when he died?","969","100","553","969","2");
        this.addQuestion(q2);
        Question q3 = new Question("In what city was Jesus born? ","Bethlehem","Jerusalem","Israel","Bethlehem","2");
        this.addQuestion(q3);
        Question q4 = new Question("How many books are there in the old testament?","39","29","23","39","2");
        this.addQuestion(q4);
        Question q5 = new Question("How many people did Jesus feed with five loaves of bread and two fish?", "5000","2000","6978", "5000","2");
        this.addQuestion(q5);
        Question q6 = new Question("Who is the author of the Book of Revelation?", "John","Matthew","Lucas", "John","2");
        this.addQuestion(q6);
        Question q7 = new Question("What is the shortest book in the New Testament?", "2 John","Genesis","1 John", "2 John","2");
        this.addQuestion(q7);
        Question q8 = new Question("Who takes Jesus’s body off the cross?", "Joseph of Arimathea","Jude","Mary", "Joseph of Arimathea","2");
        this.addQuestion(q8);
        Question q9 = new Question("According to the Gospels, what is the unique literary genre Jesus employs to preach his message?", "The Parable","Beatitudes","Gospel", "The Parable","2");
        this.addQuestion(q9);
        Question q10 = new Question("Who gave Jesus gifts when he was born?", "The wise men","The lethargists","The Priest", "The wise men","2");
        this.addQuestion(q10);
        Question q11 = new Question("What is the best, most accurate Bible translation?", "King James Version","Masoretic Text","Alexandrian", "King James Version","2");
        this.addQuestion(q11);
        Question q12 = new Question("Jesus wept - shortest Bible verse", "John 11:35","Genesis 11:35","1 Corinthians 1:4", "John 11:35","2");
        this.addQuestion(q12);
        Question q13 = new Question("What does “Eve” mean?", "Mother of all living","Demon of all demons","Evening", "Mother of all living","2");
        this.addQuestion(q13);
        Question q14 = new Question("Who is the woman married Moses?", "Zipporah","Luna","Zypheria", "Zipporah","2");
        this.addQuestion(q14);
        Question q15 = new Question("After the flood, what sign did God give that He would not destroy the earth with a flood again?", "Rainbow","Sunrise","Calm cloud", "Rainbow","2");
        this.addQuestion(q15);
        Question q16 = new Question("What was the name of the mountain where Moses was given the 10 Commandments?", "Mt. Sanai","Mt. Zion","Mt. Olives", "Mt. Sanai","2");
        this.addQuestion(q16);
        Question q17 = new Question("What did King Solomon ask God to give him?", "Wisdom","Word of Wisdom","Knowledge", "Wisdom","2");
        this.addQuestion(q17);
        Question q18 = new Question("How many of each animal did Noah's bring into the Ark?", "2x2","3x3","1x1", "2x2","2");
        this.addQuestion(q18);
        Question q19 = new Question("What river was Jesus baptized in?", "Jordan River","Gihon River","Qishon River", "Jordan River","2");
        this.addQuestion(q19);
        Question q20 = new Question("What is the longest name in the bible?", "Mahershalalhashbaz","JesuitsMomentummesss","Oagadugoooonileeriver", "Mahershalalhashbaz","2");
        this.addQuestion(q20);
        Question q21 = new Question("Who is king of God = ?", "Zeus", "Apollo", "Dionysus", "Zeus","2");
        this.addQuestion(q21);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        onCreate(db);
    }

    public List<Question> getQuestionType(int type){
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT * FROM " + TABLE_QUEST + " WHERE type='" + type +"'";
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }

    public void addQuestion(Question quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_TYPE,quest.getType());
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        return quesList;
    }
}