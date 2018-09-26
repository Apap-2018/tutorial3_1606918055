package com.apap.tutorial3.service;

import com.apap.tutorial3.model.PilotModel;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

@Service
public class PilotInMemoryService implements PilotService {

    private List<PilotModel> archivePilot;

    public PilotInMemoryService() {
        this.archivePilot = new LinkedList<>();
    }

    @Override
    public void addPilot(PilotModel car) {
        this.archivePilot.add(car);
    }

    @Override
    public List<PilotModel> getListPilot() {
        return this.archivePilot;
    }

    private PilotModel getPilotByLambda(Function<PilotModel, Boolean> checker) {
        PilotModel pilot = null;

        Iterator<PilotModel> iter = this.archivePilot.iterator();
        while(iter.hasNext() && pilot == null) {
            PilotModel temp = iter.next();
            if(checker.apply(temp)) {
                pilot = temp;
            }
        }

        return pilot;
    }

    @Override
    public PilotModel getDetailPilotByLicenseNumber(String licenseNumber) {
        return this.getPilotByLambda(pilot -> pilot.getLicenseNumber().equals(licenseNumber));
    }

    private PilotModel getPilotById(String id) {
        return this.getPilotByLambda(pilot -> pilot.getId().equals(id));
    }

    @Override
    public PilotModel removePilot(String id) {
        PilotModel pilot = this.getPilotById(id);
        if(pilot != null)
            this.getListPilot().remove(pilot);
        return pilot;
    }
}
