package AgentDemo;

public class FBI_Agent implements Agent_IF, runnable{
    private boolean workingInProgress;
    private String myFootPrint;

    public FBI_Agent(String footprint){
        this.workingInProgress = true;
        this.myFootPrint = footprint;
    }

    public void run(){
        while(true){
            if(workingInProgress){
                sleep(100);
                System.out.println(myFootPrint);
            }
            else{
                sleep(500);
            }
        }
    }

    public void startTask(){workingInProgress=true;}
    public void stopTask(){workingInProgress=false;}
}
