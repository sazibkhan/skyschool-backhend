package com.skyschool.skyschoolbackhend.controller;

import com.skyschool.skyschoolbackhend.dto.Request.AdminRequest;
import com.skyschool.skyschoolbackhend.dto.Response.AdminResponse;
import com.skyschool.skyschoolbackhend.entity.AdminPanel;
import com.skyschool.skyschoolbackhend.service.AdminPanelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/sky/school")
public class AdminController {

    private final AdminPanelService adminPanelService;

    @PostMapping("/admin/insert")
    public ResponseEntity<AdminPanel> createAdminPanel(@RequestBody AdminRequest adminRequest){
        return new ResponseEntity(adminPanelService.createAdmin(adminRequest), HttpStatus.CREATED);
    }

    @GetMapping("/admin/get/allInformation")
    public ResponseEntity<List<AdminResponse>> getAllAdminData(){
        return new ResponseEntity(adminPanelService.getAllAdminInformation(),HttpStatus.OK) ;
    }

    @GetMapping("/admin/get/allInformation/by/{id}")
    public ResponseEntity<AdminResponse>getAdminDataByAdminId(@PathVariable String id){
        return new ResponseEntity(adminPanelService.getAdminInformationById(id),HttpStatus.OK);
    }


    @PutMapping("/admin/get/Information/updateBy/{id}")
    public ResponseEntity <Void> getAdminDataUpdateByAdminId(@RequestBody AdminRequest adminRequest,@PathVariable String id){
        adminPanelService.updateAdminInformationById(id,adminRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete/Information/by/{id}")
    public ResponseEntity<Void> deleteAdminDataByAdminId(@PathVariable String id){
        return new ResponseEntity(adminPanelService.deleteAdminInformationBy(id),HttpStatus.NO_CONTENT);
    }

}
