package server.server6;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Invoker {

  private static final int EOF = -1;

  private String host;
  private int port;
  private Socket socket = null;
  private ObjectOutputStream out = null;
  private ObjectInputStream in = null;

  public Invoker(String host, int port) {
    this.host = host;
    this.port = port;
  }

  private void openConnection() {
    // Open a new connection:
    try {
      socket = new Socket(host, port);
      out = new ObjectOutputStream(socket.getOutputStream());
      in = new ObjectInputStream(socket.getInputStream());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void closeConnection() {
    // Close the connection:
    try {
      out.writeObject(new Integer(EOF));
      out.flush();
      socket.close();
      out.close();
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void invoke(Dao6 d, Command c) {
    openConnection();
    d.setChannels(out, in);
    c.execute(d);
    closeConnection();
  }
}
