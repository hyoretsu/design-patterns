package server.server1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

import server.Student;

/**
 * This class answer requests via a socket connection. Each request consists on
 * a long integer, which is used as a key of a student.
 * 
 * @author fernando
 * 
 */
public class StudentHandlerThread extends Thread {
  private Socket socket = null;
  Map<Long, Student> students;

  /**
   * Adds a new student to the database.
   * 
   * @param s
   *            the new student
   */
  public void addStudent(Student s) {
    students.put(s.key, s);
  }

  /**
   * Creates a new handler
   * 
   * @param socket
   *            the network connection where this handler will be listening.
   * @param students
   *            the database of students.
   */
  public StudentHandlerThread(Socket socket, Map<Long, Student> students) {
    System.out.println("Got conection!");
    this.socket = socket;
    this.students = students;
  }

  /**
   * Starts the handling protocol.
   */
  public void run() {
    try {
      ObjectOutputStream out = new ObjectOutputStream(socket
          .getOutputStream());
      ObjectInputStream in = new ObjectInputStream(socket
          .getInputStream());

      Long key = (Long) in.readObject();
      while (key.longValue() != 0L) {
        System.out.println("Received " + key);
        if (students.containsKey(key)) {
          out.writeObject(students.get(key));
        } else {
          out.writeObject(new Student(-1, "", 0.0));
        }
        key = (Long) in.readObject();
      }
      out.close();
      in.close();
      socket.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}