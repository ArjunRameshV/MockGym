package org.example.environment.api;

import com.google.gson.Gson;
import org.example.environment.gridworld.GridWorld;

import javax.swing.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Path("/grid")
public class SendTheGrid {

    Gson gson = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GetGrid(){
        HashMap<Integer, Integer> magicSquares = new HashMap<Integer, Integer>(){{
            put(2,4);
            put(5,7);
        }};
        GridWorld gridWorld = new GridWorld(5,5, magicSquares);
        String json = gson.toJson(gridWorld.getGrid());
        return json;
    }

}
