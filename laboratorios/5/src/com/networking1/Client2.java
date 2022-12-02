package com.networking1;

import com.networking1.R;

import server.DAO;
import server.Student;
import server.server6.Command;
import server.server6.Dao6;
import server.server6.Invoker;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Client2 extends Activity {
  private EditText txtId = null;
  private EditText txtName = null;
  private EditText txtGrade = null;

  abstract class AbstractCommand implements Command, Button.OnClickListener {
    public abstract void execute(Dao6 d);

    public void onClick(View arg0) {
      Invoker i = new Invoker(DAO.HOST, DAO.PORT);
      Dao6 d = new Dao6();
      i.invoke(d, this);
    }
  }

  class DelCmd extends AbstractCommand implements Command,
      Button.OnClickListener {
    public void execute(Dao6 d) {
      long id = Long.parseLong(txtId.getText().toString());
      d.delete(id);
    }
  }

  class UpdCmd extends AbstractCommand implements Command,
      Button.OnClickListener {
    public void execute(Dao6 d) {
      long id = Long.parseLong(txtId.getText().toString());
      String name = txtName.getText().toString();
      double grade = Double.parseDouble(txtGrade.getText().toString());
      Student std = new Student(id, name, grade);
      d.update(id, std);
    }
  }

  class AddCmd extends AbstractCommand implements Command,
      Button.OnClickListener {
    public void execute(Dao6 d) {
      long id = Long.parseLong(txtId.getText().toString());
      String name = txtName.getText().toString();
      double grade = Double.parseDouble(txtGrade.getText().toString());
      Student std = new Student(id, name, grade);
      d.add(id, std);
    }
  }

  class GetCmd extends AbstractCommand implements Command,
      Button.OnClickListener {
    public void execute(Dao6 d) {
      String strId = txtId.getText().toString();
      long id = Long.parseLong(strId);
      Student s = d.get(id);
      txtName.setText(s.name);
      txtGrade.setText(String.valueOf(s.grade));
    }
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.client);
    txtId = (EditText) findViewById(R.id.txtId);
    txtName = (EditText) findViewById(R.id.txtName);
    txtGrade = (EditText) findViewById(R.id.txtGrade);

    ((Button) findViewById(R.id.get)).setOnClickListener(new GetCmd());
    ((Button) findViewById(R.id.add)).setOnClickListener(new AddCmd());
    ((Button) findViewById(R.id.upd)).setOnClickListener(new UpdCmd());
    ((Button) findViewById(R.id.del)).setOnClickListener(new DelCmd());

    ((Button) findViewById(R.id.cln))
        .setOnClickListener(new Button.OnClickListener() {
          public void onClick(View arg0) {
            txtId.setText("");
            txtName.setText("");
            txtGrade.setText("");
          }
        });

  }
}
