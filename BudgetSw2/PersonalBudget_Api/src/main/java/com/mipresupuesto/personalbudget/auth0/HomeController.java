package com.mipresupuesto.personalbudget.auth0;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the home page.
 */
@Controller
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/")
	public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
		if (principal != null) {
			model.addAttribute("profile", principal.getClaims());
			log.info(principal.getIdToken().getTokenValue());
		}
		return "index";
	}
}	