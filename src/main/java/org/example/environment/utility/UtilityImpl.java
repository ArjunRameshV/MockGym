package org.example.environment.utility;

import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.index.NDIndex;
import org.example.environment.structure.Observation;

import java.util.*;

public class UtilityImpl implements UtilityService{

    @Override
    public void initActionSpace(HashMap<String, Integer> actionSpace, int m){
        actionSpace.put("U", -1*m);
        actionSpace.put("D", m);
        actionSpace.put("L", -1);
        actionSpace.put("R", 1);
    }

    @Override
    public void initPossibleActions(List<String> possibleActions){
        possibleActions.add("U");
        possibleActions.add("D");
        possibleActions.add("L");
        possibleActions.add("R");
    }

    @Override
    public void addMagicSquares(HashMap<Integer, Integer> magicSquares, int[][] grid, int n, int m){
        int i=2;
        for(Map.Entry<Integer, Integer> square: magicSquares.entrySet()){
            int x = square.getKey()/m;
            int y = Math.floorMod(square.getKey(),n);
//            System.out.println(String.format("%d,%d", x,y));
            grid[x][y] = i;
            i+=1;
            x = square.getValue()/m;
            y = Math.floorMod(square.getValue(),n);
//            System.out.println(String.format("%d,%d", x,y));
            grid[x][y] = i;
            i+=1;
        }
    }

    @Override
    public boolean isTerminalState(Integer state, ArrayList<Integer> stateSpace, ArrayList<Integer> stateSpacePlus){
        if(stateSpacePlus.contains(state) && !stateSpace.contains(state)) return true;
        return false;
    }

    @Override
    public ArrayList<Integer> getAgentRowAndColumn(int agentPosition, int n, int m){
        int x = agentPosition/m;
        int y = Math.floorMod(agentPosition,n);
        return new ArrayList<>(Arrays.asList(x,y));
    }

    @Override
    public void setState(int state, int[][] grid, int agentPosition, int n, int m){
        ArrayList<Integer> agentPositions = getAgentRowAndColumn(agentPosition, n, m);
        grid[agentPositions.get(0)][agentPositions.get(1)] = 0;;
        agentPosition  = state;
        agentPositions = getAgentRowAndColumn(agentPosition, n, m);
        grid[agentPositions.get(0)][agentPositions.get(1)] = 1;
    }

    @Override
    public boolean offGridMove(int state, int newState,  ArrayList<Integer> stateSpacePlus, int m, int n){
        if(!stateSpacePlus.contains(state)){
            return true;
        } else if(newState<0 || newState>=n*m){
            return true;
        }else if (state%n==0 && Math.floorMod(newState,n)==n-1){
            return true;
        } else if (Math.floorMod(newState,n)==n-1 && newState%n==0) {
            return true;
        } else if (state%m==0 && Math.floorMod(newState,m)==m-1){
            return true;
        } else return state % m == m - 1 && newState % m == 0;
    }

    @Override
    public Observation step(String action, int agentPosition, HashMap<String, Integer> actionSpace, HashMap<Integer, Integer> magicSquares, int[][] grid,
                            ArrayList<Integer> stateSpace, ArrayList<Integer> stateSpacePlus, int n, int m){
//        ArrayList<Integer> positions = getAgentRowAndColumn(agentPosition, n, m);
        int resultingState = agentPosition + actionSpace.get(action);
        if (magicSquares.containsKey(resultingState)){
            resultingState = magicSquares.get(resultingState);
        }
        Integer reward = (isTerminalState(resultingState, stateSpace, stateSpacePlus)) ? 0 : -1;
        if(!offGridMove(agentPosition, resultingState, stateSpacePlus, m, n)){
            setState(resultingState, grid, agentPosition, n, m);
            return new Observation(resultingState, reward, isTerminalState(resultingState, stateSpace, stateSpacePlus), null);
        }
        return new Observation(agentPosition, reward, isTerminalState(agentPosition,stateSpace, stateSpacePlus), null);
    }

    @Override
    public void printGrid(int[][] grid, int n, int m){
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                System.out.printf("%d ",grid[i][j]);
            }
            System.out.println();
        }
    }

}
