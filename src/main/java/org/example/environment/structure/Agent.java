package org.example.environment.structure;

public class Agent {
    Integer action;
    Integer current_state;

    public Agent(Integer action, Integer current_state) {
        this.action = action;
        this.current_state = current_state;
    }

    // getters
    public Integer getAction() {
        return action;
    }
    public Integer getCurrent_state() {
        return current_state;
    }

    // setters
    public void setAction(Integer action) {
        this.action = action;
    }
    public void setCurrent_state(Integer current_state) {
        this.current_state = current_state;
    }
}
