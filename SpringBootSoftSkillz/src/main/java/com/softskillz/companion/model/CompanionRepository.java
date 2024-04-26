package com.softskillz.companion.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanionRepository extends JpaRepository<CompanionBean, Integer> {
	public Optional<CompanionBean> findBycompanionUsername(String companionUsername);

	@Query("SELECT c FROM CompanionBean c WHERE (c.companionLearningInterest = :interest OR c.companionGender = :gender OR c.companionFirstLanguage = :firstLanguage OR c.companionSpeakingLanguage = :speakingLanguage OR c.companionLearningFrequency = :learningFrequency) AND c.companionUsername != :username")
	List<CompanionBean> findByMatchRequirement(@Param("interest") String interest,@Param("gender") String gender,@Param("firstLanguage") String firstLanguage,@Param("speakingLanguage") String speakingLanguage,@Param("learningFrequency") String learningFrequency, @Param("username") String username);
}
