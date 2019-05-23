package com.n20145588109.main.service;

import com.n20145588109.main.domain.Profile;
import com.n20145588109.main.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<Profile> findAllProfileList(){
        return profileRepository.findAll();
    }

    public Profile findProfileById(Long idx){
        return profileRepository.findById(idx).orElse(new Profile());
    }

    public Profile saveProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public void deleteProfileByIdx(Long idx){
        profileRepository.deleteById(idx);
    }


}
