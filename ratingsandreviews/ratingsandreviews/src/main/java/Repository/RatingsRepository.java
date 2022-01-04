package Repository;

import Model.RatingsAndReviews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RatingsRepository extends MongoRepository<RatingsAndReviews,Integer> {

    @Query(" {'itemName : '?0' ")
    List<RatingsAndReviews> findByname(String itemName);
}
