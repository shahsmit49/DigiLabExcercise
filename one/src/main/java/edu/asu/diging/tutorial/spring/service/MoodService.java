package edu.asu.diging.tutorial.spring.service;

import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import edu.asu.diging.tutorial.spring.domain.Mood;

@Service
public class MoodService implements MoodServiceInterface {
	
	private ArrayList<String> moods = null;
	@PostConstruct
	public void init() {
		moods = new ArrayList<>();
		moods.add("happy");moods.add("sad");moods.add("angry");moods.add("jealous");
	}
	
	private String moodSelected;
	public Mood getCurrentMood() {
		moodSelected = moods.get(new Random().nextInt(moods.size()));
        return new Mood(moodSelected);
    }
	@Override
	public String message() {
		if(moodSelected.equals("happy")) {
			return "I had a monderful day";
		}
		if(moodSelected.equals("sad")) {
			return "I didn't catch mice";
		}
		if(moodSelected.equals("angry")) {
			return "I feel into the pool";
		}
		if(moodSelected.equals("jealous")) {
			return "I didn't get the new toy";
		}
		return "";
	}
}
