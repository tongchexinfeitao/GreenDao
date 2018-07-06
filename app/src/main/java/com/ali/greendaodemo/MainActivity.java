package com.ali.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.ali.greendaodemo.database.DaoSession;
import com.ali.greendaodemo.database.PersonDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DaoSession daoSession;
    private PersonDao personDao;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daoSession = DaoManager.instance(this).getDaoSession();
        personDao = daoSession.getPersonDao();
    }

    public void add(View view) {
        index++;
        personDao.insert(new Person(null, "wang" + index, index));
    }

    public void delete(View view) {
        Person person = personDao.queryBuilder()
                .where(PersonDao.Properties.Id.eq(1))
                .build().unique();
        personDao.delete(person);
    }

    public void update(View view) {
        Person person = personDao.queryBuilder()
                .where(PersonDao.Properties.Id.eq(1))
                .build().unique();
        person.setAge(1000);
        personDao.update(person);
    }

    public void query(View view) {
        List<Person> list = personDao.queryBuilder()
                .where(PersonDao.Properties.Id.ge(5))
                .build().list();
        Log.e("tag", "query" + list.get(0).getId());
    }
}
