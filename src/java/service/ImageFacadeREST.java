/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.Clasificacion;
import entities.ResponseApi;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author isai.castro
 */
@Stateless
@Path("image")
public class ImageFacadeREST extends AbstractFacade<Clasificacion> {
    @PersistenceContext(unitName = "app_test_serverPU")
    private EntityManager em;

    public ImageFacadeREST() {
        super(Clasificacion.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public ResponseApi create(Clasificacion entity) {
        return super.create(entity);
    }

     /**
     * Utility method to save InputStream data to target location/file
     * @param inStream - InputStream to be saved
     * @param target - full path to destination file
     */
	private void saveToFile(InputStream inStream, String target) throws IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(target));
		while ((read = inStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();
	}
    
    /**
     * Creates a folder to desired location if it not already exists
     * @param dirName - full path to the folder
     * @throws SecurityException - in case you don't have permission to create the folder
     */
	private void createFolderIfNotExists(String dirName) throws SecurityException {
    	File theDir = new File(dirName);
    	if (!theDir.exists()) {
    		theDir.mkdir();
    	}
    }
    
}
