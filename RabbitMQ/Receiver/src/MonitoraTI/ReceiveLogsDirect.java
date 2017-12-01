package MonitoraTI;

import com.rabbitmq.client.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
/**
 *
 * @author Nelsin
 */
public class ReceiveLogsDirect {

  private static final String EXCHANGE_NAME = "direct_logs";

  public static void writeToLog(String inString)
{
    Date data = new Date();
    String fileName = Integer.toString(data.getDate())+Integer.toString(data.getMonth()+1)+Integer.toString(data.getYear()+1900) + ".txt";
    File file = new File(fileName);
    boolean existsFlag = file.exists();

    if(!existsFlag)
    {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("could not create new log file");
            e.printStackTrace();
        }
    }
    FileWriter fstream;
    try {
        fstream = new FileWriter(file, true);
         BufferedWriter out = new BufferedWriter(fstream);
         out.write(inString+"\n");
         out.newLine();
         out.close();
    } catch (IOException e) {
        System.out.println("Não foi possível escrever ao Log");
        e.printStackTrace();
    } 
    return;
}
  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
    String queueName = channel.queueDeclare().getQueue();
    
    if (argv.length < 1){
      System.err.println("Usage: ReceiveLogsDirect [info] [warning] [error]");
      System.exit(1);
    }

    for(String severity : argv){
      channel.queueBind(queueName, EXCHANGE_NAME, severity);
    }
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
    
    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope,
                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received " + envelope.getRoutingKey() + ": " + message);
        writeToLog("\n"+envelope.getRoutingKey().toString() + ": " + message.toString()+"\n");
      }
    };
    channel.basicConsume(queueName, true, consumer);
  }
}