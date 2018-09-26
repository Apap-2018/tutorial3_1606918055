package com.apap.tutorial3.service;

import com.apap.tutorial3.model.PilotModel;

import java.util.List;

/**
 * Car service
 */
public interface PilotService {

    void addPilot(PilotModel car);

    List<PilotModel> getListPilot();

    PilotModel getDetailPilotByLicenseNumber(String id);

    PilotModel removePilot(String id);
}
