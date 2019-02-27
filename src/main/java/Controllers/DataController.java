package Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class DataController {

    @RequestMapping(value = "/updateData", method = RequestMethod.PUT)
    public @ResponseBody boolean updateData(@RequestBody Object student){
        return false;
    }

}
