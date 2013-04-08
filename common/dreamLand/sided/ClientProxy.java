package dreamLand.sided;

import com.jadarstudios.api.developercapesapi.DeveloperCapesAPI;

public class ClientProxy extends CommonProxy {
    // TODO More Stuff

    // Code that adds capes :D Github link for it to work:
    // https://github.com/jadar/DeveloperCapesAPI
    @Override
    public void initCapes() {
        // link for the file that makes the capes work
        DeveloperCapesAPI.init("http://db.tt/Pkbjs1uR");
    }
}