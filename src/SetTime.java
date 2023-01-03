class SetTime extends TimeOperators{

    public int min(int time) {
        if(minusCheck(time))
            time--;

        return time;
    }

    public int plusH(int time) {
        if(hoursCheck(time))
            time++;

        return time;
    }

    public int plusMS(int time) {
        if(minutesSecondsCheck(time))
            time++;
        return time;
    }

    private boolean hoursCheck(int hours) {
        boolean tmp = false;
        if (hours < 23)
            tmp = true;
        return tmp;
    }

    private boolean minutesSecondsCheck(int time) {
        boolean tmp = false;
        if (time < 59)
            tmp = true;
        return tmp;
    }

    public boolean minusCheck(int time) {
        boolean tmp = false;
        if (time > 0)
            tmp = true;
        return tmp;
    }

}
