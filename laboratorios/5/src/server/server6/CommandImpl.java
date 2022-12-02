package server.server6;

import server.Student;

public class CommandImpl implements Command {

  public void execute(Dao6 d) {
    // Execute the DAO operations
    Student s = d.get(200934878L);
    System.out.println(s);
    d.add(160355385L, new Student(160355385L, "Caravaggio", 98.0));
    s = d.get(160355385L);
    System.out.println(s);
    d.update(160355385L, new Student(160355385L, "Michelangelo Merisi", 99.5));
    s = d.get(160355385L);
    System.out.println(s);
  }

}
