package cl.usach.spring.backend.rest;


import cl.usach.spring.backend.entities.*;
import cl.usach.spring.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicService {

    public Topic topic;
    @Autowired
    private TopicRepository topicRepository;
    
    

    @CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<Topic> getAllUsers() {
		return topicRepository.findAll();
	}
 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Topic findOne(@PathVariable("id") Integer id){return this.topicRepository.findOne(id);}
    
    @RequestMapping(value = "/{id}/tweetsTopic",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<TweetsTopic>> getTweetsTopic(@PathVariable("id") Integer id){
        if(topicRepository.exists(id)){
            List<TweetsTopic> tweets = topicRepository.findOne(id).getTweetsTopicList();
            return new ResponseEntity<List<TweetsTopic>>(tweets, HttpStatus.OK);
        }else{return new ResponseEntity<List<TweetsTopic>>(HttpStatus.NOT_FOUND);}
    }
}
