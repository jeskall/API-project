package com.surfer.services;

import java.util.Collection;

import com.surfer.Entities.Beach;
import com.surfer.Entities.Weather;
import com.surfer.repositories.BeachRepository;
import com.surfer.repositories.BeachSqlRepository;
import com.surfer.repositories.WeatherSqlRepository;
import com.surfer.request.AddBeachRequest;
import com.surfer.request.AddWeatherRequest;
import com.surfer.request.UpdateBeachRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BeachService {

    @Autowired
    private BeachSqlRepository beachRepo;

    public Collection<Beach> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "beachName");
        return beachRepo.findAll();
    }

    @Autowired
    private WeatherSqlRepository weatherRepo;

    public Beach getByID(Long id) {
        return beachRepo.findById(id).get();
    }

    public Collection<Beach> getByBeachName(String beachName) {
        return beachRepo.findByBeachName(beachName);

    }

    public Collection<Beach> getByBeachLocation(String beachLocation) {
        return beachRepo.findByLocation(beachLocation);
    }

    public Beach addBeach(AddBeachRequest request) {

        var beach = new Beach();
        beach.setBeachName(request.getBeachName());
        beach.setLocation(request.getBeachName());
        beachRepo.save(beach);
        return beach;

    }

    public void addWeather(AddWeatherRequest request) {
        var beach = beachRepo.findById(request.getBeachId()).get();
        var weather = new Weather();
        weather.setWaves(request.getWaves());
        weather.setSharksType(request.getSharksType());
        weather.setTemperature(request.getTemperature());
        weather.setWind(request.getWind());
        weather.setBeach(beach);
        weatherRepo.save(weather);

    }

    public Beach updateBeach(Long id, UpdateBeachRequest request) {
        var beach = beachRepo.findById(id).get();
        beach.setBeachName(request.getBeachName());
        beach.setLocation(request.getLocation());
        return beachRepo.save(beach);

    }

    public void deleteBeach(Long id) {
        beachRepo.deleteById(id);
    }

}
