package com.ajegames.storytime.resource;

import com.ajegames.storytime.model.SumGuess;
import com.ajegames.storytime.model.SumGuessingResults;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/sumguess")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SumGuessingResource {

    @POST
    public SumGuessingResults play(SumGuess sumGuess) {

        long generatedNumber = Math.round(Math.random() * 10);

        return SumGuessingResults.create(sumGuess, SumGuess.create(, 6));
    }
}
