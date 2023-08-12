
package com.example.demo.controller;
import com.example.demo.model.Account;
import com.example.demo.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author Gev
 */
@RestController
@RequestMapping("/api/v2/accounts")
@Slf4j
public class RegisterController {

    @Autowired
    private RegisterService accountService;

    @PutMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> register(
            @RequestBody(required = true) Account registerRequest
    ) throws Exception {

        Optional<Account> doRegister = accountService.registerAccount(registerRequest);
        if (doRegister.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(doRegister.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(("Could not register user"));
    }
    
    @GetMapping("sign")
    public ResponseEntity signIn(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String password){
        Optional<Optional<Account>> findByMailAndByPassword = accountService.findByMailAndByPassword(email, password);
        if(findByMailAndByPassword.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(findByMailAndByPassword.get().get());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("pls correct email or password!");
        }
    }

    
    
    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addAccount(
            @RequestBody(required = true) Account registerRequest
    ) throws Exception {

        Optional<Account> doRegister = accountService.registerAccount(registerRequest);
        if (doRegister.isPresent()) {

            return ResponseEntity.status(HttpStatus.OK).body(doRegister.get());
        }

        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(("Could not register user"));
    }
    
    
    @GetMapping(path="/findByEmail", produces = MediaType.APPLICATION_JSON_VALUE) 
    public ResponseEntity<?>findByEmail(String email) {
        if(email==null) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could find without mail");
        }
        return ResponseEntity.ok(this.accountService.findByMail(email));
    }
}