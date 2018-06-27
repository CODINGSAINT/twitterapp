package hello;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/")
public class HelloController {

    private Twitter twitter;
    private String trendsURL="https://api.twitter.com/1.1/trends/place.json?id=23424848";
    
    @Autowired
    private RestTemplate restTemplate;

    private ConnectionRepository connectionRepository;
    
    private String messages[]= {
    		"Maheer is the youngest son of Farooq a carpenter.",
    		 " He is suffering from a rare and life threatening disease Glanzmann's thrombasthenia (a platelet function disorder).",
    		" Farooq’s daughter too suffered from the same illness. ",
    		"Farooq and his wife are devastated this time, but are determined to go to any length to protect their kid. Little Maheer is getting treated at AIIMS, Delhi",
    		//" Farooq spent all he had to save his daughter’s life but couldn’t save her, and the kid left for the heavenly abode at the tender age of five. Unfortunately Maheer too has been detected from the same life threatening disease",
    		"Doctors have suggested bone marrow transplant for the kid. ",
    		"With God’s grace father and sons bone marrow has been matched but they lack the fund needed for the treatment",
    		"Maheer and his parents desperately need help to save his life. ",
    		"The estimated money for the treatment is 10 lac. With our help Baby Maheer can be saved",
    		 "  Your support will save his life",
    			
    };

    @Inject
    public HelloController(Twitter twitter, ConnectionRepository connectionRepository) {
        this.twitter = twitter;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String helloTwitter(Model model) {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }

        model.addAttribute(twitter.userOperations().getUserProfile());
        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
         model.addAttribute("friends", friends);
        return "hello";
    }

    @RequestMapping("trends")
    public String trends(Model model) throws IOException {
        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
            return "redirect:/connect/twitter";
        }

        model.addAttribute(twitter.userOperations().getUserProfile());

        Map<String,Object>apia=new HashMap<String,Object>();
        Object a=twitter.restOperations().getForObject(trendsURL,Object.class);
        ObjectMapper mapper = new ObjectMapper();
       String s= mapper.writeValueAsString(a);
       //String s1=s.replaceFirst("[", "");
       String s2=s.substring(1,s.length()-1);
       TwitterTrend trnds= mapper.readValue(s2, TwitterTrend.class);
       model.addAttribute("trends", trnds.getTrends());
       for(int i=0;i<10;i++) {
    	   Trends t=trnds.getTrends()[i];
    	   int index = new Random().nextInt(messages.length);
    	   String msg=messages[index];
    	 twitter.timelineOperations().updateStatus(t.getName()+" #SaveMaheer ,"+msg +" - "+System.currentTimeMillis()
    	 		+ " https://milaap.org/fundraisers/help-baby-maheer");
       }
     

        return "trends";
    }
       private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

   
}
