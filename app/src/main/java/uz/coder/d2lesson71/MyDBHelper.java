package uz.coder.d2lesson71;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper implements DBService {

    private static final String DB_NAME = "D271";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "student";
    private static final String STUDENT_ID = "id";
    private static final String STUDENT_NAME = "name";
    private static final String STUDENT_AGE = "age";
    private static final String STUDENT_PHONE = "phone_number";


    public MyDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          //db yaratilganda ishlaydi.
        String query = "create table " + TABLE_NAME + "(" +
                STUDENT_ID + " integer  not null primary key autoincrement," +
                STUDENT_NAME + " text not null," +
                STUDENT_AGE + " integer not null," +
                STUDENT_PHONE + " text not null)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //  migration

    }


    @Override
    public void addStudent(Student student) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(STUDENT_NAME,student.getName());
        contentValues.put(STUDENT_AGE,student.getAge());
        contentValues.put(STUDENT_PHONE,student.getPhone_number());
        database.insert(TABLE_NAME,null,contentValues);

    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public List<Student> getAllStudent() {
        SQLiteDatabase database = this.getReadableDatabase();
        List<Student> studentsList  = new ArrayList<>();

        String query = "select * from " + TABLE_NAME;

        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do {
                Student student =  new Student();
                student.setName(cursor.getString(1));
                student.setAge(Integer.parseInt(cursor.getString(2)));
                student.setPhone_number(cursor.getString(3));
                studentsList.add(student);
            }while (cursor.moveToNext());
        }
        return studentsList;

    }

    @Override
    public int getStudentCount() {
        return 0;
    }

    @Override
    public void editStudent() {

    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }
}
