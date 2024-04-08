package org.acme;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.ArrayList;
import java.util.List;

@Path("/music")
public class MusicResource {

    private List<Music> musicCatalog = new ArrayList<>();

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Music> addMusic(
            @FormParam("title") String title,
            @FormParam("artist") String artist) {
        musicCatalog.add(new Music(title, artist));
        return musicCatalog;
    }

    @GET
    @Path("/get/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Music getMusic(@PathParam("title") String title) {
      
        for (Music music : musicCatalog) {
            if (music.getTitle().equalsIgnoreCase(title)) {
                return music;
            }
        }
        
        return null;
    }
}


