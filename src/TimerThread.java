import javax.swing.*;

class TimerThread extends TimeOperators{

    private JLabel label;

    public JLabel getLabel() {
        return label;
    }

    public JLabel setLabel(JLabel label) {
        this.label = label;
        return label;
    }

    public TimerThread(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        super.run();
        int times[] = {getHours(label.getText()), getMinutes(label.getText()), getSeconds(label.getText())};
        while (checkTime(times)){
            if (checkZero(times[0])) {
                if (checkZero(times[1])) {
                    if (checkZero(times[2])) { //01:01:01
                        times[2]--;
                    } else {
                        times[2] = 59;
                        times[1]--;
                    }
                } else {
                    if (checkZero(times[2])) { //01:00:01
                        times[2]--;
                    } else {
                        --times[0];
                        times[2] = 59;
                        times[1] = 59;
                    }
                }
            } else {
                if (checkZero(times[1])) { //00:01:01
                    if (checkZero(times[2])) {
                        times[2]--;
                    } else { //00:01:00
                        times[2] = 59;
                        times[1]--;
                    }
                } else { //00:00:01
                    if (checkZero(times[2])) { //00:00:01
                        times[2]--;
                    }
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
            }

            label.setText(setTime(times));
        }
    }


    private boolean checkTime(int time[]){
        boolean tmp = false;
        int sum = 0;
        for (int i = 0; i < time.length; i++){
            sum += time[i];
        }
        if (sum != 0)
            tmp = true;
        return tmp;

    }

    private boolean checkZero(int time) {
        boolean tmp = false;
        if (time != 0)
            tmp = true;
        return tmp;
    }

    public String reset(){
        stop();
        return "00:00:00";
    }

}
