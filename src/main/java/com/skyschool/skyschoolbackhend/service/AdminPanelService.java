package com.skyschool.skyschoolbackhend.service;

import com.skyschool.skyschoolbackhend.dto.Request.AdminRequest;
import com.skyschool.skyschoolbackhend.dto.Response.AdminResponse;
import com.skyschool.skyschoolbackhend.entity.AdminPanel;
import com.skyschool.skyschoolbackhend.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class AdminPanelService {

    private final AdminRepository adminRepository;

    public AdminPanel createAdmin(AdminRequest adminRequest) {

        AdminPanel adminPanel = new AdminPanel();

        String uuid = UUID.randomUUID().toString();
        adminPanel.setId(uuid);

        adminPanel.setAdminName(adminRequest.getAdminName());
        adminPanel.setAdminEmail(adminRequest.getAdminEmail());
        adminPanel.setPassword(adminRequest.getPassword());
        adminPanel.setAdminPhone(adminRequest.getAdminPhone());
        adminPanel.setGender(adminRequest.getGender());

        adminRepository.saveAndFlush(adminPanel);
        return adminPanel;
    }


    public List<AdminResponse> getAllAdminInformation(){

        List<AdminResponse> adminResponseList = new ArrayList<>();
        List<AdminPanel>adminPanelOptional = adminRepository.findAll();

       // List<AdminResponse> adminResponseList = new ArrayList<>();
       // List<AdminPanel>adminPanelOptional = new ArrayList<>();
      //  adminPanelOptional = adminRepository.findAll();

        for (AdminPanel adminPanel : adminPanelOptional){

            AdminResponse adminResponse = new AdminResponse();

            adminResponse.setId(adminPanel.getId());
            adminResponse.setAdminName(adminPanel.getAdminName());
            adminResponse.setAdminEmail(adminPanel.getAdminEmail());
            adminResponse.setAdminPhone(adminPanel.getAdminPhone());
            adminResponse.setGender(adminResponse.getGender());

            adminResponseList.add(adminResponse);
        }
        return adminResponseList;
    }


    public AdminResponse getAdminInformationById(String id){

        Optional<AdminPanel> optionalAdminPanel = adminRepository.findAllById(id);

        if (!optionalAdminPanel.isPresent()){
            throw new RuntimeException("Admin Id Not Present");
        }

        AdminPanel adminPanel = optionalAdminPanel.get();

        return AdminResponse.builder()
                .id(adminPanel.getId())
                .adminName(adminPanel.getAdminName())
                .adminEmail(adminPanel.getAdminEmail())
                .adminPhone(adminPanel.getAdminPhone())
                .build();
    }


    public void updateAdminInformationById(String id, AdminRequest adminRequest) {

        Optional<AdminPanel> optionalAdminPanel = adminRepository.findAllById(id);

        if (!optionalAdminPanel.isPresent()) {
            throw new RuntimeException("Admin Id Not Present");
        }

        AdminPanel adminPanel = optionalAdminPanel.get();

        adminPanel.setAdminName(adminRequest.getAdminName());
        adminPanel.setAdminEmail(adminRequest.getAdminEmail());
        adminPanel.setAdminPhone(adminRequest.getAdminPhone());

        adminRepository.save(adminPanel);
    }


    public ResponseEntity<Void> deleteAdminInformationBy(String id){

            Optional<AdminPanel> optionalAdminPanel = adminRepository.findAllById(id);

            if (!optionalAdminPanel.isPresent()){
                throw new RuntimeException("Admin Id Not Present");
            }

            AdminPanel adminPanel = optionalAdminPanel.get();
            adminRepository.delete(adminPanel);

            return null;
        }

}

