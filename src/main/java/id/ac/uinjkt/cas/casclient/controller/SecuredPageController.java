package id.ac.uinjkt.cas.casclient.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecuredPageController {

    @GetMapping("/secured")
    public String index(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (auth != null
                && auth.getPrincipal() != null
                && auth.getPrincipal() instanceof UserDetails) {
            modelMap.put("username", ((UserDetails) auth.getPrincipal()).getUsername());
        }
        return "secure/index";
    }
}
