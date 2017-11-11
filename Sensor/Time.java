import java.util.Random;

public class Time implements Runnable {
private int time = 0;
Time(int time){
        super();
        this.time = time;
}

public void run(){
        Random rand = new Random();
        Thread thread = new Thread();
        thread.start();
        try{
                setTime(0);
                while(true) {



                        System.out.println("Time: "+getTime());
                        if(time == 2400) {
                                setTime(0);
                        }else{
                                setTime(time+100);
                        }
                        thread.sleep(5000);
                }
        }
        catch(Exception e) {}
}

public int getTime(){
        return time;
}

public void setTime(int time){
        this.time =time;
}

}
