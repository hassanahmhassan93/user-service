package com.example.service;

import com.example.client.PreferenceClient;
import com.example.client.responsemodel.PreferenceResModel;
import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.model.UserReqModel;
import com.example.model.UserResModel;
import com.example.repository.UserRepository;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class UserService {

    private final UserRepository userRepository;
    private final PreferenceClient preferenceClient;

    public UserService(UserRepository userRepository, PreferenceClient preferenceClient) {

        this.userRepository = userRepository;
        this.preferenceClient = preferenceClient;
    }

    public UserResModel createUser(UserReqModel userReqModel) {

        return mapToUserResModel(userRepository.save(mapToUser(userReqModel)), null);
    }

    public List<UserResModel> getUsers() {

        List<User> users = (List<User>) userRepository.findAll();
        return users.stream()
                .map(user -> mapToUserResModel(user, null))
                .collect(Collectors.toList());
    }

    public Long countUsers() {
        return userRepository.count();
    }

    public UserResModel getUser(int id) {

        Optional<PreferenceResModel> optionalPreferenceResModel = preferenceClient.getUserPreference(id);
        PreferenceResModel preferenceResModel = optionalPreferenceResModel.isPresent() ? optionalPreferenceResModel.get() : null;
        return mapToUserResModel(userRepository.findById(id).get(), preferenceResModel);
    }

    public UserResModel updateUser(int id, UserReqModel userReqModel) {

        User user = userRepository.findById(id).get();

        user.setName(userReqModel.getName());
        user.setMobile(userReqModel.getMobile());
        user.setEmail(userReqModel.getEmail());

        return mapToUserResModel(userRepository.update(user), null);
    }

    public void deleteUser(int id) {

        userRepository.deleteById(id);
    }

    private User mapToUser(UserReqModel userReqModel) {

        User user = new User();

        user.setName(userReqModel.getName());
        user.setMobile(userReqModel.getMobile());
        user.setEmail(userReqModel.getEmail());

        return user;
    }

    private UserResModel mapToUserResModel(User user, PreferenceResModel preferenceResModel) {

        UserResModel userResModel = new UserResModel();

        userResModel.setId(user.getId());
        userResModel.setName(user.getName());
        userResModel.setMobile(user.getMobile());
        userResModel.setEmail(user.getEmail());

        if (preferenceResModel != null)
            userResModel.setPreferenceResModel(preferenceResModel);

        return userResModel;
    }
}
