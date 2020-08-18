/*
 * package com.customer.registration.controller;
 * 
 * import org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.servlet.config.annotation.EnableWebMvc;
 * 
 * import com.customer.registration.models.CustomerRegistrationDetail;
 * 
 * import javax.validation.Valid;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory;
 * 
 * @EnableWebMvc
 * 
 * @RestController
 * 
 * @CrossOrigin public class testcontroller {
 * 
 * private static final Logger LOGGER =
 * LoggerFactory.getLogger(testcontroller.class);
 * 
 * @GetMapping({"/home"})
 * 
 * @ResponseBody public ResponseEntity<String> home() { String msg =
 * "inside home"; LOGGER.info("inside", msg); return ResponseEntity.ok(msg); }
 * 
 * 
 * @PostMapping(path = "/login")
 * 
 * @ResponseBody public ResponseEntity<String> login(@Valid @RequestBody
 * CustomerRegistrationDetail cus ) { LOGGER.info("inside_login", cus);
 * ResponseEntity<String> responseEntity = null; return responseEntity =
 * ResponseEntity.ok("Login successful"); }
 * 
 * @PostMapping(path = "/loginnew")
 * 
 * @ResponseBody public ResponseEntity<String> login_new( ) {
 * ResponseEntity<String> responseEntity = null; return responseEntity =
 * ResponseEntity.ok("Login successful"); } }
 */