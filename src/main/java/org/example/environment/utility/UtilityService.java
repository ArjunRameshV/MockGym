package org.example.environment.utility;

import ai.djl.ndarray.NDArray;
import org.example.environment.structure.Observation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface UtilityService {
    void initActionSpace(HashMap<String, Integer> actionSpace, int m);
    void  initPossibleActions(List<String> possibleActions);
    void addMagicSquares(HashMap<Integer, Integer> magicSquares, int[][] grid, int n, int m);
    boolean isTerminalState(Integer state,ArrayList<Integer> stateSpace, ArrayList<Integer> stateSpacePlus);
    ArrayList<Integer> getAgentRowAndColumn(int agentPosition, int n, int m);
    void setState(int state, int[][] grid, int agentPosition, int n, int m);
    boolean offGridMove(int state, int newState,  ArrayList<Integer> stateSpace, int m,int n);
    Observation step(String action, int agentPosition, HashMap<String, Integer> actionSpace, HashMap<Integer, Integer> magicSquares, int[][] grid,
                     ArrayList<Integer> stateSpace, ArrayList<Integer> stateSpacePlus, int n, int m);
    void printGrid(int[][] grid, int n, int m);
}
