package com.trilogy.cloudgamestorelevelupservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.trilogy.cloudgamestorelevelupservice.model.LevelUp;
import com.trilogy.cloudgamestorelevelupservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
//@CacheConfig(cacheNames = {"levelUps"})
public class LevelUpController {

    @Autowired
    ServiceLayer serviceLayer;

    /*************************************************
     * Level Up Service Controller
     * Path: /levelUp
     *************************************************/

    /**
     * Saves level up to database
     * @param levelUp
     * @return
     */
//    @CachePut(key = "#result.getLevelUpId()")
    @PostMapping(value = "/levelUp")
    @ResponseStatus(HttpStatus.CREATED)
    public LevelUp saveLevelUp(@RequestBody @Valid LevelUp levelUp) {
        return serviceLayer.saveLevelUp(levelUp);
    }

    /**
     * Retrieves all level ups from the database
     * @return
     */
    @GetMapping(value = "/levelUp")
    @ResponseStatus(HttpStatus.OK)
    @HystrixCommand(fallbackMethod = "reliable")
    public List<LevelUp> fetchAllLevelUp() {
        return serviceLayer.fetchAllLevelUp();
    }

    /**
     * Updates an existing level up entry when passed a valid level up object
     * @param levelUp
     */
//    @CacheEvict(key = "#levelUp.getLevelUpId()")
    @PutMapping(value = "/levelUp")
    @ResponseStatus(HttpStatus.OK)
    public void updateLevelUp(@RequestBody @Valid LevelUp levelUp) {
        serviceLayer.updateLevelUp(levelUp);
    }

    /*************************************************
     * Level Up Service Controller
     * Path: /levelUp/{levelUpId}
     *************************************************/


    /**
     * Retrieves one level up when passed a valid Level Up ID
     * @param levelUpId
     * @return
     */
//    @Cacheable
    @GetMapping(value = "/levelUp/{levelUpId}")
    @ResponseStatus(HttpStatus.OK)
    @HystrixCommand(fallbackMethod = "reliable")
    public LevelUp fetchLevelUp(@PathVariable int levelUpId) {
        return serviceLayer.fetchLevelUp(levelUpId);
    }

    /**
     * Deletes a level up entry from database when passed a valid level up ID
     * @param levelUpId
     */
//    @CacheEvict
    @DeleteMapping(value = "/levelUp/{levelUpId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLevelUp(@PathVariable int levelUpId) {
        serviceLayer.deleteLevelUp(levelUpId);
    }

    /**
     * Returns the level up for the customer ID given
     * @param customerId
     * @return
     */

//    @Cacheable
    @GetMapping(value = "/levelUp/customerId/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public LevelUp fetchLevelUpByCustomerId(@PathVariable int customerId) {
        return serviceLayer.fetchLevelUpByCustomerId(customerId);
    }

    public String reliable() {
        return "Service currently unavailable. Please try again later.";
    }
}
