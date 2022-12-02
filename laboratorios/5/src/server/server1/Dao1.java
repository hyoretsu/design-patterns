package server.server1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import server.DAO;
import server.Student;

public class Dao1 implements DAO<Long, Student> {

  public Student get(Long key) {
    Student s = null;
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    try {
      socket = new Socket("10.0.2.2", 4444);
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());
      out.writeObject(new Long(key));
      s = (Student) in.readObject();
      out.writeObject(new Long(0L));
      socket.close();
      out.close();
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return s;
  }

  public void add(Long key, Student value) {
    // TODO Auto-generated method stub
  }

  public void update(Long key, Student value) {
    // TODO Auto-generated method stub
  }

  public void delete(Long key) {
    // TODO Auto-generated method stub
  }

  public static void main(String args[]) {
    Dao1 d = new Dao1();
    Student s = d.get(200934878L);
    System.out.println(s);
  }

}