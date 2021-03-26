package org.acme.movie;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/movies")
public class MovieResource {

    private static final Logger LOGGER = Logger.getLogger("MovieResource");

    @Inject
    @Channel("movies")
    Emitter<Movie> emitter;

    @POST
    public Response enqueueMovie(Movie movie) {
        LOGGER.infof("Sending movie %s to Kafka", movie.getTitle());
        emitter.send(movie);
        return Response.accepted().build();
    }
}
