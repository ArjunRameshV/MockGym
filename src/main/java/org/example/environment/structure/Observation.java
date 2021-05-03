package org.example.environment.structure;

public class Observation {
    Integer state;
    Integer reward;
    boolean done;
    String info;

    // constructor
    public Observation(Integer state, Integer reward, boolean done, String info){
        this.state = state;
        this.reward = reward;
        this.done = done;
        this.info = info;
    }

    // getters
    public Integer getState() {
        return state;
    }
    public Integer getReward() {
        return reward;
    }
    public boolean isDone() {
        return done;
    }
    public String getInfo() {
        return info;
    }

    // setters
    public void setState(Integer state) {
        this.state = state;
    }
    public void setReward(Integer reward) {
        this.reward = reward;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}