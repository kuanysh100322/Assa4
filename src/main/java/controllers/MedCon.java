package controllers;

import entities.Medicine;
import repositories.interfaces.ForMedRepos;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("medicines")
public class MedCon {
    @Inject
    private ForMedRepos forMedRepos;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMed(Medicine medicine) {
        boolean created;

        try
        {
            created = forMedRepos.addMed(medicine);
        }
        catch (ServerErrorException e)
        {
            return Response.serverError().entity(e.getMessage()).build();
        }

        if (!created)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity("Medicine can't be created!").build();
        }

        return Response.status(Response.Status.CREATED).entity("Medicine was created successfully!").build();
    }

    @GET

    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMed(@PathParam("id") int id) {
        Medicine med;
        try {
            med = forMedRepos.getById(id);
        } catch (ServerErrorException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }

        if (med == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Medicine does not exist!").build();
        }

        return Response.status(Response.Status.OK).entity(med).build();
    }

    @DELETE

    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeMed(@PathParam("id") int id)
    {
        boolean deleted;

        try
        {
            deleted = forMedRepos.removeMed(id);
        } catch (ServerErrorException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }

        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND).entity("Medicine doesn't exist!").build();
        }

        return Response.status(Response.Status.OK).entity("Medicine was deleted successfully!").build();
    }

    @GET


    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByName(@PathParam("name") String name) {
        ArrayList<Medicine> medicines;

        try
        {
            medicines = forMedRepos.searchByName(name);
        }
        catch (ServerErrorException e)
        {
            return Response.status(500).entity(e.getMessage()).build();
        }

        if (medicines.isEmpty())
        {
            return Response.status(Response.Status.NOT_FOUND).entity("Medicines don't exist!").build();
        }

        return Response.status(Response.Status.OK).entity(medicines).build();
    }
}
