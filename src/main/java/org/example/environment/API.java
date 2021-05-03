package org.example.environment;

import org.example.environment.mock.MockResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class API {

    @GET
    @Path("/observations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObservations(){
        MockResponse mockResponse = new MockResponse();
        return Response.status(200).entity(mockResponse.getMockObservation()).build();
    }

}
