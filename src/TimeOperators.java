class TimeOperators extends Thread{

    public String setTime(int hours, int minutes, int seconds){
        String tmp = "";
        if(hours < 10)
            tmp = "0" + hours + ":";
        else
            tmp = hours + ":";

        if(minutes < 10)
            tmp += "0" + minutes + ":";
        else
            tmp += minutes + ":";

        if(seconds < 10)
            tmp += "0" + seconds;
        else
            tmp += seconds;
        return tmp;
    }

    public String setTime(int times[]){
        String tmp = "";
        if(times[0] < 10)
            tmp = "0" + times[0] + ":";
        else
            tmp = times[0] + ":";

        if(times[1] < 10)
            tmp += "0" + times[1] + ":";
        else
            tmp += times[1] + ":";

        if(times[2] < 10)
            tmp += "0" + times[2];
        else
            tmp += times[2];
        return tmp;
    }

    public int getHours(String time) {
        String tmp = "";
        String times[] = time.split(":");
        if(Zero(times[0])){
            tmp = times[0].replaceFirst("0", "");
        } else {
            tmp = times[0];
        }

        return Integer.parseInt(tmp);
    }

    public int getMinutes(String time) {
        String tmp = "";
        String times[] = time.split(":");
        if(Zero(times[1])){
            tmp = times[1].replaceFirst("0", "");
        } else {
            tmp = times[1];
        }

        return Integer.parseInt(tmp);
    }

    public int getSeconds(String time) {
        String tmp = "";
        String times[] = time.split(":");
        if(Zero(times[2])){
            tmp = times[2].replaceFirst("0", "");
        } else {
            tmp = times[2];
        }

        return Integer.parseInt(tmp);
    }
    private boolean Zero(String time) {
        return time.startsWith("0");
    }

    public boolean minusCheck(int time) {
        boolean tmp = false;
        if (time > 0)
            tmp = true;
        return tmp;
    }
}
