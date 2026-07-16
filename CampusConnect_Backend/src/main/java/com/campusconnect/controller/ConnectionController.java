package com.campusconnect.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.campusconnect.dto.ConnectedAlumniDTO;
import com.campusconnect.dto.ConnectedStudentDTO;
import com.campusconnect.entity.Connection;
import com.campusconnect.service.ConnectionService;



@RestController
@RequestMapping("/api/connections")
@CrossOrigin("*")
public class ConnectionController {



    @Autowired
    private ConnectionService connectionService;




    // SEND CONNECTION REQUEST
    @PostMapping
    public Connection sendRequest(
            @RequestBody Connection connection) {


        return connectionService.sendRequest(connection);

    }






    // GET ALL CONNECTIONS
    @GetMapping
    public List<Connection> getAllConnections() {


        return connectionService.getAllConnections();

    }







    // STUDENT VIEW CONNECTED ALUMNI
    @GetMapping("/student/{studentId}")
    public List<ConnectedAlumniDTO> getStudentConnections(
            @PathVariable Long studentId) {


        return connectionService
                .getStudentConnections(studentId);

    }







    // ALUMNI VIEW CONNECTED STUDENTS
    @GetMapping("/alumni/{alumniId}")
    public List<ConnectedStudentDTO> getAlumniConnections(
            @PathVariable Long alumniId) {


        return connectionService
                .getAlumniConnections(alumniId);

    }







    // ACCEPT REQUEST
    @PutMapping("/{id}/accept")
    public Connection acceptRequest(
            @PathVariable Long id) {


        return connectionService
                .acceptRequest(id);

    }







    // REJECT REQUEST
    @PutMapping("/{id}/reject")
    public Connection rejectRequest(
            @PathVariable Long id) {


        return connectionService
                .rejectRequest(id);

    }







    // DELETE CONNECTION
    @DeleteMapping("/{id}")
    public String deleteConnection(
            @PathVariable Long id) {


        connectionService.deleteConnection(id);


        return "Connection deleted successfully";

    }


}