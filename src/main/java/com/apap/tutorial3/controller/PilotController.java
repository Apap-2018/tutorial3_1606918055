package com.apap.tutorial3.controller;

import com.apap.tutorial3.model.PilotModel;
import com.apap.tutorial3.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PilotController {

    @Autowired
    private PilotService pilotService;

    private static String redirectTo404() {
        return "redirect:/404";
    }

    @RequestMapping("/pilot/add")
    public String add(@RequestParam(value = "id") String id,
                      @RequestParam(value = "licenseNumber") String licenseNumber,
                      @RequestParam(value = "name") String name,
                      @RequestParam(value = "flyHour") int flyHour) {
        PilotModel pilot = new PilotModel(id, licenseNumber, name, flyHour);
        pilotService.addPilot(pilot);
        return "add";
    }

    private String viewPilotByLicenseNumber(String id, Model model) {
        PilotModel pilot = pilotService.getDetailPilotByLicenseNumber(id);
        if(pilot == null) {
            return PilotController.redirectTo404();
        }

        model.addAttribute("pilot", pilot);
        return "view-pilot";
    }

    @RequestMapping("/pilot/view")
    public String view(@RequestParam(value = "licenseNumber", required = false) String licenseNumber, Model model) {
        return this.viewPilotByLicenseNumber(licenseNumber, model);
    }

    @RequestMapping("/pilot/view/license-number/{licenseNumber}")
    public String viewPath(@PathVariable String licenseNumber, Model model) {
        return this.viewPilotByLicenseNumber(licenseNumber, model);
    }

    @RequestMapping("/pilot/viewall")
    public String viewAll(Model model) {
        model.addAttribute("listPilot", pilotService.getListPilot());
        return "viewall-pilot";
    }

    @RequestMapping("/pilot/update/license-number/{licenseNumber}/fly-hour/{flyHour}")
    public String updateAmount(@PathVariable String licenseNumber, @PathVariable int flyHour, Model model) {
        PilotModel pilot = pilotService.getDetailPilotByLicenseNumber(licenseNumber);
        if (pilot == null) {
            return PilotController.redirectTo404();
        }

        pilot.setFlyHour(flyHour);
        model.addAttribute("message", "Update fly hour berhasil");
        model.addAttribute("url", "/pilot/view/license-number/" + pilot.getLicenseNumber());
        return "success";
    }

    @RequestMapping("/pilot/delete/id/{id}")
    public String deleteCar(@PathVariable String id, Model model) {
        PilotModel pilot = pilotService.removePilot(id);

        if(pilot == null) {
            return PilotController.redirectTo404();
        }

        model.addAttribute("message", "Pilot id:" + id + " berhasil dihapus");
        return "success";
    }

    @RequestMapping("/404")
    public String http404() {
        return "http404";
    }
}
