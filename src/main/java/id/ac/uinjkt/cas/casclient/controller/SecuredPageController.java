package id.ac.uinjkt.cas.casclient.controller;

import java.security.Principal;
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
            modelMap.put("role", auth.getAuthorities().toString());

        }
        return "secure/index";
    }

    @GetMapping("/admin/halo")
    public String haloAdmin(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        if (auth != null
                && auth.getPrincipal() != null
                && auth.getPrincipal() instanceof UserDetails) {
            modelMap.put("username", ((UserDetails) auth.getPrincipal()).getUsername());
            modelMap.put("role", auth.getAuthorities().toString());

        }
        return "secure/haloadmin";
    }

    @GetMapping("/user/halo")
    public String haloUser(ModelMap modelMap) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        if (auth != null
                && auth.getPrincipal() != null
                && auth.getPrincipal() instanceof UserDetails) {
            modelMap.put("username", ((UserDetails) auth.getPrincipal()).getUsername());
            modelMap.put("role", auth.getAuthorities().toString());

        }
        return "secure/halouser";
    }
}
