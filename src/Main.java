import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayBlockingQueue sharedQueue = new ArrayBlockingQueue(Integer.parseInt(args[0]));
        String cmd = scanner.nextLine();
        while (true){
            if(cmd.equals("stop")){
                break;
            }
            if(cmd.equals("produce")){
                new Thread(new Producer(sharedQueue)).start();
            }else if(cmd.equals("consumer")){
                new Thread(new Consumer(sharedQueue)).start();
            }
            cmd = scanner.nextLine();
        }
    }

}
