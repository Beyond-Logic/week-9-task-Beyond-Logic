package com.BeyondLogic.BlogAPI.Repository;

import com.BeyondLogic.BlogAPI.Model.Favourite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite, Long> {

}
