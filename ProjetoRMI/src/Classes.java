import java.rmi.server.*;

public class Classes extends UnicastRemoteObject implements Interface {
  public Classes() throws Exception {
    super();
  }

  public float add(float x, float y) {
    return x + y;
  }
  
  public float sub(float x, float y) {
    return x - y;
  }
  
  public float mult(float x, float y) {
      return x * y;
  }
  
  public float div(float x, float y) {
      return x / y;
  }
  
  public float maiorMenor(float x, float y) {
      if (x > y)
          return x;
      else if (x < y)
          return y;
      else
          return 0;
  }
}