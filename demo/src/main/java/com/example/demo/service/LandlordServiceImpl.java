package com.example.demo.service;

import com.example.demo.model.Landlord;
import com.example.demo.model.User;
import com.example.demo.repository.LandlordRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LandlordServiceImpl implements LandlordService {

    @Autowired
    private LandlordRepository landlordRepository;

    @Override
    public List<Landlord> getAllLandlords() {
        return (List<Landlord>) landlordRepository.findAll();
    };

    @Override
    public Landlord getLandlordById(int id) {
        Optional<Landlord> optionalLandlord = landlordRepository.findById(id);
        return optionalLandlord.orElse(null);
    }

    @Override
    public Landlord createLandlord(Landlord landlord) {
        return landlordRepository.save(landlord);
    }

    @Override
    public Landlord updateLandlord(int id, Landlord landlordDetails) {
        Optional<Landlord> optionalLandlord = landlordRepository.findById(id);
        if (optionalLandlord.isPresent()) {
            Landlord existingLandlord = optionalLandlord.get();
            existingLandlord.setEmail(landlordDetails.getEmail());
            existingLandlord.setPassword(landlordDetails.getPassword());
            return landlordRepository.save(existingLandlord);
        }
        return null;
    }

    @Override
    public void deleteLandlord(int id) {
        landlordRepository.deleteById(id);
    }
    // This method below is an examples used to filter all person and return the one with gender "M"
//    public List<TestTable> getAllTestTableRecords() {
//        List<TestTable> allRecords = (List<TestTable>) testTableRepository.findAll();
//
//        List<TestTable> filteredRecords = new ArrayList<>();
//        for (TestTable record : allRecords) {
//            if ("M".equals(record.getGender())) {
//                filteredRecords.add(record);
//            }
//        }
//
//        return filteredRecords;
//
//    }


    // Other service methods for CRUD operations if needed
}
