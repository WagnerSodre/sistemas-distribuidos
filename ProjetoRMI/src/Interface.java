import java.rmi.Remote;

public interface Interface extends Remote {
    public float add(float x, float y) throws Exception;

    public float sub(float x, float y) throws Exception;

    public float mult(float x, float y) throws Exception;
    
    public float div(float x, float y) throws Exception;
    
    public float maiorMenor(float x, float y) throws Exception;
}