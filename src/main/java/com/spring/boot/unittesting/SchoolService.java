package com.spring.boot.unittesting;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// School service class
public class SchoolService {
    private List<School> schools = new ArrayList<>();
    private Long nextId = 1L;

    // Add a new school
    public School addSchool(School school) {
        school.setId(nextId++);
        schools.add(school);
        return school;
    }

    // Update an existing school
    public School updateSchool(School newSchool) {
        Optional<School> schoolOptional = schools.stream()
                .filter(s -> s.getId().equals(newSchool.getId()))
                .findFirst();
        if (schoolOptional.isPresent()) {
            School school = schoolOptional.get();
            school.setName(newSchool.getName());
            school.setAddress(newSchool.getAddress());
            school.setPhoneNumber(newSchool.getPhoneNumber());
            return school;
        }
        return null;
    }

    // Delete a school
    public boolean deleteSchool(Long id) {
        return schools.removeIf(school -> school.getId().equals(id));
    }

    // Get a school by ID
    public School getSchool(Long id) {
        return schools.stream()
                .filter(school -> school.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Get all schools
    public List<School> getAllSchools() {
        return new ArrayList<>(schools);
    }
}