package server.server6;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

import server.Student;

/**
 * This file is a driver for the grade service. Clients may ask to read a
 * grade from one of the students, and the information is sent back to the
 * requester. Communication happens via a socket connection.
 * 
 * @author Fernando Pereira
 *
 */
public class GradeServer {
	public static void main(String[] args) {
	  System.out.println("Running the server 6");
		Map<Long, Student> students = new HashMap<Long, Student>();
		loadDB(students);
		ServerSocket serverSocket = null;
		boolean listening = true;
		try {
			serverSocket = new ServerSocket(4444);
			while (listening) {
				new StudentHandlerThread(serverSocket.accept(), students).start();
			}
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private static void loadDB(Map<Long, Student> students) {
		students.put(200934878L, new Student(200934878L, "Alberico", 90.5));
		students.put(200755120L, new Student(200755120L, "Bernadino", 71.0));
		students.put(200723139L, new Student(200723139L, "Romao", 84.0));		
	}

}
