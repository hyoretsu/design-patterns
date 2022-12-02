package server.server6;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import server.DAO;
import server.Student;

public class Dao6 implements DAO<Long, Student> {

  private ObjectOutputStream out;
  private ObjectInputStream in;

  public void setChannels(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  public Student get(Long key) {
    Student s = null;
    try {
      out.writeObject(new Integer(DAO.GET));
      out.writeObject(new Long(key));
      s = (Student) in.readObject();
      out.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return s;
  }

  public void add(Long key, Student value) {
    try {
      out.writeObject(new Integer(DAO.ADD));
      out.writeObject(new Long(key));
      out.writeObject(value);
      out.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void update(Long key, Student value) {
    try {
      out.writeObject(new Integer(DAO.UPDATE));
      out.writeObject(new Long(key));
      out.writeObject(value);
      out.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void delete(Long key) {
    try {
      out.writeObject(new Integer(DAO.DELETE));
      out.writeObject(new Long(key));
      out.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
