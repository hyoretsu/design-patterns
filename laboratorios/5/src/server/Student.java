package server;

import java.io.Serializable;

public class Student implements Serializable {

  private static final long serialVersionUID = 1L;

  public Student(long key, String name, double grade) {
    this.name = name;
    this.grade = grade;
    this.key = key;
  }

  public final String name;

  public final double grade;

  public final long key;
  
  public String toString() {
    return name + "" + "(" + key + "): " + grade;
  }
}