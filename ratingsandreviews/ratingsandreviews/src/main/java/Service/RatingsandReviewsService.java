package Service;

import Model.RatingsAndReviews;
import Repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class RatingsandReviewsService {
    @Autowired
    private RatingsRepository ratingsRepository;

    public List<RatingsAndReviews> getAll() {
        return ratingsRepository.findAll();
    }

    public List<RatingsAndReviews> give(RatingsAndReviews ratingsAndReviews) {
            ratingsRepository.save(ratingsAndReviews);
            return ratingsRepository.findAll();
    }

    public Optional<RatingsAndReviews> getone(Integer orderId) {
        return ratingsRepository.findById(orderId);
    }

    public List<RatingsAndReviews> getbyName(String itemName) {
        return ratingsRepository.findByname(itemName);
    }

    public RatingsAndReviews updated(RatingsAndReviews ratingsAndReviews) {
        Optional<RatingsAndReviews> optionalPmodule=ratingsRepository.findById(ratingsAndReviews.getOrderId());
        AtomicReference<RatingsAndReviews> atomicReference=new AtomicReference<>();
        optionalPmodule.ifPresentOrElse(ref-> {
            ref.setUpdatedtime(new Date());
            ref.setItemNames(ratingsAndReviews.getItemNames() != null ? ratingsAndReviews.getItemNames() : ref.getItemNames());
            ref.setDiscount(ratingsAndReviews.getDiscount() != null ? ratingsAndReviews.getDiscount() : ref.getDiscount());
            ref.setPrice(ratingsAndReviews.getPrice() != null ? ratingsAndReviews.getPrice() : ref.getPrice());
            ref.setStatus(ratingsAndReviews.isStatus()  ? ratingsAndReviews.isStatus() : ref.isStatus());
            atomicReference.set(ratingsRepository.save(ref));
        },()->{
            try {
                throw new Exception("SORRY ! WHAT ARE YOU LOOKING ABOUT");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        return atomicReference.get();
    }

}
