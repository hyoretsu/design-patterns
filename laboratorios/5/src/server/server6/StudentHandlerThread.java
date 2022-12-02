package server.server6;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

import server.DAO;
import server.Student;

/**
 * This class answer requests via a socket connection. Each request consists on
 * a long integer, which is used as a key of a student.
 * 
 * @author Fernando Pereira
 * 
 */
public class StudentHandlerThread extends Thread implements DAO<Long, Student> {
  private Socket socket = null;
  private Map<Long, Student> students;
  private ObjectOutputStream out;
  private ObjectInputStream in;

  /**
   * Adds a new student to the database.
   * 
   * @param s
   *        the new student
   */
  public void addStudent(Student s) {
    students.put(s.key, s);
  }

  /**
   * Creates a new handler
   * 
   * @param socket
   *        the network connection where this handler will be listening.
   * @param students
   *        the database of students.
   */
  public StudentHandlerThread(Socket socket, Map<Long, Student> students) {
    this.socket = socket;
    this.students = students;
    try {
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Starts the handling protocol.
   */
  public void run() {
    try {
      Integer request = (Integer) in.readObject();
      boolean isWorking = true;
      while (isWorking) {
        switch (request.intValue()) {
        case DAO.GET:
          out.writeObject(get((Long) in.readObject()));
          break;
        case DAO.DELETE:
          delete((Long) in.readObject());
          break;
        case DAO.UPDATE:
          update((Long) in.readObject(), (Student)in.readObject());
          break;
        case DAO.ADD:
          add((Long) in.readObject(), (Student)in.readObject());
          break;
        default:
          isWorking = false;
          return;
        }
        request = (Integer) in.readObject();
      }
      out.close();
      in.close();
      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void add(Long key, Student value) {
    this.students.put(key, value);
  }

  public void delete(Long key) {
    this.students.remove(key);
  }

  public Student get(Long key) {
    Student s = null;
    if (students.containsKey(key)) {
      s = students.get(key);
    } else {
      s = new Student(-1, "", 0.0);
    }
    return s;
  }

  public void update(Long key, Student value) {
    add(key, value);
  }
}