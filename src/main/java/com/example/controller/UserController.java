package com.example.controller;

import com.example.model.User;
import com.example.model.UserReqModel;
import com.example.model.UserResModel;
import com.example.service.UserService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Post
    public HttpResponse<UserResModel> createUser(@Body @Valid UserReqModel userReqModel) {

        return  HttpResponse.created(this.userService.createUser(userReqModel));
    }

    @Get
    public HttpResponse<List<UserResModel>> getUsers() {

        return HttpResponse.ok(this.userService.getUsers());
    }

    @Get("/{id}")
    public HttpResponse<UserResModel> getUser(@PathVariable int id) {

        return HttpResponse.ok(this.userService.getUser(id));
    }

    @Put("/{id}")
    public HttpResponse<UserResModel> updateUser(@PathVariable int id, @Body UserReqModel userReqModel) {

        return HttpResponse.ok(this.userService.updateUser(id, userReqModel));
    }

    @Delete("/{id}")
    public HttpResponse<Void> deleteUser(@PathVariable int id) {

        this.userService.deleteUser(id);
        return HttpResponse.ok();
    }
}
