package Controller;

import Model.RatingsAndReviews;
import Service.RatingsandReviewsService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/controller")
public class RatingsAndReviewsController {
    @Autowired
    private RatingsandReviewsService ratingsandReviewsService;

    Logger logger= LoggerFactory.getLogger(RatingsAndReviewsController.class);

    @ApiOperation("Get all the Details")
    @GetMapping(path = "/getAllDetails",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RatingsAndReviews> getAllDetails(){
        return ratingsandReviewsService.getAll();
    }
    @ApiOperation("Get Details by entering Id")
    @GetMapping(path = "/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<RatingsAndReviews> one(@PathVariable("orderId") Integer orderId){
        logger.trace("In GetMapping By Id");
        return ratingsandReviewsService.getone(orderId);
    }

    @ApiOperation("Get Details by entering Name")
    @GetMapping(path = "get-name/{pname}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RatingsAndReviews> getByName(@PathVariable("itemName") String itemName){
        logger.trace("In GetMapping By Name");
        return ratingsandReviewsService.getbyName(itemName);
    }
    @ApiOperation("Leave Your Reviews and Ratings")
    @PostMapping(path = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RatingsAndReviews> givereviews(@RequestBody RatingsAndReviews ratingsAndReviews){
        return ratingsandReviewsService.give(ratingsAndReviews);
    }
    @ApiOperation("Update Your Reviews and Ratings")
    @PostMapping(path = "/updatingReviews",produces = MediaType.APPLICATION_JSON_VALUE)
    public RatingsAndReviews updating(@RequestBody RatingsAndReviews ratingsAndReviews){
        return ratingsandReviewsService.updated(ratingsAndReviews);
    }

}
