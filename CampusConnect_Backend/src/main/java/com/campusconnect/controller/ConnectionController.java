package com.campusconnect.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


    @PutMapping("/{id}/accept")
    public Connection acceptRequest(
            @PathVariable Long id) {


    @PutMapping("/{id}/reject")
    public Connection rejectRequest(
            @PathVariable Long id) {


}