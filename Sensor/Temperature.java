import java.util.Random;

public class Temperature implements Runnable {
private double temp = 0;
Temperature(double temp){
        super();
        this.temp = temp;
}

public void run(){
        Random rand = new Random();
        Thread thread = new Thread();
        thread.start();
        try{
                while(true) {

                        setTemp(rand.nextInt(40) + 0);
                        System.out.println("Temperature: "+getTemp());
                        thread.sleep(5000);
                }
        }
        catch(Exception e) {}
}

public double getTemp(){
        return temp;
}

public void setTemp(double temp){
        this.temp =temp;
}

}
