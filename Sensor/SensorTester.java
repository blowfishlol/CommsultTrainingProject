import java.util.concurrent.*;

public class SensorTester {
public static void main(String[] args){
        Temperature temperature=new Temperature(0);
        WindSpeed windSpeed=new WindSpeed(0);
        Time time =new Time(0);
        ExecutorService service = Executors.newFixedThreadPool(4);

        service.execute(new Runnable() {
                        public void run() {
                                temperature.run();
                        }
                });
        service.execute(new Runnable() {
                        public void run() {
                                windSpeed.run();
                        }
                });
        service.execute(new Runnable() {
                        public void run() {
                                time.run();
                        }
                });



        // System.out.println(temperature.getTemp());



}
}
