package cl.usach.spring.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.usach.spring.backend.repository.HistoryTweetsTopicRepository;
import cl.usach.spring.backend.entities.HistoryTweetsTopic;

@RestController
@RequestMapping("/htweets")
public class HistoryTweetsTopicService {
	public HistoryTweetsTopic hTweets;
    @Autowired
    private HistoryTweetsTopicRepository hTweetsRepository;
    
    

    @CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Iterable<HistoryTweetsTopic> getAllUsers() {
		return hTweetsRepository.findAll();
	}
 

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public HistoryTweetsTopic findOne(@PathVariable("id") Integer id){return this.hTweetsRepository.findOne(id);}
	
}
