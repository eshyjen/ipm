package com.ericsson.ipm.v1.service;

import java.util.List;
import java.util.Map;

import com.ericsson.ipm.v1.domain.UserProfile;
import com.ericsson.ipm.v1.domain.VerificationToken;
import com.ericsson.ipm.v1.dto.RegistrationDTO;
import com.ericsson.ipm.v1.exception.EmailExistsException;

public interface UserProfileService {


	public List<UserProfile> findBySignumId(final String signumId);

	public UserProfile findById(final Integer userId);

	public UserProfile findByEmail(final String email);

	public UserProfile findUserDetailsById(final Integer userId);

	public UserProfile save(UserProfile entity);

	public void remove(UserProfile entity);

	public UserProfile update(UserProfile entity);

	public List<UserProfile> findAll();

	public List<UserProfile> findBySignunidWithRole(Object signunid);

	public UserProfile findByIdWithAsset(Object id);

	public UserProfile getRefById(final Integer userId);

	public UserProfile findByIdWithDeliveryQuality(Object id);

	public UserProfile registerNewUserAccount(final RegistrationDTO accountDto) throws EmailExistsException;

	public void createVerificationTokenForUser(final UserProfile user, final String token);

	public VerificationToken getVerificationToken(final String VerificationToken);

	 public VerificationToken generateNewVerificationToken(final String existingVerificationToken);

	 public UserProfile getUser(final String verificationToken);
	 public UserProfile register(String signum);

	 public Map<String, String> generateExactPfUrl(String signum);

	 public Map<String, String> fetchManagedPeopleList(Map<String, String> map);



	 public UserProfile findByIdWithOperationalDiscipline(Object id);

	 public UserProfile findByIdWithMandatoryCertification(Object id);

	 public UserProfile findByIdWithCertification(Object id);

	 public UserProfile findByIdWithGoal(Object id);

	 public UserProfile getUserDetails(String signunid);

	public UserProfile findByTrainingName(String trainingName);





}
