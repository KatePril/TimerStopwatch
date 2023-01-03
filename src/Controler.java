import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

class Controler {
    private ClockView clockView = new ClockView();
    private TimerModel timerModel = new TimerModel(clockView.getLabel());
    private StopwatchModel stopwatchModel = new StopwatchModel(clockView.getLabel());

    public ClockView getClockView() {
        return clockView;
    }

    public void setClockView(ClockView clockView) {
        this.clockView = clockView;
    }

    public TimerModel getTimerModel() {
        return timerModel;
    }

    public void setTimerModel(TimerModel timerModel) {
        this.timerModel = timerModel;
    }

    public StopwatchModel getStopwatchModel() {
        return stopwatchModel;
    }

    public void setStopwatchModel(StopwatchModel stopwatchModel) {
        this.stopwatchModel = stopwatchModel;
    }
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (timerModel.getTimerThread().isAlive()) {
                timerModel.setLabel(timerModel.getTimerThread().setLabel(clockView.getLabel()));
                clockView.getLabel().setText(timerModel.getTimerThread().reset());
            } else {
                clockView.getLabel().setText("00:00:00");
            }
        } else {
            if (stopwatchModel.getStopwatchThread().isAlive()) {
                stopwatchModel.setLabel(stopwatchModel.getStopwatchThread().setLabel(clockView.getLabel()));
                clockView.getLabel().setText(stopwatchModel.getStopwatchThread().reset());
            } else {
                clockView.getLabel().setText("00:00:00");
            }
        }
    }

    public void createClock(){
        ClockView clockView1 = new ClockView();
        setClockView(clockView1);
        clockView.drawTimer();
        clockView.getCheckBox().addItemListener(this::itemStateChanged);
        clockView.getBtnMinHours().addActionListener((e -> {
            if (!clockView.getCheckBox().isSelected()) {
                int h = timerModel.getSetTime().min(timerModel.getSetTime().getHours(clockView.getLabel().getText()));
                int m = timerModel.getSetTime().getMinutes(clockView.getLabel().getText());
                int s = timerModel.getSetTime().getSeconds(clockView.getLabel().getText());
                clockView.getLabel().setText(timerModel.getSetTime().setTime(h, m, s));
            }
        }));
        clockView.getBtnPlusHours().addActionListener((e -> {
            if (!clockView.getCheckBox().isSelected()) {
                int h = timerModel.getSetTime().plusH(timerModel.getSetTime().getHours(clockView.getLabel().getText()));
                int m = timerModel.getSetTime().getMinutes(clockView.getLabel().getText());
                int s = timerModel.getSetTime().getSeconds(clockView.getLabel().getText());
                clockView.getLabel().setText(timerModel.getSetTime().setTime(h, m, s));
            }
        }));
        clockView.getBtnMinMinutes().addActionListener((e -> {
            if (!clockView.getCheckBox().isSelected()) {
                int h = timerModel.getSetTime().getHours(clockView.getLabel().getText());
                int m = timerModel.getSetTime().min(timerModel.getSetTime().getMinutes(clockView.getLabel().getText()));
                int s = timerModel.getSetTime().getSeconds(clockView.getLabel().getText());
                clockView.getLabel().setText(timerModel.getSetTime().setTime(h, m, s));
            }
        }));
        clockView.getBtnPlusMinutes().addActionListener((e -> {
            if (!clockView.getCheckBox().isSelected()) {
                int h = timerModel.getSetTime().getHours(clockView.getLabel().getText());
                int m = timerModel.getSetTime().plusMS(timerModel.getSetTime().getMinutes(clockView.getLabel().getText()));
                int s = timerModel.getSetTime().getSeconds(clockView.getLabel().getText());
                clockView.getLabel().setText(timerModel.getSetTime().setTime(h, m, s));
            }
        }));

        clockView.getBtnMinSeconds().addActionListener((e -> {
            if (!clockView.getCheckBox().isSelected()) {
                int h = timerModel.getSetTime().getHours(clockView.getLabel().getText());
                int m = timerModel.getSetTime().getMinutes(clockView.getLabel().getText());
                int s = timerModel.getSetTime().min(timerModel.getSetTime().getSeconds(clockView.getLabel().getText()));
                clockView.getLabel().setText(timerModel.getSetTime().setTime(h, m, s));
            }
        }));
        clockView.getBtnPlusSeconds().addActionListener((e -> {
            if (!clockView.getCheckBox().isSelected()) {
                int h = timerModel.getSetTime().getHours(clockView.getLabel().getText());
                int m = timerModel.getSetTime().getMinutes(clockView.getLabel().getText());
                int s = timerModel.getSetTime().plusMS(timerModel.getSetTime().getSeconds(clockView.getLabel().getText()));
                clockView.getLabel().setText(timerModel.getSetTime().setTime(h, m, s));
            }
        }));

        clockView.getBtnStart().addActionListener((e) -> {
            if(clockView.getCheckBox().isSelected()){
                StopwatchModel newModel = new StopwatchModel(clockView.getLabel());
                stopwatchModel = newModel;
                stopwatchModel.setLabel(stopwatchModel.getStopwatchThread().setLabel(clockView.getLabel()));
                stopwatchModel.getStopwatchThread().start();
            } else {
                if (!Objects.equals(clockView.getLabel().getText(), "00:00:00")) {
                    TimerModel newModel = new TimerModel(clockView.getLabel());
                    timerModel = newModel;
                    timerModel.setLabel(timerModel.getTimerThread().setLabel(clockView.getLabel()));
                    timerModel.getTimerThread().start();
                }
            }
        });

        clockView.getBtnReset().addActionListener((e) -> {
            if (!Objects.equals(clockView.getLabel().getText(), "00:00:00")) {
                if (clockView.getCheckBox().isSelected()) {
                    stopwatchModel.setLabel(stopwatchModel.getStopwatchThread().setLabel(clockView.getLabel()));
                    clockView.getLabel().setText(stopwatchModel.getStopwatchThread().reset());
                } else {
                    timerModel.setLabel(timerModel.getTimerThread().setLabel(clockView.getLabel()));
                    clockView.getLabel().setText(timerModel.getTimerThread().reset());
                }
            }
        });

        clockView.getBtnStop().addActionListener((e) -> {
            if (!Objects.equals(clockView.getLabel().getText(), "00:00:00")) {
                if (clockView.getCheckBox().isSelected()) {
                    stopwatchModel.setLabel(stopwatchModel.getStopwatchThread().setLabel(clockView.getLabel()));
                    stopwatchModel.getStopwatchThread().stop();
                } else {
                    timerModel.setLabel(timerModel.getTimerThread().setLabel(clockView.getLabel()));
                    timerModel.getTimerThread().stop();
                }
            }
        });
    }

}
