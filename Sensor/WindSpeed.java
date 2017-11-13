import java.util.Random;

public class WindSpeed implements Runnable {
private double windSpeed = 0;
WindSpeed(double windSpeed){
        super();
        this.windSpeed = windSpeed;
}

public void run(){
        Random rand = new Random();
        Thread thread = new Thread();
        thread.start();
        try{
                while(true) {

                        setWind(rand.nextInt(40) + 0);
                        System.out.println("Wind Speed: "+getWind());
                        thread.sleep(5000);
                }
        }
        catch(Exception e) {}
}

public double getWind(){
        return windSpeed;
}

public void setWind(double windSpeed){
        this.windSpeed =windSpeed;
}

}
