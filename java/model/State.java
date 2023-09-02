package model;

public class State {
    private int stateId;
    private int stateName;

    public State(int stateId, int stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public State() {}

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getStateName() {
        return stateName;
    }

    public void setStateName(int stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "States{" +
                "stateId=" + stateId +
                ", stateName=" + stateName +
                '}';
    }
}
