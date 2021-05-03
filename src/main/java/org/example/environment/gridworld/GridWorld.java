package org.example.environment.gridworld;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


import org.example.environment.structure.Observation;
import org.example.environment.utility.UtilityImpl;
import org.example.environment.utility.UtilityService;


public class GridWorld {

    public static UtilityService utility = new UtilityImpl();

    int n;
    int m;
    HashMap<Integer, Integer> magicSquares;
    int[][] grid;
    ArrayList<Integer> stateSpace = new ArrayList<>();
    ArrayList<Integer> stateSpacePlus = new ArrayList<>();
    HashMap<String, Integer> actionSpace = new HashMap<>();
    List<String> possibleActions = new ArrayList<>();
    int agentPosition;
    Observation observation = new Observation(0,0,false, null);

    public GridWorld(int n, int m, HashMap<Integer, Integer> magicSquares){
        this.n = n;
        this.m = m;
        this.magicSquares = magicSquares;
        this.grid = new int[this.n][this.m];

        initStateSpaces();
        utility.initActionSpace(actionSpace, m);
        utility.initPossibleActions(possibleActions);
        utility.addMagicSquares(magicSquares,grid,n,m);
        this.agentPosition = 0;
    }

    private void initStateSpaces(){
        for(int i=0; i<this.n*this.m-1;i++) {
            this.stateSpace.add(i);
            this.stateSpacePlus.add(i);
        }
        this.stateSpacePlus.add(this.m*this.n-1);
    }

    public Integer reset(){
        this.agentPosition = 0;
        this.grid = new int[this.n][this.m];
        utility.addMagicSquares(this.magicSquares, this.grid, this.n, this.m);
        return this.agentPosition;
    }

    public String actionSpaceSample(){
        Random random = new Random();
        return this.possibleActions.get(random.nextInt(this.possibleActions.size()));
    }

    public Observation step(String action){
        return utility.step(action, this.agentPosition,
                this.actionSpace, this.magicSquares,
                this.grid, this.stateSpace, this.stateSpacePlus, this.n, this.m);
    }

    public void printTheGrid(){
        utility.printGrid(this.grid, this.n, this.m);
    }

    public void render(){
        System.out.println("-----------------------------------------------");
        for(int i=0;i<this.n;i++){
            for(int j=0;j<this.m;j++){
                if (this.grid[i][j]==0){
                    System.out.printf("-\t");
                } else if (this.grid[i][j]==1){
                    System.out.printf("X\t");
                } else if (this.grid[i][j]==2){
                    System.out.printf("Ain\t");
                } else if (this.grid[i][j]==3){
                    System.out.printf("Aout\t");
                } else if (this.grid[i][j]==4){
                    System.out.printf("Bin\t");
                } else if (this.grid[i][j]==5){
                    System.out.printf("Bout\t");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }

    // ---------- GETTERS
    public int getN() {
        return n;
    }
    public int getM() {
        return m;
    }
    public HashMap<Integer, Integer> getMagicSquares() {
        return magicSquares;
    }
    public int[][] getGrid() {
        return grid;
    }
    public ArrayList<Integer> getStateSpace() {
        return stateSpace;
    }
    public ArrayList<Integer> getStateSpacePlus() {
        return stateSpacePlus;
    }
    public HashMap<String, Integer> getActionSpace() {
        return actionSpace;
    }
    public List<String> getPossibleActions() {
        return possibleActions;
    }
    public int getAgentPosition() {
        return agentPosition;
    }
    public Observation getObservation() {
        return observation;
    }

    // ---------- SETTERS
    public void setN(int n) {
        this.n = n;
    }
    public void setM(int m) {
        this.m = m;
    }
    public void setMagicSquares(HashMap<Integer, Integer> magicSquares) {
        this.magicSquares = magicSquares;
    }
    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
    public void setStateSpace(ArrayList<Integer> stateSpace) {
        this.stateSpace = stateSpace;
    }
    public void setStateSpacePlus(ArrayList<Integer> stateSpacePlus) {
        this.stateSpacePlus = stateSpacePlus;
    }
    public void setActionSpace(HashMap<String, Integer> actionSpace) {
        this.actionSpace = actionSpace;
    }
    public void setPossibleActions(List<String> possibleActions) {
        this.possibleActions = possibleActions;
    }
    public void setAgentPosition(int agentPosition) {
        this.agentPosition = agentPosition;
    }
    public void setObservation(Observation observation) {
        this.observation = observation;
    }
}
