package utils;

import model.State;

import java.util.List;

public interface StateInterface {
    public List<State> getAllStates();
    public State getStateId(int stateId);
    public void updateState(State state);
    public void deleteState(int stateId);
}
